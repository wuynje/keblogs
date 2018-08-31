package com.yjytke.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.WebConst;
import com.yjytke.exception.BusinessException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author wuynje
 * @time 2018年8月24日 下午1:52:31
 * @version 1.0
 * @description:一些规则的方法封装
 */
public class GeneralUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeneralUtil.class);

	/**
	 * 获取毫秒级别的时间
	 * 
	 * @return
	 */
	public static long getcurrenttime() {
		return System.currentTimeMillis();
	}

	/**
	 * 与当前时间的差
	 * 
	 * @return
	 */
	public static long getSubTime(long lasttime) {
		return System.currentTimeMillis() - lasttime;
	}

	/**
	 * 将timeMills转为Date
	 * 
	 * @param time
	 * @return
	 */
	public static String timeMillsToDate(long time) {
		DateFormat simplDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simplDateFormat.format(time);
	}
	
	/**
	 * 获取随机10位字符串
	 * @return
	 */
	public static String getStrRandom() {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< 10; i++) {
			int j = r.nextInt(WebConst.randomChar.length());
			sb.append(WebConst.randomChar.charAt(j));
		}
		return sb.toString();
	}

	/**
	 * 按照月份返回云存储路径
	 * @return
	 */
	public static String getPathByDate() {
		DateFormat simplDateFormat = new SimpleDateFormat("/yyyy/MM");
		return simplDateFormat.format(new Date());
	}
	
	/**
	 * 将用户的account加密存放到cookie中
	 * 
	 * @param response
	 * @param account
	 */
	public static void addCookies(HttpServletResponse response, String account, int expiry) {
		Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, encryptBasedAes(account));
		cookie.setMaxAge(expiry);
		cookie.setPath("/");// 设为'/'cookie可以在同一应用服务器共享
		cookie.setSecure(false);
		response.addCookie(cookie);
	}

	/**
	 * 从cookies中获取解密后的值
	 * @param request
	 * @param cookieKey
	 * @return
	 */
	public static String getUserBycookies(HttpServletRequest request, String cookieKey) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieKey)) {
					return aseDncode(cookie.getValue());
				}
			}
		}
		return null;
	}

	/**
	 * aes算法加密
	 * 
	 * @param account
	 * @return
	 */
	public static String encryptBasedAes(String account) {
		try {
			// 1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			// 2.根据ecnodeRules规则初始化密钥生成器
			// 生成一个128位的随机源,根据传入的字节数组
			keyGenerator.init(128, new SecureRandom(WebConst.AES_KEY.getBytes()));
			// 3.产生原始对称密钥
			SecretKey original_key = keyGenerator.generateKey();
			// 4.获得原始对称密钥的字节数组
			byte[] raw = original_key.getEncoded();
			// 5.根据字节数组生成AES密钥
			SecretKey key = new SecretKeySpec(raw, "AES");
			// 6.根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
			// 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte[] byte_encode = account.getBytes("utf-8");
			// 9.根据密码器的初始化方式--加密：将数据加密
			byte[] byte_AES = cipher.doFinal(byte_encode);
			// 10.将加密后的数据转换为字符串
			// 这里用Base64Encoder中会找不到包
			// 解决办法：
			// 在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
			String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
			// 11.将字符串返回
			return AES_encode;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(ErrorConst.ADDAECERROR);
		}
	}
	
	/**
	 * ase算法解密
	 * @param cookieValue
	 * @return
	 */
	public static String aseDncode(String cookieValue) {
		try {
			// 1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			// 2.根据ecnodeRules规则初始化密钥生成器
			// 生成一个128位的随机源,根据传入的字节数组
			keyGenerator.init(128, new SecureRandom(WebConst.AES_KEY.getBytes()));
			// 3.产生原始对称密钥
			SecretKey original_key = keyGenerator.generateKey();
			// 4.获得原始对称密钥的字节数组
			byte[] raw = original_key.getEncoded();
			// 5.根据字节数组生成AES密钥
			SecretKey key = new SecretKeySpec(raw, "AES");
			// 6.根据指定算法AES自成密码器
			Cipher cipher = Cipher.getInstance("AES");
			// 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 8.将加密并编码后的内容解码成字节数组
			 byte [] byte_content = new BASE64Decoder().decodeBuffer(cookieValue);
			// 9.解密
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, "utf-8");
			return AES_decode;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(ErrorConst.ADDAECERROR);
		}
	}
	
	/**
	 * md5加密
	 * @return
	 */
	public static String md5Code(String str) {
		  //确定计算方法
		String newstr = "";
        MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			throw new BusinessException(ErrorConst.ADDAECERROR);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			throw new BusinessException(ErrorConst.ADDAECERROR);
		}
        return newstr;
	}
	
	/**
	 * 生成存在云存储上的文件名
	 * @param fileName
	 * @return
	 */
	public static String getFileNameKey(String fileName) {
		String latsFileName = System.currentTimeMillis()+getStrRandom();
		return getPathByDate()+"/"+latsFileName+fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}

}
