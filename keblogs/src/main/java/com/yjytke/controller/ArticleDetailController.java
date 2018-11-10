package com.yjytke.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeUser;
import com.yjytke.service.content.ContentService;
import com.yjytke.service.user.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年9月4日 下午8:13:03
 * @version 1.0
 * @description:查看博文内容
 */
@Api("查看博文")
@Controller
public class ArticleDetailController {
	
	@Autowired
	private ContentService contentService;
	@Autowired
	private UserService userService;
	
	@ApiOperation("查看博文内容")
	@GetMapping("/blogs/article/{id}")
	public String getArticleDetail(HttpServletRequest request,
			@ApiParam(name = "id", required = true) @PathVariable(name = "id", required = true)Integer id
			) {
		KeContent content = contentService.getArticleById(id);
		request.setAttribute("article", content);
		if(null == request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)&&content != null) {
			KeUser user = userService.findUserByUseID(content.getUserid());
			request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
		}
		return "comm/generic";
	}
	
}
