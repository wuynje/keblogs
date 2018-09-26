package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月29日 下午2:54:08
 * @version 1.0
 * @description:文章标签，分类，链接等
 */
public class KeProperties {
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 内容
	 */
	private String rea_value;
	
	/**
	 * 链接排序
	 */
	private int sort;
	
	/**
	 * 相应标识logo等图标
	 */
	private String picture;
	
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 用户主键
	 */
	private int userid;
	
	/**
	 *被引用的次数 
	 */
	private int count;	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRea_value() {
		return rea_value;
	}

	public void setRea_value(String rea_value) {
		this.rea_value = rea_value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
