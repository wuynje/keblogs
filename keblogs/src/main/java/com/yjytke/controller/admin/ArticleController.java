package com.yjytke.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjytke.entity.KeProperties;
import com.yjytke.service.user.PropertiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuynje
 * @time 2018年8月29日 上午11:04:49
 * @version 1.0
 * @description:博客相关
 */
@Api("博客相关")
@Controller
@RequestMapping("/admin/article")
public class ArticleController {
	
	@Autowired
	private PropertiesService proService;
	
	@ApiOperation("发布博客")
	@RequestMapping("/publish")
	public String publish(HttpServletRequest request) {
		List<KeProperties> properties =  proService.getTagAndType();
		return "admin/article_edit";
	}
	
}
