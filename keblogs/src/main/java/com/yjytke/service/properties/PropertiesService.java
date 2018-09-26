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
	 * 查询tag,博客分类,链接
	 * @param userid 
	 * @return
	 */
	List<KeProperties> getTagAndTypeAndLink(String tag, String btype, String link, int userid);

	/**
	 * 给文章新增属性
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

	/**
	 * 获取分类以及count
	 * @param btype
	 * @param userid
	 * @return
	 */
	List<KeProperties> getTagAndBtype(String type, int userid);

	/**
	 * 新增属性
	 * @param cname
	 * @param mid
	 * @param userid
	 * @param btype
	 */
	void saveProp(String cname, Integer mid, int userid, String btype);

	/**
	 * 删除属性
	 * @param mid
	 * @param userid
	 */
	void deletePorp(Integer mid, int userid);


}
