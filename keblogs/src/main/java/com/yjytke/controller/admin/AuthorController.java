package com.yjytke.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.LogActions;
import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.log.LogService;
import com.yjytke.service.user.UserService;
import com.yjytke.utils.ApiResponse;
import com.yjytke.utils.GeneralUtil;
import com.yjytke.utils.IPKit;

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
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
		KeUser keUser=null;
		try {
			keUser = userService.login(username, password);
			if(keUser == null)//查不到的话，密码错误
				throw new BusinessException(ErrorConst.PASSWORDERROR);
			else {
				request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, keUser);//将登录的用户放到session
				if(StringUtils.isNoneBlank(remeber_me))
					GeneralUtil.addCookies(response, keUser.getAccount_number(), 60 * 30);//用户id存放到cookie
				userService.resetPwdErrSum(keUser,WebConst.RESET);//重置登录错误次数
			}
		} catch (BusinessException e) {
			LOGGER.error("login fail ,msg:{}",e.getMessage());
			return new ApiResponse(AjaxReturnCode.Common.FAIL,e.getMessage());
		}
		LOGGER.info("login success , time is {}",GeneralUtil.timeMillsToDate(System.currentTimeMillis()));
		/**登录成功添加登录日志**/
		logService.addLog(IPKit.getIpAddrByRequest(request), LogActions.MANAGERLOGIN.toString(), keUser.getId());
		return new ApiResponse(AjaxReturnCode.Common.SUCCESS);
	}

}
