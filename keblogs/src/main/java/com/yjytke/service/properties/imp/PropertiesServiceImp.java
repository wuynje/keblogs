package com.yjytke.service.properties.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yjytke.dao.PropertiesDao;
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
	
	/**
	 * 获取标签和分类
	 */
	@Override
	@Cacheable(value="tagsAndType",key="#p0+#p1")
	public List<KeProperties> getTagAndType(String tag,String btype,int userid) {
		List<KeProperties> properties = proDao.getTagAndType(tag,btype,userid);
		if(properties != null && properties.size() > 0 ) {
			return properties;
		}else {
			return null;
		}
	}

	@Override
	public void addProp(int id, String tags, String tag) {
		// TODO Auto-generated method stub
		
	}
	
	
}
