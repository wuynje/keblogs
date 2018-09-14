package com.yjytke.service.properties.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Cacheable(value = "tagsAndType")
	public List<KeProperties> getTagAndTypeAndLink(String tag, String btype, String link, int userid) {
		List<KeProperties> properties = proDao.getTagAndTypeAndLink(tag, btype, link, userid);
		if (properties != null && properties.size() > 0) {
			return properties;
		} else {
			return null;
		}
	}

	/**
	 * 为博文添加属性
	 */
	@Transactional
	@Override
	@CacheEvict(value = { "tagsAndType" }, beforeInvocation = true, allEntries = true)
	public void addProp(KeContent content, String rea_value, String type) {
		List<KeProperties> props = proDao.getPropByContent(content);
		List<KeProperties> propType = new ArrayList<KeProperties>();// 将获取的属性按照类型取出来
		for (KeProperties p : props) {
			if (p.getType().equals(type)) {
				propType.add(p);
			}
		}
		/**传入的rea_value为空**/
		if (StringUtils.isBlank(rea_value) && propType.size()==0) {//如果属性为空;
			return;
		}
		if (StringUtils.isBlank(rea_value) && propType.size()>0) {//新编辑的属性为空，已经存在属性，直接全部删除;
			for(KeProperties p : propType) {
				cprelationDao.deleteByContentIdAndPropID(content.getId(), p.getId());
			}
			return;
		}
		/**传入的rea_value不为空**/
		String[] str = rea_value.split(",");
		List<String> strListArray = Arrays.asList(str);
		List<String> strList = new ArrayList<String>(strListArray);//必须进行一次new arrayList，因为Arrays.asList方法返回的ArrayList的add,remove等方法直接跑出异常
		/**
		 * 如果没有相应的属性，一般为新增
		 */
		if (propType.size() == 0) {
			this.newPropAdd(strList, content, type);
		}else {
			/**
			 * 如果该博文有相应的属性，一般为修改
			 */
			Set<KeProperties> propSet = new HashSet<KeProperties>();//存放要删除的属性
			for(KeProperties p : propType) {
				if(strList.contains(p.getRea_value())) {
					strList.remove(p.getRea_value());//remove之后的strList中只有需要新增的属性
				}else {
					propSet.add(p);
				}
			}
			this.newPropAdd(strList, content, type);
			for(KeProperties p : propSet) {
				cprelationDao.deleteByContentIdAndPropID(content.getId(), p.getId());
			}
		}
	}

	/**
	 * 根据文章获取相应标签和分类
	 */
	@Override
	public List<KeProperties> getPropByContent(KeContent content) {
		List<KeProperties> properties = proDao.getPropByContent(content);
		if (properties != null && properties.size() > 0) {
			return properties;
		} else {
			return null;
		}
	}
	
	
	/**
	 * 需要新增的属性
	 * @param strList
	 * @param content
	 * @param type
	 */
	private void newPropAdd(List<String> strList, KeContent content, String type) {
		for (String s : strList) {
			KeCpRelation cpRelation = new KeCpRelation();
			cpRelation.setContentid(content.getId());
			cpRelation.setUserid(content.getUserid());
			KeProperties prop = proDao.getPropByValueAndUserid(s, content.getUserid());
			if (null != prop) {
				cpRelation.setPropertiesid(prop.getId());
			} else {
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
	
	
}
