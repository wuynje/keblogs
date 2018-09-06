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
	 * @param tag
	 * @param btype
	 * @return
	 */
	List<KeProperties> getTagAndType(String tag, String btype, int userid);
	
	/**
	 * 根据实际值和userid获取prop
	 * @param rea_value
	 * @param userid
	 * @return
	 */
	KeProperties getPropByValueAndUserid(String rea_value, int userid);
	
	/**
	 * 新增prop
	 * @param prop
	 */
	void insertProp(KeProperties prop);

	/**
	 * 查询属性根据博文
	 * @param content
	 * @return
	 */
	List<KeProperties> getPropByContent(KeContent content);
	
}
