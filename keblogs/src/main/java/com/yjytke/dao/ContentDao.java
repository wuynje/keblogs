package com.yjytke.dao;

import com.yjytke.entity.KeContent;

/**
 * @author wuynje
 * @time 2018年8月31日 下午2:31:45
 * @version 1.0
 * @description:文章持久层
 */
public interface ContentDao {
	
	/**
	 *新增博客
	 * @param content
	 */
	void addArticle(KeContent content);
	
}
