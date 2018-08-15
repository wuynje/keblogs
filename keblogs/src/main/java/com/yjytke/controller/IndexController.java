package com.yjytke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuynje
 * @time 2018年8月15日 下午2:20:27
 * @version 1.0
 * @description:首页控制
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String returnIndex(){
		return "comm/index";
	}
	
}
