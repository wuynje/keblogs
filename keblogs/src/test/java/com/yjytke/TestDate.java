package com.yjytke;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuynje
 * @time 2018年8月14日 下午1:37:05
 * @version 1.0
 * @description:
 */
public class TestDate {
	public static void main(String[] args) {
		Long date = new Long("2018-09-01 12:12:12");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
	}
}
