package com.yjytke.dao;

import java.util.List;

import com.yjytke.entity.KeContent;

/**
 * @author wuynje
 * @time 2018年8月31日 下午2:31:45
 * @version 1.0
 * @description:文章持久层
 */
public interface ContentDao {
	
	/**
	 *新增博文
	 * @param content
	 */
	void addArticle(KeContent content);

	/**
	 *查询博文列表
	 * @param userid
	 * @return
	 */
	List<KeContent> getArticlesByUser(int userid);

	/**
	 * 根据主键获取博文
	 * @param cid
	 * @return 
	 */
	KeContent getArticleByID(int cid);

	/**
	 * 修改博文
	 * @param keContent
	 */
	void updateContent(KeContent keContent);
	
}
