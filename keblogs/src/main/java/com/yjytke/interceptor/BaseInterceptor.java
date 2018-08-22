package com.yjytke.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjytke.utils.Common;
import com.yjytke.utils.IPKit;


/**
 * @author wuynje
 * @time 2018年8月20日 下午2:51:02
 * @version 1.0
 * @description:初始化一些公共的内容
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseInterceptor.class);//slf4j日志
	private static final String USER_AGENT = "user-agent";
	@Autowired
	private Common common;//公共类，在conntroller后的postHandle塞到request里
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		LOGGER.info("UserAgent: {}", request.getHeader(USER_AGENT));
		LOGGER.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("common", common);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
