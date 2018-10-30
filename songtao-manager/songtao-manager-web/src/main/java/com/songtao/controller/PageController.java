package com.songtao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.pojo.TbItem;
import com.songtao.service.ItemService;

@Controller
public class PageController {

	@Autowired
	private ItemService itemService;
	 
	@RequestMapping("/")
	public String showIndex() {
		
		return"index";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

	
}
