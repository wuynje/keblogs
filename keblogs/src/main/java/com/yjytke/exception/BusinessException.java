package com.yjytke.exception;

import com.yjytke.constant.ErrorConst;

/**
 * @author wuynje
 * @time 2018年8月15日 下午2:45:12
 * @version 1.0
 * @description:业务类异常
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 7982405219655142959L;

	private String error_code;
	
	public BusinessException() {
		super("业务异常，请检查");
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	/**
	 * 默认code为9999，需要在ErrorConst枚举类中定义
	 * @param o
	 */
	public BusinessException(Object o) {
		super(o.toString());
		if(o instanceof ErrorConst) 
			this.setError_code(((ErrorConst)o).getErrorCode());
		else
			setError_code("9999");
	}
	
	public BusinessException(String message, String errorCode) {
		super(message);
		this.setError_code(errorCode);
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	

}
