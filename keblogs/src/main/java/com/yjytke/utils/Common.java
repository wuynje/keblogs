package com.yjytke.utils;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

import com.vdurmont.emoji.EmojiParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuynje
 * @time 2018年8月20日 下午5:00:37
 * @version 1.0
 * @description:存放前台页面需要的方法，字段等
 */
@Api("公共类")
@Component
public class Common {
	
	private static Random random;
	
	@ApiOperation("获取0-max的随机数")
	public static String random(int max, String str) {
		random = new Random();
		return (random.nextInt(max-1)+1)+str;
	}
	
	   /**
     * 显示文章内容，转换markdown为html
     *
     * @param value
     * @return
     */
    public static String article(String value) {
        if (StringUtils.isNotBlank(value)) {
            value = value.replace("<!--more-->", "\r\n");
            value = value.replace("<!-- more -->", "\r\n");
            return mdToHtml(value);
        }
        return "";
    }
	
    /**
     * markdown转换为html
     *
     * @param markdown
     * @return
     */
    public static String mdToHtml(String markdown) {
        if (StringUtils.isBlank(markdown)) {
            return "";
        }
        java.util.List<Extension> extensions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        String content = renderer.render(document);
        content = emoji(content);
        return content;
    }
    
    /**
     * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
     * <p>
     * 这种格式的字符转换为emoji表情
     *
     * @param value
     * @return
     */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }
}
