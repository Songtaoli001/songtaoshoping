package com.songtao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.songtao.common.utils.JsonUtils;
import com.songtao.service.PictureService;

/**
 * <p>Title: PictureController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>  
 * @author 李松涛
 * @date 2018年10月17日下午3:01:53
 * @version 1.0
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) throws Exception {
		
		Map result = pictureService.uploadPicture(uploadFile);
		String json = JsonUtils.objectToJson(result);
		System.out.println(json);
		return json;
	}
}
