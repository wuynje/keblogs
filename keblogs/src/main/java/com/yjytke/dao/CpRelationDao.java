package com.yjytke.dao;

import java.util.List;

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

	/**
	 * 根据博文id和属性id删除关系
	 * @param contentId
	 * @param propId
	 */
	void deleteByContentIdAndPropID(Integer contentId, Integer propId);

	/**
	 *  根据博文id删除关联关系
	 *  不可跟上面删除方法通用的原因是
	 *上面方法并不是动态sql，没有if
	 *如果通用可能会导致误删
	 * @param id
	 */
	void deleteByContentId(Integer id);

	/**
	 * 根据属性ID删除对应的关系
	 * @param mid
	 */
	void deleteByPropID(Integer mid);

	/**
	 * 查询属性是否被引用
	 * @param mid
	 * @return
	 */
	List<KeCpRelation> getCprelationsByPropID(Integer mid, Integer userid);
	
}
