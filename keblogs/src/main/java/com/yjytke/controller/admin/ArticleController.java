package com.yjytke.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yjytke.constant.AjaxReturnCode;
import com.yjytke.constant.WebConst;
import com.yjytke.entity.KeContent;
import com.yjytke.entity.KeProperties;
import com.yjytke.entity.KeUser;
import com.yjytke.service.content.ContentService;
import com.yjytke.service.properties.PropertiesService;
import com.yjytke.utils.ApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wuynje
 * @time 2018年8月29日 上午11:04:49
 * @version 1.0
 * @description:博客相关
 */
@Api("博客相关")
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

	@Autowired
	private PropertiesService proService;

	@Autowired
	private ContentService contentService;

	@ApiOperation("博客列表")
	@GetMapping("")
	public String getArticle(HttpServletRequest request,
			@ApiParam(name = "page", value = "页数", required = false) @RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@ApiParam(name = "limit", value = "每页数量", required = false) @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		PageInfo<KeContent> articles = contentService.getArticles(page, limit, userid);
		request.setAttribute("articles", articles);
		return "admin/article_list";
	}

	@ApiOperation("编辑博客页")
	@GetMapping("/publish")
	public String publish(HttpServletRequest request) {
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		List<KeProperties> properties = proService.getTagAndType(null, WebConst.TypeProperties.BTYPE, userid);
		request.setAttribute("btype", properties);
		return "admin/article_edit";
	}

	@ApiOperation("发布博客")
	@PostMapping("/publish")
	@ResponseBody
	public ApiResponse publishArticle(HttpServletRequest request,
			@ApiParam(name = "title", value = "标题", required = true) @RequestParam(name = "title", required = true) String title,
			@ApiParam(name = "titlePic", value = "标题图片", required = false) @RequestParam(name = "titlePic", required = false) String titlePic,
			@ApiParam(name = "content", value = "内容", required = true) @RequestParam(name = "content", required = true) String content,
			@ApiParam(name = "style", value = "文章类型", required = true) @RequestParam(name = "style", required = true) String style,
			@ApiParam(name = "status", value = "文章状态", required = true) @RequestParam(name = "status", required = true) String status,
			@ApiParam(name = "tags", value = "标签", required = false) @RequestParam(name = "tags", required = false) String tags,
			@ApiParam(name = "btype", value = "分类", required = false) @RequestParam(name = "btype", required = false, defaultValue = "默认分类") String btype,
			@ApiParam(name = "allowComment", value = "是否允许评论", required = true) @RequestParam(name = "allowComment", required = true) Boolean allowComment) {
		KeContent keContent = new KeContent();
		int userid = ((KeUser) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY)).getId();
		keContent.setTitle(title);
		keContent.setUserid(userid);
		keContent.setTitlePic(titlePic);
		keContent.setContent(content);
		keContent.setStyle(style);
		keContent.setBtype(style.equals(WebConst.Articletype.BLOG) ? btype : null);
		keContent.setStatus(status);
		keContent.setTags(style.equals(WebConst.Articletype.BLOG) ? tags : null);
		keContent.setAllowComment(allowComment ? 1 : 0);
		contentService.addContent(keContent);
		return new ApiResponse(AjaxReturnCode.ContentCode.SUCCESS);
	}

	/**
	 * 根据id回显文本内容
	 * @param request
	 * @param cid
	 * @return
	 */
	@GetMapping("/{id}")
	public String postArticleEdit(HttpServletRequest request,
			@ApiParam(name = "id", value = "博文id", required = true) @PathVariable(name = "id", required = true) int cid) {
		KeContent content = contentService.getArticleById(cid);
		List<KeProperties> properties = proService.getPropByContent(content);
//		if(properties !) {
//			
//		}
//        request.setAttribute("categories", categories);
        request.setAttribute("active", "article");
		request.setAttribute("contents", content);
		return "admin/article_edit";
	}

}
