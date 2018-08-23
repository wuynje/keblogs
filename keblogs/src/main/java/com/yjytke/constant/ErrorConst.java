package com.yjytke.constant;

/**
 * @author wuynje
 * @time 2018年8月22日 下午5:18:09
 * @version 1.0
 * @description:封装错误参数
 */
public enum ErrorConst {

	/**
	 * 用户名密码为空
	 */
	NAMEORPWODISNULL("1000","用户名密码不能为空"),
	/**
	 * 用户名或密码错误
	 */
	NAMEORPWODERROR("1001","用户名密码错误");
	
	private String errorCode;
	private String message;

	/**
	 * @param errorCode
	 * @param message
	 */
	private ErrorConst(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "["+this.errorCode+":"+this.message+"]";
	}
	
}
