package com.yjytke.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjytke.constant.AjaxReturnCode;
import com.yjytke.utils.ApiResponse;

/**
 * @author wuynje
 * @time 2018年8月27日 上午9:54:47
 * @version 1.0
 * @description:统一异常处理，未在controller处理的异常全部在此进行处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class); 
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ApiResponse exceptionHandler(Exception e) {
		e.printStackTrace();
		LOGGER.error("find exception:e={}",e.getMessage());
		return new ApiResponse(AjaxReturnCode.errorCode.ERROR, "请求错误。");
	}
	
}
