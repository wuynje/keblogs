package com.yjytke.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuynje
 * @time 2018年8月20日 上午10:30:16
 * @version 1.0
 * @description:后台首页
 */
@Api("后台首页")
@Controller
public class IndexAdminController {
	
	@ApiOperation("进入首页")
	@RequestMapping("admin/index")
	public String getIndexAdmin(HttpServletRequest request) {
		
		return "admin/index";
	}
	
}
