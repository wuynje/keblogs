package com.yjytke.entity;

/**
 * @author wuynje
 * @time 2018年8月30日 下午5:46:25
 * @version 1.0
 * @description:博文实体
 */
public class KeContent {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 所属用户id
	 */
	private Integer userid;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 标题图片
     */
    private String titlePic;
    
    /**
     *   内容
     */
    private String content;
    
    /**
     * 文章类别：分为博文，生活
     */
    private String style;
    
	/**
	 * 内容类别
	 */
	private String btype;
	
	/**
	 * 文章状态：草稿，发布
	 */
	private String status;
	
	/**
	 * 标签列表
	 */
	private String tags;
	
	/**
	 * 创建时间
	 */
	private long created;
	
	/**
	 * 修改时间
	 */
	private long modifiedtime;
	
	/**
	 * 点击次数
	 */
	private int hits;
	
	/**
     * 是否允许评论
     */
    private Integer allowComment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitlePic() {
		return titlePic;
	}

	public void setTitlePic(String titlePic) {
		this.titlePic = titlePic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(long modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Integer getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	
}
