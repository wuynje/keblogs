package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月14日 下午1:31:24
 * @version 1.0
 * @description:用户基本信息类
 */
public class KeUser {
	
	/**
	 * 唯一，账户
	 */
	private String account_number;
	
	/**
	 * 昵称
	 */
	private String nick_name;
	/**
	 * 头像路径
	 */
	private String avatar;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 密码
	 */
	private String account_password;
	
	/**
	 * 手机号
	 */
	private String phone_number;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 上次登录时间s
	 */
	private String login_time;
	
	/**
	 * 删除标志
	 */
	private int dr;
	
	/**
	 * 创建时间
	 */
	private String ts;

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public Integer getDr() {
		return dr;
	}

	public void setDr(Integer dr) {
		this.dr = 0;
		this.dr = dr;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	
}
