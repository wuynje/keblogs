package com.yjytke.service.content.imp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.WebConst;
import com.yjytke.dao.ContentDao;
import com.yjytke.entity.KeContent;
import com.yjytke.exception.BusinessException;
import com.yjytke.service.content.ContentService;
import com.yjytke.service.properties.PropertiesService;

/**
 * @author wuynje
 * @time 2018年8月31日 下午2:33:12
 * @version 1.0
 * @description:文章相关业务类
 */
@Service
public class ContentServiceImp implements ContentService {

	@Autowired
	private ContentDao contentDao;
	
	@Autowired
	private PropertiesService propertiesService;
	
	/**
	 * 添加文章
	 */
	@Transactional
	@Override
	public void addContent(KeContent keContent) {
		if (null == keContent)
			throw new BusinessException(ErrorConst.CONTENTPARAMISNULL);
		if (StringUtils.isBlank(keContent.getTitle()))
			throw new BusinessException(ErrorConst.CONTENTTITLEISNULL);
		if (keContent.getTitle().length() > WebConst.MAX_TITLE_COUNT)
			throw new BusinessException(ErrorConst.CONTENTTITLELENGTHERROR);
		if (StringUtils.isBlank(keContent.getContent()))
			throw new BusinessException(ErrorConst.CONTENTISNULL);
		if (keContent.getContent().length() > WebConst.MAX_TEXT_COUNT)
			throw new BusinessException(ErrorConst.CONTENTLENGTHERROE);
		//标签和分类
        String tags = keContent.getTags();
        String btype = keContent.getBtype();
        contentDao.addArticle(keContent);
        int id = keContent.getId();
        propertiesService.addProp(id, tags, WebConst.TypeProperties.TAG);
        propertiesService.addProp(id, btype, WebConst.TypeProperties.BTYPE);
	}

}
