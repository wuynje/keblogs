package com.yjytke.controller.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@ApiOperation("跳转文件上传页面")
	@GetMapping("/files")
	public String fileIndex() {
		
		
		return "admin/attach";
	}
	
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
			KeUser user = (KeUser)request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
			String fileName = GeneralUtil.getFileNameKey(file.getOriginalFilename(),
					WebConst.FileSource.CONTENT,user.getAccount_number());//拼接后的文件名，包含文件在云存储的路径
			String fKey = TenCentCloudService.uploadFile(file,fileName,request.getContentLength());
			KeFile keFile = new KeFile();
			keFile.setFkey(fKey);
			keFile.setFname(file.getOriginalFilename());
			keFile.setCreated(new Date(System.currentTimeMillis()));
			keFile.setUserId(user.getId());
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
