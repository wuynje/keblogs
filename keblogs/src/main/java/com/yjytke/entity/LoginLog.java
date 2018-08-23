package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月22日 下午4:47:29
 * @version 1.0
 * @description:登录日志
 */
public class LoginLog {
	
	private int id;
	
	/**
	 * 用户主键
	 */
	private int userid;
	
	/**
	 * 登录失败次数
	 */
	private int login_error_tale;
	
	/**
	 * 登录ip
	 */
	private String login_ip;
	
	/**
	 * 操作
	 */
	private String operator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getLogin_error_tale() {
		return login_error_tale;
	}

	public void setLogin_error_tale(int login_error_tale) {
		this.login_error_tale = login_error_tale;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	
}
