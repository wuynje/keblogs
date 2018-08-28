package com.yjytke.constant;

/**
 * @author wuynje
 * @time 2018年8月28日 下午4:02:09
 * @version 1.0
 * @description:后台日志操作
 */
public enum LogActions {
	
	/**
	 * 后台登录
	 */
	MANAGERLOGIN("后台登录"),
	
	/**
	 * 发布博客
	 */
	PUBLISHBLOG("发布博客");
	
	private String action;
	
	LogActions(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return action;
	}
	
}
