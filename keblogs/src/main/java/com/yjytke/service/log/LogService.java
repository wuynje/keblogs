package com.yjytke.service.log;

/**
 * @author wuynje
 * @time 2018年8月28日 下午3:38:41
 * @version 1.0
 * @description:后台日志服务接口
 */
public interface LogService {
	
	/**
	 * 添加操作日志
	 * @param ip
	 * @param operator
	 * @param userid
	 */
	void addLog(String ip, String operator,int userid);
	
}
