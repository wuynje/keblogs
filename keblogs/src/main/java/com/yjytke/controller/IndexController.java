package com.yjytke.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeProperties;
import com.yjytke.entity.KeUser;
import com.yjytke.service.content.ContentService;
import com.yjytke.service.properties.PropertiesService;
import com.yjytke.service.user.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月15日 下午2:20:27
 * @version 1.0
 * @description:首页控制
 */
@Api("首页相关")
@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private ContentService contentService;

	@Autowired
	private PropertiesService propertiesService;

	@ApiOperation("首页内容显示")
	@RequestMapping(value = {"/index/{account}","/index/{account}/btype/{btypeid}",
			"/index/{account}/tag/{tagid}","/index/{account}/time/{timevalue}"})
	public String returnIndex(HttpServletRequest request,
			@ApiParam(name = "account", value = "用户帐号", required = false) @PathVariable(name = "account", required = false) String account,
			@ApiParam(name = "btypeid", value = "博文分类id", required = false) @PathVariable(name = "btypeid", required = false) String btypeid,
			@ApiParam(name = "tagid", value = "标签id", required = false) @PathVariable(name = "tagid", required = false) String tagid,
			@ApiParam(name = "timevalue", value = "时间", required = false) @PathVariable(name = "timevalue", required = false) String timevalue,
			@ApiParam(name = "page", value = "页数", required = false) @RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@ApiParam(name = "limit", value = "每页数量", required = false) @RequestParam(name = "limit", required = false, defaultValue = "6") int limit) {
		if (StringUtils.isEmpty(account)) {// 没有账户直接返回查不到
			request.setAttribute("indexerror", "用户不存在，请输入正确的地址！");
			return "error/404";
		}
		KeUser user = userService.findUserByUsername(account);// 根据账户查询用户
		if (null == user) {
			LOGGER.error("Users do not exist, user_account: {}", account);
			request.setAttribute("errormsg", "用户不存在，请输入正确的地址！");
			return "error/404";
		}
		PageInfo<KeContent> contents = null;
		if(!StringUtils.isEmpty(btypeid)) {
			contents = contentService.getArticlesByUserIdAndPrpoId(page, limit, btypeid, user.getId());//按照博文分类获取
		}else if(!StringUtils.isEmpty(tagid)) {
			contents = contentService.getArticlesByUserIdAndPrpoId(page, limit, tagid, user.getId());//按照标签获取
		}else if(!StringUtils.isEmpty(timevalue)) {
			contents = contentService.getArticlesByUserIdAndTime(page, limit,timevalue, user.getId());//按照时间获取
		}
		else {
			contents = contentService.getArticles(page, limit, user.getId());// 文章列列表
		}
		List<KeProperties> properties = propertiesService.getTagAndTypeAndLink(WebConst.TypeProperties.BTYPE,
				WebConst.TypeProperties.TAG, WebConst.TypeProperties.LINK, user.getId());//获取到分类，标签，链接属性
		List<String> timebase = contentService.getTimeBase(user.getId());//获取文章的时间轴
		request.setAttribute("properties", properties);
		request.setAttribute("contents", contents);
		request.setAttribute("timebase", timebase);
		request.setAttribute("user", user);
		return "comm/index";
	}
}
