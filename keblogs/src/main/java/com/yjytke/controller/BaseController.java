package com.yjytke.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeUser;

/**
 * @author wuynje
 * @time 2018年11月10日 下午2:25:21
 * @version 1.0
 * @description:Controller类的抽象类
 */
public abstract class BaseController {
	
	public KeUser getUserFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(null == session)
			return null;
		return (KeUser) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
	}
	
}
