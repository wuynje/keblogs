package com.yjytke.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuynje
 * @time 2018年8月20日 下午5:00:37
 * @version 1.0
 * @description:存放前台页面需要的方法，字段等
 */
@Api("公共类")
@Component
public class Common {
	
	private static Random random;
	
	@ApiOperation("获取0-max的随机数")
	public static String random(int max, String str) {
		random = new Random();
		return (random.nextInt(max-1)+1)+str;
	}
	
}
