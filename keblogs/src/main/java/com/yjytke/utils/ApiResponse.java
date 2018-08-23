package com.yjytke.utils;

import io.swagger.annotations.Api;

/**
 * @author wuynje
 * @time 2018年8月21日 下午7:39:36
 * @version 1.0
 * @description:返回json的封装类
 */
@Api("返回的参数封装类")
public class ApiResponse {
	
	private String code;
	private String msg;
	private Object data;
	
	
	public ApiResponse(String code) {
		this.code = code;
	}
	
	public ApiResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public ApiResponse(String code, Object data) {
		this.code = code;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
