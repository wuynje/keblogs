package com.yjytke.service.log.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjytke.dao.LogDao;
import com.yjytke.entity.KeLog;
import com.yjytke.service.log.LogService;

/**
 * @author wuynje
 * @time 2018年8月28日 下午3:59:45
 * @version 1.0
 * @description:
 */
@Service
public class LogServiceImp implements LogService {

	@Autowired
	private LogDao dao;
	
	@Transactional
	@Override
	public void addLog(String ip, String operator, int userid) {
		KeLog log = new KeLog();
		log.setUserid(userid);
		log.setLogin_ip(ip);
		log.setOperator(operator);
		log.setTs(new Date(System.currentTimeMillis()));
		dao.addLog(log);
	}

}
