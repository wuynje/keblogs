package com.yjytke.service.properties;

import java.util.List;

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
	 * @param id
	 * @param tags
	 * @param tag
	 */
	void addProp(int id, String tags, String tag);

}
