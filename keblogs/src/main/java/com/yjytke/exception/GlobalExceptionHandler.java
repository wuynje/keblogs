package com.yjytke.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wuynje
 * @time 2018年8月27日 上午9:54:47
 * @version 1.0
 * @description:统一异常处理，未在controller处理的异常全部在此进行处理 (controller层只处理businessException,非业务错误，将会在此处理提示，
 *                                               避免返回一些用户看不懂的异常，提升交互友好程度 )
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public void exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		LOGGER.error("find exception:e={}", e.getMessage());
		String errormsg = "请求错误，代码可能有问题。。。。。";
		if (e instanceof BusinessException) {
			errormsg = e.getMessage();
		}
		String requestType = request.getHeader("x-requested-with");//区分请求方式是AJAX异步请求，还是传统请求方式，异步的话Header区域会多一个x-requested-with属性
		try {
			if (requestType != null && requestType.equals("XMLHttpRequest")) {// 如果是异步请求
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("{\"code\": \"fail\", \"msg\":\"" + errormsg + "\"}");
			} else {
				request.setAttribute("errormsg", errormsg);
				//非异步请求的话，直接返回500，这里有个问题，不知道为什么有时候会返回400页面。可能页面没有跳转，js就直接控制返回404页面了，
				//在400，500页面都取同样的request的name值，这样不影响结果。先不管了就这样吧，
				request.getRequestDispatcher("error/500").forward(request, response);
			}
		} catch (IOException | ServletException e1) {
			LOGGER.error(e1.getMessage());
		}
	}

}
