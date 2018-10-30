package com.songtao.service;

import com.songtao.common.pojo.EUDataGridResult;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbItem;

public interface ItemService {
	TbItem geTbItemById(long itemId);
	public EUDataGridResult getItemList(int page, int rows);
	TaotaoResult  createItem(TbItem item);

	public void saveItem(TbItem item, String desc, String itemParams) throws Exception ;
	TaotaoResult editItem(TbItem item);
}
