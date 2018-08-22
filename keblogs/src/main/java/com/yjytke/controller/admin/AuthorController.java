package com.yjytke.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月21日 下午6:51:03
 * @version 1.0
 * @description:登录相关
 */
@Api("登录相关")
@Controller
@RequestMapping("/admin")
public class AuthorController {
	
	@ApiOperation("跳转登录")
	@GetMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@ApiOperation("登录操作")
	@ResponseBody
	@PostMapping("/login")
	public String toLogin(
			HttpServletRequest request,
			HttpServletResponse response,
			@ApiParam(name="username", value = "用户名", required = true)
			@RequestParam(name="username",required = true)String username,
			@ApiParam(name="password", value = "密码", required = true)
			@RequestParam(name="password",required = true)String password,
			@ApiParam(name="remeber_me", value = "记住我", required = true)
			@RequestParam(name="remeber_me",required = false)String remeber_me
			) {
		
		return null;
	}

}
