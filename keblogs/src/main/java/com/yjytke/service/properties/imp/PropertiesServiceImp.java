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

import com.yjytke.constant.ErrorConst;
import com.yjytke.dao.CpRelationDao;
import com.yjytke.dao.PropertiesDao;
import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeCpRelation;
import com.yjytke.entity.KeProperties;
import com.yjytke.exception.BusinessException;
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
	@Cacheable(value = "tagsAndType", key = "'tag_'+#p0+'btype_'+#p1+'link_'+#p2+'userid_'+#p3")
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
	@CacheEvict(value = { "tagsAndType","contentTagBtype","propsBytype" }, beforeInvocation = true, allEntries = true)
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
	@Cacheable(value = "contentTagBtype",key="'content_'+#p0")
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
			List<KeProperties> prop = proDao.getPropByValueAndUserid(s,type, content.getUserid());
			if (null != prop && prop.size() ==1 ) {
				cpRelation.setPropertiesid(prop.get(0).getId());
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

	
	@Override
	@Cacheable(value = "propsBytype", key = "'type_'+#p0+'userid_'+#p1")
	public List<KeProperties> getTagAndBtype(String type, int userid) {
		List<KeProperties> list = proDao.getProp(type,userid);
		return list;
	}

	@Override
	@CacheEvict(value = {"propsBytype","contentTagBtype","tagsAndType"}, beforeInvocation = true,allEntries = true)
	public void saveProp(String cname, Integer mid, int userid, String btype) {
		if(StringUtils.isEmpty(cname)) 
			throw new BusinessException(ErrorConst.PROPVALUEISNULL);
		List<KeProperties> props = proDao.getPropByValueAndUserid(cname, btype, userid);
		if(props != null && props.size() > 0) 
			throw new BusinessException(ErrorConst.PROPVALUEISEXIST);
		KeProperties prop = new KeProperties();
		prop.setId(mid);
		prop.setRea_value(cname);
		prop.setType(btype);
		prop.setUserid(userid);
		if(mid != null) 
			proDao.updateProp(prop);
		else
			proDao.insertProp(prop);
	}

	@Transactional
	@Override
	@CacheEvict(value = {"propsBytype","contentTagBtype","tagsAndType"},beforeInvocation = true,allEntries = true)
	public void deletePorp(Integer mid, int userid) {
		if(mid == null) 
			throw new BusinessException(ErrorConst.PROPIDISNULL);
		proDao.deletePropById(mid,userid);
		cprelationDao.deleteByPropID(mid);
	}
	
}
