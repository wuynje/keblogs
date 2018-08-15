package com.yjytke.service.user;

import com.github.pagehelper.PageInfo;
import com.yjytke.entity.KeUser;

/**
 * @author wuynje
 * @time 2018年8月14日 下午7:58:35
 * @version 1.0
 * @description:
 */
public interface UserService {
	
	int addUser(KeUser user);
	
	PageInfo<KeUser> findAllUser(int pageNum, int pageSize);
	
}
