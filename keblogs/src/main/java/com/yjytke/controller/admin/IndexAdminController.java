package com.yjytke.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuynje
 * @time 2018年8月20日 上午10:30:16
 * @version 1.0
 * @description:后台首页
 */
@Controller
public class IndexAdminController {
	
	@RequestMapping("admin/index")
	public String getIndexAdmin() {
		return "admin/index";
	}
	
}
