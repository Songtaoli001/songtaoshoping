package com.songtao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songtao.common.pojo.EUDataGridResult;
import com.songtao.common.utils.IDUtils;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.mapper.TbItemDescMapper;
import com.songtao.mapper.TbItemMapper;
import com.songtao.pojo.TbItem;
import com.songtao.pojo.TbItemDesc;
import com.songtao.pojo.TbItemExample;
import com.songtao.pojo.TbItemExample.Criteria;
import com.songtao.service.ItemService;


/**
 * 
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	lisongtao
 * @date	2018年8月18日下午12:34:38
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	private TbItemDescMapper itemDescMapper;
	@Override
	public TbItem geTbItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
				//查询商品列表
				TbItemExample example = new TbItemExample();
				//分页处理
				PageHelper.startPage(page, rows);
				List<TbItem> list = itemMapper.selectByExample(example);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<TbItem> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
 
	}

	@Override
	public TaotaoResult createItem(TbItem item) {
		//	item补全
		long itemid = IDUtils.genItemId();
		item.setId(itemid);
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		return TaotaoResult.ok();
	}

	@Override
	public void saveItem(TbItem item, String desc, String itemParams) throws Exception {
		Date date = new Date();
		//获得商品id
		long id = IDUtils.genItemId();
		//添加商品信息
		item.setId(id);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		//添加商品描述
		//创建TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		//获得一个商品id
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//插入数据
		itemDescMapper.insert(itemDesc);
		
	}
	@Override
	public TaotaoResult editItem(TbItem item) {
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKey(item);
		return TaotaoResult.ok();
	}


}
