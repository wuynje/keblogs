package com.yjytke.service.user.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjytke.constant.WebConst;
import com.yjytke.dao.PropertiesDao;
import com.yjytke.entity.KeProperties;
import com.yjytke.service.user.PropertiesService;

/**
 * @author wuynje
 * @time 2018年8月29日 下午4:46:20
 * @version 1.0
 * @description:文章标签，分类，链接等的业务类
 */
@Service
public class PropertiesServiceImp implements PropertiesService {
	
	@Autowired
	private PropertiesDao proDao;
	
	/**
	 * 获取标签和分类
	 */
	@Override
	public List<KeProperties> getTagAndType() {
		List<KeProperties> properties = proDao.getTagAndType(WebConst.TypeProperties.TAG,WebConst.TypeProperties.BTYPE);
		return null;
	}
	
	
}
