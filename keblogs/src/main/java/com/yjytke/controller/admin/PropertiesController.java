package com.yjytke.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjytke.constant.AjaxReturnCode;
import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeProperties;
import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.properties.PropertiesService;
import com.yjytke.utils.ApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年9月25日 下午8:19:12
 * @version 1.0
 * @description:博文分类
 */
@Api(value = "博文分类相关")
@Controller
@RequestMapping(value = "/admin/props")
public class PropertiesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesController.class);
	
	@Autowired
	private PropertiesService propertiesService;
	
	@ApiOperation("跳转分类和标签页")
	@GetMapping("")
	public String btypeIndex(HttpServletRequest request) {
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		List<KeProperties> btypes = propertiesService.getTagAndBtype(WebConst.TypeProperties.BTYPE, userid);
		List<KeProperties> tags = propertiesService.getTagAndBtype(WebConst.TypeProperties.TAG, userid);
		request.setAttribute("btypes", btypes);
		request.setAttribute("tags", tags);
		LOGGER.info("action : {}","跳转分类标签页面");
		return "admin/category";
	}
	
	@ApiOperation("保存博文分类")
	@PostMapping("save")
	@ResponseBody
	public ApiResponse save(HttpServletRequest request,
			@ApiParam(name = "mid", value = "分类编号",required = false) 
			@RequestParam(name = "mid", required = false)
			Integer mid,
			@ApiParam(name = "cname", value = "分类名称",required = true)
			@RequestParam(name = "cname",required = true)
			String cname) {
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		try {
			propertiesService.saveProp(cname, mid, userid,WebConst.TypeProperties.BTYPE);
		} catch (BusinessException e) {
			LOGGER.error(e.getMessage());
			return new ApiResponse(AjaxReturnCode.Common.FAIL,e.getMessage());
		}
		return new ApiResponse(AjaxReturnCode.Common.SUCCESS);
	}
	
	
	@ApiOperation("删除属性")
	@PostMapping("delete")
	@ResponseBody
	public ApiResponse delete(HttpServletRequest request,
			@ApiParam(name = "mid", value = "分类编号",required = false) 
			@RequestParam(name = "mid", required = false)
			Integer mid) {
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		try {
			propertiesService.deletePorp(mid,userid);
		} catch (BusinessException e) {
			LOGGER.error(e.getMessage());
			return new ApiResponse(AjaxReturnCode.Common.FAIL,e.getMessage());
		}
		return new ApiResponse(AjaxReturnCode.Common.SUCCESS);
	}
	
}
