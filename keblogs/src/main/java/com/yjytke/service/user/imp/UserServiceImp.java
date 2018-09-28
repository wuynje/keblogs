package com.yjytke.service.user.imp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.WebConst;
import com.yjytke.dao.UserDao;
import com.yjytke.entity.KeUser;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.user.UserService;
import com.yjytke.utils.GeneralUtil;

/**
 * @author wuynje
 * @time 2018年8月14日 下午8:01:00
 * @version 1.0
 * @description:
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 登录
	 * 1.判断用户名密码为空
	 * 2.判断用户是否存在
	 * 3.判断是否在可以登录的时间
	 * 4.判断密码输入错误次数
	 * 5.判断用户名密码是否正确
	 */
	@Transactional
	@Override
	public KeUser login(String username, String password){
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			throw new BusinessException(ErrorConst.NAMEORPWODISNULL);
		}
		KeUser keUserA = userDao.login(username, null);
		if(null == keUserA)
			throw new BusinessException(ErrorConst.NAMENOTEXIT);
		if(GeneralUtil.getSubTime(keUserA.getLogin_time())/1000 > WebConst.LOGGER_ERROR_MAX_TIME)
			userDao.addLoginErrorSum(keUserA.getAccount_number(), WebConst.RESET, GeneralUtil.getcurrenttime());
		else {
			if(keUserA.getLogin_error_tale() >= WebConst.ERROR_TIME)
				throw new BusinessException(ErrorConst.PAWWORRDERROROVERTHREE);
		}
		KeUser keUserB = userDao.login(username, password);
		if(null == keUserB) {
			userDao.addLoginErrorSum(username,WebConst.ADD,GeneralUtil.getcurrenttime());
		}
		return keUserB;
	}
	
	/**
	 * 重设密码错误次数为0
	 */
	@Transactional
	@Override
	public void resetPwdErrSum(KeUser user, int isadd) {
		userDao.addLoginErrorSum(user.getAccount_number(), isadd,GeneralUtil.getcurrenttime());
	}

	@Override
	public KeUser findUserByUsername(String username) {

		return userDao.login(username, null);
	}

	@Override
	public KeUser findUserByUseID(Integer userid) {
		return userDao.getUserByID(userid);
	}

}
