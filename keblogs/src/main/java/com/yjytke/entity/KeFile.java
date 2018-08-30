package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月30日 下午6:54:42
 * @version 1.0
 * @description:附件实体类
 */
public class KeFile {
	
	private Integer id;
    /**
     * 文件名称
     */
    private String fname;
    /**
     * 文件类型
     */
    private String ftype;
    /**
     * 地址
     */
    private String fkey;
    /**
     * 上传人id
     */
    private Integer userId;
    /**
     * 创建时间
     */
    private long created;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFkey() {
		return fkey;
	}
	public void setFkey(String fkey) {
		this.fkey = fkey;
	}
	public long getCreated() {
		return created;
	}
	public void setCreated(long created) {
		this.created = created;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
}
