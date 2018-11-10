package com.yjytke.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import com.yjytke.controller.BaseController;
import com.yjytke.entity.KeProperties;
import com.yjytke.entity.KeUser;
import com.yjytke.service.properties.PropertiesService;
import com.yjytke.utils.ApiResponse;
import com.yjytke.utils.PatternKit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年11月9日 下午1:49:11
 * @version 1.0
 * @description:友情链接的控制类
 */
@Api("友情链接")
@Controller
@RequestMapping("/admin/links")
public class LinkController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkController.class);
	@Autowired
	private PropertiesService propService;

	@GetMapping("")
	public String linkIndex(HttpServletRequest request) {
		KeUser user = this.getUserFromSession(request);
		List<KeProperties> links = propService.getTagAndTypeAndLink(null, null, WebConst.TypeProperties.LINK,
				user.getId());
		request.setAttribute("links", links);
		LOGGER.info("action：{}", "跳转友链界面。");
		return "admin/links";
	}

	@ApiOperation("友链保存")
	@PostMapping("/save")
	@ResponseBody
	public ApiResponse saveLink(
			HttpServletRequest request,
			@ApiParam(name = "id", value = "主键",required = false) @RequestParam(name = "id",required = false) Integer id,
			@ApiParam(name = "description", value = "链接描述") @RequestParam(name = "description") String description,
			@ApiParam(name = "url", value = "链接URL", required = true) @RequestParam(name = "url", required = true) String url,
			@ApiParam(name = "logo", value = "LOGO图片地址") @RequestParam(name = "logo") String logo,
			@ApiParam(name = "sort", value = "排序") @RequestParam(name = "sort") Integer sort) {
		if(StringUtils.isEmpty(url.trim()) || !PatternKit.isURL(url)) 
			return new ApiResponse(AjaxReturnCode.Common.FAIL, "URL地址格式错误！");
		KeProperties prop = new KeProperties();
		prop.setDescription(description);
		prop.setRea_value(url);
		prop.setPicture(logo);
		prop.setSort(sort);
		prop.setUserid(getUserFromSession(request)==null?0:getUserFromSession(request).getId());
		prop.setType(WebConst.TypeProperties.LINK);
		prop.setId(id);
		propService.saveProp(prop);
		return new ApiResponse(AjaxReturnCode.Common.SUCCESS, "链接保存成功。");
	}

}
