package com.yjytke.constant;

/**
 * @author wuynje
 * @time 2018年8月22日 下午5:18:09
 * @version 1.0
 * @description:封装错误参数
 */
public enum ErrorConst {

	/**
	 * 用户名密码为空
	 */
	NAMEORPWODISNULL("1000","用户名密码不能为空"),
	/**
	 * 用户名或密码错误
	 */
	PASSWORDERROR("1001","密码错误"),
	/**
	 * 用户名不存在
	 */
	NAMENOTEXIT("1002","用户名不存在"),
	/**
	 * 密码输入错误超过3次
	 */
	PAWWORRDERROROVERTHREE("1003","密码输入错误超过3次，请5分钟后重新输入"),
	/**
	 * 文章参数为空
	 */
	CONTENTPARAMISNULL("2000"," 文章参数为空"),
	/**
	 * 文章标题为空
	 */
	CONTENTTITLEISNULL("2001"," 文章标题为空"),
	/**
	 * 标题长度过长
	 */
	CONTENTTITLELENGTHERROR("2002"," 标题长度过长"),
	/**
	 *文章内容为空
	 */
	CONTENTISNULL("2003"," 文章内容为空"),
	/**
	 *文章长度过长
	 */
	CONTENTLENGTHERROE("2003","文章长度过长"),
	/**
	 * 获取文章错误
	 */
	CONTENTIDISERROE("2004","获取文章错误"),
	/**
	 * 参数为空
	 */
	PARAMISNULL("3001","参数为空"),
	/**
	 * 属性内容为空
	 */
	PROPVALUEISNULL("4000","属性内容为空"),
	/**
	 * 属性内容已经存在
	 */
	PROPVALUEISEXIST("4001","内容已经存在"),
	/**
	 * 属性编码为空
	 */
	PROPIDISNULL("4002","属性编码为空"),
	/**
	 * 属性已经被引用，请先删除
	 */
	PROPINUSED("4003","属性已经被引用，请先删除"),
	/**
	 * 加密错误
	 */
	ADDAECERROR("8001","加密错误"),
	/**
	 * 上传失败
	 */
	UPLOADFAIL("7001","上传失败");
	private String errorCode;
	private String message;

	/**
	 * @param errorCode
	 * @param message
	 */
	private ErrorConst(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "["+this.errorCode+":"+this.message+"]";
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
