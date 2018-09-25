package com.yjytke.service.content.imp;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjytke.constant.ErrorConst;
import com.yjytke.constant.WebConst;
import com.yjytke.dao.ContentDao;
import com.yjytke.dao.CpRelationDao;
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
	private CpRelationDao cpRelationDao;
	
	@Autowired
	private PropertiesService propertiesService;

	/**
	 * 添加文章
	 */
	@Transactional
	@Override
	@CacheEvict(value = { "articles", "articlesBtype","articlestime" }, beforeInvocation = true, allEntries = true)
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
		// 标签和分类
		String tags = keContent.getTags();
		String btype = keContent.getBtype();
		keContent.setCreated(new Date(System.currentTimeMillis()));
		contentDao.addArticle(keContent);
		propertiesService.addProp(keContent, tags, WebConst.TypeProperties.TAG);
		propertiesService.addProp(keContent, btype, WebConst.TypeProperties.BTYPE);
	}

	/**
	 * 获取文章列表
	 */
	@Override
	@Cacheable(value = { "articles" }, key = "'page'+#p0+'limit'+#p1+'userid'+#p2")
	public PageInfo<KeContent> getArticles(int page, int limit, int userid) {
		PageHelper.startPage(page, limit);
		List<KeContent> articles = contentDao.getArticlesByUser(userid);
		PageInfo<KeContent> pageInfo = new PageInfo<KeContent>(articles);
		return pageInfo;
	}

	@Cacheable(value = { "article" }, key = "'cid'+#p0")
	@Override
	public KeContent getArticleById(int cid) {
		return contentDao.getArticleByID(cid);
	}

	@Transactional
	@CacheEvict(value = { "article", "articles", "articlesBtype" }, beforeInvocation = true, allEntries = true)
	@Override
	public void updateContentById(KeContent keContent) {
		if (keContent.getId() != null && keContent.getId() != 0) {
			keContent.setModifiedtime(new Date(System.currentTimeMillis()));
			contentDao.updateContent(keContent);
			// 标签和分类
			String tags = keContent.getTags();
			String btype = keContent.getBtype();
			keContent.setCreated(new Date(System.currentTimeMillis()));
			propertiesService.addProp(keContent, tags, WebConst.TypeProperties.TAG);
			propertiesService.addProp(keContent, btype, WebConst.TypeProperties.BTYPE);
		}
	}

	/**
	 * 根据主键删除博文
	 */
	@Transactional
	@Override
	@CacheEvict(value = { "article", "articles", "articlesBtype","articlestime" }, beforeInvocation = true, allEntries = true)
	public void deleteArticle(Integer id) {
		if(id==null||id==0) {
			throw new BusinessException(ErrorConst.CONTENTIDISERROE);
		}
		contentDao.deleteArticleById(id);
		cpRelationDao.deleteByContentId(id);
	}

	
	@Override
	@Cacheable(value = {"articlesBtype"}, key ="'page'+#p0+'limit'+#p1+'btypeid'+#p2+'userid'+#p3")
	public PageInfo<KeContent> getArticlesByUserIdAndPrpoId(int page, int limit, String btypeid, Integer userid) {
		PageHelper.startPage(page, limit);
		List<KeContent> articles = contentDao.getArticlesByUserAndBtype(btypeid,userid);
		PageInfo<KeContent> pageInfo = new PageInfo<KeContent>(articles);
		return pageInfo;
	}

	@Override
	@Cacheable(value = {"articlestime"}, key = "'userid'+#p0")
	public List<String> getTimeBase(Integer userid) {
		List<String> lists = contentDao.getTimeList(userid);
		return lists;
	}

	@Override
	public PageInfo<KeContent> getArticlesByUserIdAndTime(int page, int limit, String timevalue, Integer userid) {
		PageHelper.startPage(page, limit);
		List<KeContent> articles = contentDao.getarticleByUserAndTime(timevalue,userid);
		PageInfo<KeContent> pageInfo = new PageInfo<KeContent>(articles);
		return pageInfo;
	}
}
