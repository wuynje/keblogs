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
		static final String SUCCESS = "success";
		static final String FAIL = "fail";
		static final String ERROR = "error";
	}
	/**
	 * 添加文章返回的参数
	 */
	interface ContentCode{
		static final String SUCCESS = "success";
		static final String FAIL = "fail";
		static final String ERROR = "error";
	}
	
	interface errorCode{
		static final String FAIL = "fail";//通用错误
	}
}
