package com.songtao.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.songtao.common.utils.HttpClientUtil;
import com.songtao.common.utils.JsonUtils;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbContent;

@Service
public class ContentServiceImpl implements ContentService {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	 

	@Override
	public String getContentList() {
		System.out.println(REST_BASE_URL+"\n"+REST_INDEX_AD_URL);
		//调用服务层的服务192.168.232.128 http://localhost:8080/rest/content/list/89
		String result = HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
		System.out.println(result);
	try {
		//把字符串转换为taotaoresult
		TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
		List<TbContent> list = (List<TbContent>) taotaoResult.getData();
		List<Map> resultList=new ArrayList<>();
		for (TbContent tbContent : list) {
			Map map =new HashMap<>();
			map.put("src", tbContent.getPic());
			map.put("height", 240);
			map.put("width", 670);
			map.put("srcB", tbContent.getPic2());
			map.put("widthB", 550);
			map.put("heightB", 240);
			map.put("href", tbContent.getUrl());
			map.put("alt", tbContent.getSubTitle());
			resultList.add(map);
		}

		return JsonUtils.objectToJson(resultList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
	}

}
