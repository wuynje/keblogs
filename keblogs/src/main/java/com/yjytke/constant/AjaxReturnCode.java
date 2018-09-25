package com.yjytke.constant;

/**
 * @author wuynje
 * @time 2018年8月23日 上午10:51:28
 * @version 1.0
 * @description:异步调用返回的code
 */
public interface AjaxReturnCode {

	/**
	 * 通用返回的code、
	 */
	interface Common{
		static final String FAIL = "fail";//通用失败
		static final String SUCCESS = "success";//通用成功
		static final String ERROR = "error";//通用错误
	}
}
