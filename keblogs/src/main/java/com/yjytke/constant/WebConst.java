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
}
