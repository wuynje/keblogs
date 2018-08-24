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
	
	KeUser login(String username, String password);
	
	void addLoginErrorSum(String username, String password, long login_time);
	
	int insert (KeUser user);
	
	List<KeUser> selectUsers();
}
