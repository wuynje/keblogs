package com.yjytke.service.properties;

import java.util.List;

import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeProperties;

/**
 * @author wuynje
 * @time 2018年8月29日 下午4:45:17
 * @version 1.0
 * @description:
 */
public interface PropertiesService {

	/**
	 * 查询tag和博客分类
	 * @param userid 
	 * @return
	 */
	List<KeProperties> getTagAndType(String tag, String btype, int userid);

	/**
	 * 新增属性
	 * @param content
	 * @param rea_value
	 * @param type
	 */
	void addProp(KeContent content, String rea_value, String type);

	/**
	 * 根据文章获取相关属性
	 * @param content
	 * @return
	 */
	List<KeProperties> getPropByContent(KeContent content);

}
