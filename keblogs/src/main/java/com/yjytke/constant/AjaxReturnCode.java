package com.yjytke.constant;

/**
 * @author wuynje
 * @time 2018年8月23日 上午10:51:28
 * @version 1.0
 * @description:异步调用返回的code
 */
public interface AjaxReturnCode {
	/**
	 * 登录返回的参数
	 */
	interface LoginCode{
		static final String LOGIN_SUCCESS = "success";
		static final String LOGIN_FAIL = "fail";
		static final String LOGIN_ERROR = "error";
	}
	interface errorCode{
		static final String ERROR = "error";//通用错误
	}
}
