package com.yjytke.service.cprelation.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yjytke.constant.ErrorConst;
import com.yjytke.dao.CpRelationDao;
import com.yjytke.entity.KeCpRelation;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.cprelation.CpRelationService;

/**
 * @author wuynje
 * @time 2018年9月3日 下午3:25:19
 * @version 1.0
 * @description:文章属性关系映射服务类
 */
public class CprelationServiceImp implements CpRelationService {

	@Autowired
	private CpRelationDao dao;
	
	@Transactional
	@Override
	public void addCp(KeCpRelation cpRelation) {
		if(cpRelation == null)
			throw new BusinessException(ErrorConst.PARAMISNULL);
		dao.insert(cpRelation);
	}
}
