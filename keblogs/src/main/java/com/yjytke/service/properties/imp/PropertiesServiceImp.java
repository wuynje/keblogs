package com.yjytke.service.properties.imp;

import java.util.ArrayList;
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
	public void addProp(KeContent content, String rea_value, String type) {
		if(StringUtils.isBlank(rea_value))
			//TODO删除所有的关系
			return;
		String[] str = rea_value.split(",");
		List<KeProperties> props = proDao.getPropByContent(content);
		List<KeProperties> propType = new ArrayList<KeProperties>();//将获取的属性按照类型取出来
		for(KeProperties p :props) {
			if(p.getType().equals(type)) {
				propType.add(p);
			}
		}
		
		/**
		 * 如果没有相应的属性，一般为新增
		 */
		if(propType.size() == 0) {
			for(String s : str) {
				KeCpRelation cpRelation = new KeCpRelation();
				cpRelation.setContentid(content.getId());
				cpRelation.setUserid(content.getUserid());
				KeProperties prop = proDao.getPropByValueAndUserid(s, content.getUserid());
				if(null != prop) {
					cpRelation.setPropertiesid(prop.getId());
				}else {
					KeProperties addprop = new KeProperties();
					addprop.setType(type);
					addprop.setRea_value(s);
					addprop.setUserid(content.getUserid());
					proDao.insertProp(addprop);
					cpRelation.setPropertiesid(addprop.getId());
				}
				cprelationDao.insert(cpRelation);
			}
		}
		
		/**
		 * 如果该博文有相应的属性，一般为修改
		 */
		List<String> strList = new ArrayList<String>();
		for(String s : str) {
			for(KeProperties p :propType){
				if(s.equals(p.getRea_value())&&p.getType().equals(type)) { //如果已经存在，不做修改
					continue;
				}
				if(!StringUtils.equals(s, p.getRea_value())) {
					strList.add(s);
				}
				if((!StringUtils.equals(s, p.getRea_value()))&&s.equals(str[str.length-1])) { //如果不存在删除关联关系
					strList.remove(s);
					cprelationDao.deleteByContentIdAndPropID(content.getId(),p.getId());
				}
			}
			
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
