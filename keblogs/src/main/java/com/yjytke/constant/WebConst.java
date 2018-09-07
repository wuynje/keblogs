package com.yjytke.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebConst {

	/**
	 * 一些网站配置
	 */
	public static Map<String, String> initConfig = new HashMap<>();

	/**
	 * session的key
	 */
	public static String LOGIN_SESSION_KEY = "login_user";

	public static final String USER_IN_COOKIE = "ACCT";

	/**
	 * aes加密key,ase比des安全
	 */
	public static String AES_KEY = "keblogs112993";
	
	/**
	 * 生成随机字符串的取值
	 */
	public static String RANDOMCHAR = "abcdefghijklmnopqABCDEF"
			+ "GHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**
	 * 增加登录错误次数标识
	 */
	public static final int ADD = 1;
	/**
	 * 重设登录错误次数标识
	 */
	public static final int RESET = 0;
	/**
	 * 登录错误次数
	 */
	public static final int ERROR_TIME = 3;
	/**
	 * 登录错误N次后再次登录间隔时间
	 */
	public static final int LOGGER_ERROR_MAX_TIME = 5 * 60;
	/**
	 * 最大获取文章条数
	 */
	public static final int MAX_POSTS = 9999;

	/**
	 * 最大页码
	 */
	public static final int MAX_PAGE = 100;

	/**
	 * 文章最多可以输入的文字数
	 */
	public static final int MAX_TEXT_COUNT = 200000;

	/**
	 * 文章标题最多可以输入的文字个数
	 */
	public static final int MAX_TITLE_COUNT = 200;

	/**
	 * 点击次数超过多少更新到数据库
	 */
	public static final int HIT_EXCEED = 10;

	/**
	 * 上传文件最大1M
	 */
	public static Integer MAX_FILE_SIZE = 1048576;
	
	/**
	 * 
	 * @author wuynje
	 * @time 2018年8月29日 下午4:33:55
	 * @version 1.0
	 * @description:对应的通用类型
	 */
	public interface TypeProperties{
		/**
		 * 链接
		 */
		String LINK="link"; 
		/**
		 * 标签
		 */
		String TAG="tag"; 
		/**
		 * 博客分类
		 */
		String BTYPE="blogtype"; 
	}
	
	public interface FileType{
		/**
		 * 图片
		 */
		String IMG = "img";
		/**
		 * 一般压缩文件
		 */
		String YS = "ysfile";
	}
	
	public interface Articletype{
		/**
		 * 博文
		 */
		String BLOG = "blogs";
		/**
		 * 生活
		 */
		String LIFE = "life";
	}
	
}
