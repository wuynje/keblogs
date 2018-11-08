package com.yjytke.service.user;

import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;

/**
 * @author wuynje
 * @time 2018年8月14日 下午7:58:35
 * @version 1.0
 * @description:
 */
public interface UserService {
	
	/**
	 * 根据账号密码登录
	 * @param username
	 * @param password
	 * @return
	 * @throws BusinessException 
	 */
	KeUser login(String username, String password);
	
	/**
	 * 重置密码错误次数
	 * @param user
	 * @param isadd
	 */
	void resetPwdErrSum(KeUser user, int isadd);
	
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	KeUser findUserByUsername(String username);
	
	/**
	 * 根据编号获取用户
	 * @param userid
	 * @return
	 */
	KeUser findUserByUseID(Integer userid);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUserProfile(KeUser user);
	
	/**
	 * 修改密码
	 * @param username
	 * @param oldpwd
	 * @param pwd
	 */
	void updatePwd(String username, String oldpwd, String pwd);
}
