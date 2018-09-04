package com.yjytke.service.cprelation;

import com.yjytke.entity.KeCpRelation;

/**
 * @author wuynje
 * @time 2018年9月3日 下午3:20:56
 * @version 1.0
 * @description:文章属性关系映射服务类
 */
public interface CpRelationService {
	
	/**
	 *新增
	 * @param cpRelation
	 */
	void addCp(KeCpRelation cpRelation);
	
}
