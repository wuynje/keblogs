package com.yjytke.utils;

import io.swagger.annotations.Api;

/**
 * @author wuynje
 * @time 2018年8月21日 下午7:39:36
 * @version 1.0
 * @description:返回的参数封装类
 */
@Api("返回的参数封装类")
public class ApiResponse {
	
	private String code;
	private String message;
	
	
	public ApiResponse(String code) {
		this.code = code;
	}
	
	public ApiResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * 登录返回的参数
	 */
	interface LoginCode{
		static final String LOGIN_SUCCESS = "success";
		static final String LOGIN_FAIL = "fail";
		static final String LOGIN_ERROR = "error";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
