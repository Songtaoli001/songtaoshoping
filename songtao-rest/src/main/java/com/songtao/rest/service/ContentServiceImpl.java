package com.songtao.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songtao.mapper.TbContentMapper;
import com.songtao.pojo.TbContent;
import com.songtao.pojo.TbContentExample;
import com.songtao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

		@Autowired
		private TbContentMapper contentMapper;
		@Override
		public List<TbContent> getContentList(long contentCid){
			//创建查询条件
			TbContentExample example=new TbContentExample();
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(contentCid);
			List<TbContent> list = contentMapper.selectByExample(example);
			return list;
		}
}
