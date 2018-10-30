package com.songtao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.songtao.common.utils.FtpUtil;
import com.songtao.common.utils.IDUtils;
import com.songtao.service.PictureService;
import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy.Result;

/**
 * 图片上传服务
 * @date	2018年10月17日上午11:12:59
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
	/*
	@Value("${FTP_ADDRESS}")
	private  String FTP_ADDRESS ;
	@Value("${FTP_PORT}")
	private  Integer FTP_PORT ;
	@Value("${FTP_USERNAME}")
	private  String FTP_USERNAME ;
	@Value("${FTP_PASSWORD}")
	private  String FTP_PASSWORD ;
	@Value("${FTP_BASEPATH}")
	private  String FTP_BASEPATH ;
	@Value("${IMAGE_BASE_URL}")
	private  String IMAGE_BASE_URL ;*/
	private String  	FTP_ADDRESS="192.168.232.128"                    ;
	private Integer  	FTP_PORT=21                                    ;
	private String  	FTP_USERNAME="ftpuser"                           ;
	private String  	FTP_PASSWORD="123456"                           ;
	private String  	FTP_BASEPATH="/home/ftpuser/www/images"          ;
	private String  	IMAGE_BASE_URL="http://192.168.232.128/images"   ;
	Map resultMap = new HashMap<>();
	@Override
	public Map uploadPicture(MultipartFile uploadFile)throws  Exception {
		//生成一个新的文件名
		//取原文件名
		String oldName = uploadFile.getOriginalFilename();
		
		//生成新的文件名，
		//UUID.randomUUID();
		String newName = IDUtils.genImageName();
		String imagePath=new DateTime().toString("/yyyy/MM/dd");
		newName = newName+oldName.substring(oldName.lastIndexOf("."));
		//图片上传
		
	
		Boolean result=FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME,FTP_PASSWORD, FTP_BASEPATH,
				imagePath, newName,uploadFile.getInputStream());  
        if(!result) {
        	resultMap.put("error", 1);
        	resultMap.put("message", "文件上传失败");
        	return resultMap;
        } 
        resultMap.put("error", 0);
        resultMap.put("url", IMAGE_BASE_URL+imagePath+"/"+newName);
		return resultMap;
	}

}
