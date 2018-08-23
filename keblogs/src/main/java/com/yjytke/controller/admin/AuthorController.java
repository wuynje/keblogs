package com.yjytke.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjytke.constant.AjaxReturnCode;
import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.user.UserService;
import com.yjytke.utils.ApiResponse;

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
@Scope("prototype")
@RequestMapping("/admin")
public class AuthorController {
	
	private static final Logger LOGGER = LogManager.getLogger(AuthorController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("跳转登录")
	@GetMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@ApiOperation("登录操作")
	@ResponseBody
	@PostMapping("/login")
	public ApiResponse toLogin(
			HttpServletRequest request,
			HttpServletResponse response,
			@ApiParam(name="username", value = "用户名", required = true)
			@RequestParam(name="username",required = true)String username,
			@ApiParam(name="password", value = "密码", required = true)
			@RequestParam(name="password",required = true)String password,
			@ApiParam(name="remeber_me", value = "记住我", required = true)
			@RequestParam(name="remeber_me",required = false)String remeber_me
			) {
		try {
			KeUser keUser = userService.login(username, password);
			//TODO记录登录日志
			
		} catch (Exception e) {
			return new ApiResponse(AjaxReturnCode.LoginCode.LOGIN_FAIL,e.getMessage());
		}
		return new ApiResponse(AjaxReturnCode.LoginCode.LOGIN_SUCCESS);
	}

}
