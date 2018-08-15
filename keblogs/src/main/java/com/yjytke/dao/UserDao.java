package com.yjytke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yjytke.entity.KeUser;

/**
 * @author wuynje
 * @time 2018年8月14日 下午6:28:50
 * @version 1.0
 * @description:
 */
//@Mapper
public interface UserDao {
	int insert (KeUser user);
	
	List<KeUser> selectUsers();
}
