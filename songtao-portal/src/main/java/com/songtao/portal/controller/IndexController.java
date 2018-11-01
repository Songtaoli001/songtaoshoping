package com.songtao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.common.utils.TaotaoResult;
import com.songtao.portal.service.ContentService;

@Controller
public class IndexController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String  showInedx(Model model){
		String adJson = contentService.getContentList();
		model.addAttribute("ad1",adJson);
		return "index";
	}


	@RequestMapping(value="/httpclient/post",method=RequestMethod.POST)
	@ResponseBody
	//responsebody会把请求的数据转换为jeson数据，
	//然后做一个post请求。给一个响应返回一个TaotaoResult
	public String testPost() {
		return "ok";
	}


}
