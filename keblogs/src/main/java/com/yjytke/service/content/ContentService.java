package com.yjytke.service.content;

import com.github.pagehelper.PageInfo;
import com.yjytke.entity.KeContent;

/**
 * @author wuynje
 * @time 2018年8月31日 下午2:32:43
 * @version 1.0
 * @description:文章服务类接口
 */
public interface ContentService {

	/**
	 * 添加文章
	 * @param keContent
	 */
	void addContent(KeContent keContent);

	/**
	 * 获取文章列表
	 * @param page
	 * @param limit
	 * @param userid
	 * @return
	 */
	PageInfo<KeContent> getArticles(int page, int limit, int userid);

	/**根据id获取博文
	 * @param cid
	 */
	KeContent getArticleById(int cid);

}
