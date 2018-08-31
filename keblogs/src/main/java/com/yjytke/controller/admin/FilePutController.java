package com.yjytke.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yjytke.api.TenCentCloudService;
import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeFile;
import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.file.FileService;
import com.yjytke.utils.GeneralUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月30日 下午6:34:44
 * @version 1.0
 * @description:文件上传
 */
@Api("文件上传")
@Controller
@RequestMapping("/admin")
public class FilePutController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FilePutController.class);
	
	
	@Autowired
	private FileService fileService;
	
	@ApiOperation("markdown文件上传")
	@PostMapping("/file/uploadfile")
	public void upLoadFile(HttpServletRequest request,
            HttpServletResponse response,
            @ApiParam(name = "editormd-image-file", value = "文件数组", required = true)
            @RequestParam(name = "editormd-image-file", required = true)
            MultipartFile file) {
		try {
			request.setCharacterEncoding( "utf-8" );
			response.setHeader( "Content-Type" , "text/html" );
			String fileName = GeneralUtil.getFileNameKey(file.getOriginalFilename());//拼接后的文件名，包含文件在云存储的路径
			String fKey = TenCentCloudService.uploadFile(file,fileName,request.getContentLength());
			KeFile keFile = new KeFile();
			keFile.setFkey(fKey);
			keFile.setFname(file.getOriginalFilename());
			keFile.setCreated(System.currentTimeMillis());
			keFile.setUserId(((KeUser)request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId());
			keFile.setFtype(WebConst.FileType.IMG);
			fileService.markEditorImgUpload(keFile);
			response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + keFile.getFkey() + "\"}" );
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			try {
				response.getWriter().write( "{\"success\":0}" );
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
				throw new BusinessException(ErrorConst.UPLOADFAIL);
			}
			throw new BusinessException(ErrorConst.UPLOADFAIL);
		}
	}
	
}
