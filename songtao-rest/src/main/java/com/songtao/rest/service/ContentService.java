package com.songtao.rest.service;

import java.util.List;

import com.songtao.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);

}
