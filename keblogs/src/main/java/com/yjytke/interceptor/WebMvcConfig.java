package com.yjytke.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wuynje
 * @time 2018年8月20日 下午2:55:06
 * @version 1.0
 * @description:拦截器配置
 */

@Component
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private BaseInterceptor baseInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(baseInterceptor);
	}
	
}
