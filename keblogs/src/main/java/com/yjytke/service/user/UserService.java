package com.yjytke.service.user;

import com.github.pagehelper.PageInfo;
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
	
	int addUser(KeUser user);
	
	PageInfo<KeUser> findAllUser(int pageNum, int pageSize);
	
	void resetPwdErrSum(KeUser user);
	
}
