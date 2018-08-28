package com.yjytke.dao;

import java.util.List;

import com.yjytke.entity.KeUser;

/**
 * @author wuynje
 * @time 2018年8月14日 下午6:28:50
 * @version 1.0
 * @description:
 */
public interface UserDao {
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	KeUser login(String username, String password);
	
	/**
	 * 重设密码登录次数
	 * @param username
	 * @param isadd
	 * @param login_time
	 */
	void addLoginErrorSum(String username, int isadd, long login_time);
	
	int insert (KeUser user);
	
	List<KeUser> selectUsers();
}
