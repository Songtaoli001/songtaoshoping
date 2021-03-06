package com.songtao.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.common.utils.ExceptionUtil;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbContent;
import com.songtao.rest.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/list/{contentCatgoryId}")
	@ResponseBody
	public  TaotaoResult getContentList(@PathVariable Long contentCatgoryId) {
	try {
		List<TbContent> list = contentService.getContentList(contentCatgoryId);
		return TaotaoResult.ok(list);
	} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
