package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月22日 下午4:47:29
 * @version 1.0
 * @description:后台日志
 */
public class KeLog {
	
	private int id;
	
	/**
	 * 用户主键
	 */
	private int userid;
	
	/**
	 * 登录ip
	 */
	private String login_ip;
	
	/**
	 * 操作
	 */
	private String operator;
	
	/**
	 * 创建时间
	 */
	private long ts;

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

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}
	
}
