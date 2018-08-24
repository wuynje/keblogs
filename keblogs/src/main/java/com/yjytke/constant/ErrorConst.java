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
	PASSWORDERROR("1001","密码错误"),
	/**
	 * 用户名不存在
	 */
	NAMENOTEXIT("1002","用户名不存在"),
	/**
	 * 密码输入错误超过3次
	 */
	PAWWORRDERROROVERTHREE("1003","密码输入错误超过3次，请30秒后重新输入"),
	/**
	 * 加密错误
	 */
	ADDAECERROR("8001","加密错误");
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
