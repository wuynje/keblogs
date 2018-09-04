package com.yjytke.dao;

import com.yjytke.entity.KeCpRelation;

/**
 * @author wuynje
 * @time 2018年9月3日 下午3:18:34
 * @version 1.0
 * @description:文章和属性的映射类
 */
public interface CpRelationDao {
	
	/**
	 * 新增关系
	 * @param cpRelation
	 */
	void insert(KeCpRelation cpRelation);
	
}
