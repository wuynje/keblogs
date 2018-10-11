package com.yjytke.controller.admin;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;

import com.yjytke.api.TenCentCloudService;
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
import com.yjytke.utils.PatternKit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月21日 下午6:51:03
 * @version 1.0
 * @description:登录相关
 */
@Api("作者相关")
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
			
	@ApiOperation("注销")
	@GetMapping("/logout")
	public void logout(HttpServletRequest request,
			HttpSession session,HttpServletResponse response) {
		session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
		Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, null);
		cookie.setMaxAge(0);//立即销毁cookie
		cookie.setValue(null);
		cookie.setPath("/");
		response.addCookie(cookie);
		try {
			response.sendRedirect("/admin/login");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("error : {}, Exception : {}","注销失败",e);
		}
	}
	
	@ApiOperation("个人设置页面")
	@GetMapping("/profileset")
	public String profileIndex() {
		return "admin/profile";
		
	}
	
	@ApiOperation("保存个人信息")
	@ResponseBody
	@PostMapping("/profilesave")
	public ApiResponse saveUserProfile(
			@ApiParam(name = "nickname", value = "昵称") @RequestParam String nickname, 
			@ApiParam(name = "email", value = "邮箱") @RequestParam String email, 
			@ApiParam(name = "userpic", value = "头像") @RequestParam MultipartFile userpic,
			HttpServletRequest request) {
		KeUser user = (KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
		if(null == user)
			return new ApiResponse("fail", "帐号登录异常，保存失败");
		if(StringUtils.isEmpty(nickname))
			return new ApiResponse("fail", "昵称为空，保存失败");
		if(StringUtils.isEmpty(email)|| (!PatternKit.isEmail(email)))
			return new ApiResponse("fail", "邮箱格式错误，保存失败");
		String pickey = "";//照片保存后的返回路径
		if(userpic != null && (!StringUtils.isEmpty(userpic.getName()))) {
			String fileName = GeneralUtil.getFileNameKey(userpic.getOriginalFilename(), WebConst.FileSource.PHOTO, user.getAccount_number());
			try {
				pickey = TenCentCloudService.uploadFile(userpic, fileName, request.getContentLength());
			} catch (IOException e) {
				LOGGER.error("头像上传失败");
				return new ApiResponse("fail", "照片上传流错误，保存失败");
			}
		}
		if((!nickname.equals(user.getNick_name())) || (!email.equals(user.getEmail())) || (!StringUtils.isEmpty(pickey))) {//如果存在修改
			user.setNick_name(nickname);
			user.setEmail(email);
			user.setAvatar(pickey);
			userService.updateUserProfile(user);
		}
		return new ApiResponse("success");
	}
}
