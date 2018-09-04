package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年9月3日 上午10:44:39
 * @version 1.0
 * @description:博文属性关系类
 */
public class KeCpRelation {
	
	/**
	 * 文章主键
	 */
	private int contentid;
	
	/**
	 * 属性主键
	 */
	private int propertiesid;

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public int getPropertiesid() {
		return propertiesid;
	}

	public void setPropertiesid(int propertiesid) {
		this.propertiesid = propertiesid;
	}
	
	
	
}
