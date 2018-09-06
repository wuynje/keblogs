package com.yjytke.service.properties.imp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjytke.dao.CpRelationDao;
import com.yjytke.dao.PropertiesDao;
import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeCpRelation;
import com.yjytke.entity.KeProperties;
import com.yjytke.service.properties.PropertiesService;

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
	
	@Autowired
	private CpRelationDao cprelationDao;
	
	/**
	 * 获取标签和分类
	 */
	@Override
	@Cacheable(value="tagsAndType")
	public List<KeProperties> getTagAndType(String tag,String btype,int userid) {
		List<KeProperties> properties = proDao.getTagAndType(tag,btype,userid);
		if(properties != null && properties.size() > 0 ) {
			return properties;
		}else {
			return null;
		}
	}

	/**
	 * 为博文添加属性
	 */
	@Transactional
	@Override
	@CacheEvict(value= {"tagsAndType"},beforeInvocation = true, allEntries = true)
	public void addProp(int contentid, String rea_value, String type, Integer userid) {
		if(StringUtils.isBlank(rea_value))
			return;
		String[] str = rea_value.split(",");
		for(String s : str) {
			KeCpRelation cpRelation = new KeCpRelation();
			cpRelation.setContentid(contentid);
			cpRelation.setUserid(userid);
			KeProperties prop = proDao.getPropByValueAndUserid(s, userid);
			if(null != prop) {
				cpRelation.setPropertiesid(prop.getId());
			}else {
				KeProperties addprop = new KeProperties();
				addprop.setType(type);
				addprop.setRea_value(s);
				addprop.setUserid(userid);
				proDao.insertProp(addprop);
				cpRelation.setPropertiesid(addprop.getId());
			}
			cprelationDao.insert(cpRelation);
		}
	}

	
	/**
	 * 根据文章获取相应标签和分类
	 */
	@Override
	public List<KeProperties> getPropByContent(KeContent content) {
		List<KeProperties> properties = proDao.getPropByContent(content);
		if(properties != null && properties.size() > 0 ) {
			return properties;
		}else {
			return null;
		}
	}
	
}
