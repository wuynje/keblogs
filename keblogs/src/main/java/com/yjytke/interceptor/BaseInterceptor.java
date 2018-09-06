package com.yjytke.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeUser;
import com.yjytke.service.user.UserService;
import com.yjytke.utils.Common;
import com.yjytke.utils.GeneralUtil;
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
	@Autowired
	private GeneralUtil generalutil;//公共类，在conntroller后的postHandle塞到request里
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		LOGGER.info("UserAgent: {}", request.getHeader(USER_AGENT));
		LOGGER.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));
		/**
		 * 请求拦截处理
		 */
		if(uri.startsWith("/admin")&& !uri.startsWith("/admin/login")
                && !uri.startsWith("/admin/css") && !uri.startsWith("/admin/images")
                && !uri.startsWith("/admin/js") && !uri.startsWith("/admin/plugins")
                && !uri.startsWith("/admin/editormd")) {
			KeUser keUser = (KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
			if(keUser == null) {
				String username = GeneralUtil.getUserBycookies(request, WebConst.USER_IN_COOKIE);
				if(username != null) {
					keUser = userService.findUserByUsername(username);
					request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, keUser);
				}
			}
			if(keUser == null) {
				LOGGER.info("request fail {}","没有登录");
				response.sendRedirect(request.getContextPath() + "/admin/login");
				return false;
			}else {
				return true;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("common", common);
		request.setAttribute("generalutil", generalutil);
	}
	
	/**
	 * 整个请求完成后调用，可以用来清理资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
