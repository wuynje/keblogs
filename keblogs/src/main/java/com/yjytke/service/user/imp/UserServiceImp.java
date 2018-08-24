package com.yjytke.service.user.imp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjytke.constant.ErrorConst;
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
	
	@Override
	@Transactional
	public int addUser(KeUser user) {
		return userDao.insert(user);
	}


	@Override
	public PageInfo<KeUser> findAllUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        List<KeUser> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
	}


	/**
	 * 登录
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
		if(keUserA.getLogin_error_tale()>=3 &&
				GeneralUtil.getSubTime(keUserA.getLogin_time())/1000<30)
			throw new BusinessException(ErrorConst.PAWWORRDERROROVERTHREE);
		KeUser keUserB = userDao.login(username, password);
		if(null==keUserB) {
			userDao.addLoginErrorSum(username,null,GeneralUtil.getcurrenttime());
		}
		return keUserB;
	}
	
	/**
	 * 登录成功重设密码错误次数为0
	 */
	public void resetPwdErrSum(KeUser user) {
		userDao.addLoginErrorSum(user.getAccount_number(), user.getAccount_password(),GeneralUtil.getcurrenttime());
	}

}
