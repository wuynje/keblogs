package com.yjytke.dao;

import java.util.List;

import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeProperties;

/**
 * @author wuynje
 * @time 2018年8月29日 下午4:44:25
 * @version 1.0
 * @description:通用属性接口
 */
public interface PropertiesDao {

	/**
	 * 根据用户id获取所有属性
	 * 
	 * @param tag
	 * @param btype
	 * @param link
	 * @param userid
	 * @return
	 */
	List<KeProperties> getTagAndTypeAndLink(String tag, String btype, String link, int userid);

	/**
	 * 根据实际值和userid获取prop
	 * 
	 * @param rea_value
	 * @param userid
	 * @return
	 */
	List<KeProperties> getPropByValueAndUserid(String rea_value, String type, int userid);

	/**
	 * 新增prop
	 * 
	 * @param prop
	 */
	void insertProp(KeProperties prop);

	/**
	 * 查询属性根据博文
	 * 
	 * @param content
	 * @param type
	 * @return
	 */
	List<KeProperties> getPropByContent(KeContent content);

	/**
	 * 根据主键删除属性
	 * 
	 * @param id
	 */
	void deletePropById(Integer id, Integer userid);

	/**
	 * 根据用户id获取某种类型的属性
	 * 
	 * @param btype
	 * @param userid
	 * @return
	 */
	List<KeProperties> getProp(String type, int userid);

	/**
	 * 修改属性
	 * 
	 * @param prop
	 */
	void updateProp(KeProperties prop);

}
