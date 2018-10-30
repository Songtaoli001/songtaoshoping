package com.songtao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songtao.common.pojo.TreeNode;
import com.songtao.mapper.TbItemCatMapper;
import com.songtao.mapper.TbItemMapper;
import com.songtao.pojo.TbItem;
import com.songtao.pojo.TbItemCat;
import com.songtao.pojo.TbItemCatExample;
import com.songtao.pojo.TbItemCatExample.Criteria;
import com.songtao.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemcatMapper;
	@Override
	public List<TreeNode> getItemCatList(long parentId) {
		//根据paretid查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询 List<TbItemCat> selectByExample(TbItemCatExample example);
	List <TbItemCat> list=	itemcatMapper.selectByExample(example);
	
	//分类列表转换成treenode 的列表
	List<TreeNode> resultList = new ArrayList<>();
	for(TbItemCat tbItemCat:list) {
		//创建一个node对象
		TreeNode node=new TreeNode(tbItemCat.getId(), tbItemCat.getName(),
				tbItemCat.getIsParent()?"close":"open");
		resultList.add(node);
	}
		
		return resultList;
	}

}
