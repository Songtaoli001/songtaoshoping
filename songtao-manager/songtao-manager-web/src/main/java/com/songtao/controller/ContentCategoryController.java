package com.songtao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.common.pojo.TreeNode;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.service.ContentCategoryService;
@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
    @ResponseBody
	public List<TreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<TreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}
	@RequestMapping("/content/category/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}

	
}

