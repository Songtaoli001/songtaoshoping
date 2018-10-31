package com.songtao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songtao.common.pojo.TreeNode;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.mapper.TbContentMapper;
import com.songtao.pojo.TbContent;
import com.songtao.pojo.TbContentExample;
import com.songtao.pojo.TbContentExample.Criteria;
import com.songtao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public TaotaoResult insertContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> selectaByID(long categoryId) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(categoryId);
		List<TbContent> selectByExample = contentMapper.selectByExampleWithBLOBs(example);

		return selectByExample;
	}


}
