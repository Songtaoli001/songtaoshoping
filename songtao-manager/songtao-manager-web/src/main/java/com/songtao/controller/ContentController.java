package com.songtao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.common.pojo.EUDataGridResult;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbContent;
import com.songtao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
@Autowired
private ContentService contentService;

@RequestMapping("/save")
@ResponseBody
public TaotaoResult insertcontent(TbContent content) {
	TaotaoResult result = contentService.insertContent(content);
	return  result;
}

@RequestMapping("/query/list")
@ResponseBody
public List<TbContent> getEUDataGridResult(long categoryId) {
	System.out.println("categoryId: "+categoryId);
	List<TbContent> list=contentService.selectaByID(categoryId);
	return list;
}
}
