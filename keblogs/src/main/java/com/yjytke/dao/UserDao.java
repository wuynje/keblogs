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

	/**
	 * 根据用户ID查询用户
	 * @param userid
	 * @return
	 */
	KeUser getUserByID(Integer userid);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void update(KeUser user);
}
