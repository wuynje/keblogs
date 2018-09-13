package com.yjytke.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.user.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月15日 下午2:20:27
 * @version 1.0
 * @description:首页控制
 */
@Api("首页相关")
@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{account}-index")
	public String returnIndex(HttpServletRequest request,
			@ApiParam(name = "account", value = "用户帐号", required = false) @PathVariable(name = "account", required = false) String account) {
		if(StringUtils.isEmpty(account)) {//没有账户直接返回查不到
			request.setAttribute("indexerror", "用户不存在，请输入正确的地址！");
//			return "error/404";
			throw new BusinessException();
		}
		KeUser user = userService.findUserByUsername(account);//根据账户查询用户
		if(null == user) {
			request.setAttribute("indexerror", "用户不存在，请输入正确的地址！");
			return "error/404";
		}
		
		return "comm/index";
	}

}
