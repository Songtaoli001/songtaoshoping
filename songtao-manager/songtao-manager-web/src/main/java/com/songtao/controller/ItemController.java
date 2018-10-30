package com.songtao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songtao.common.pojo.EUDataGridResult;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbItem;
import com.songtao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.geTbItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	private  TaotaoResult createItem(TbItem item) {
		TaotaoResult result = itemService.createItem(item);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
		public TaotaoResult saveItem(TbItem item, String desc) throws Exception {
			//添加商品信息
			itemService.saveItem(item, desc, null);
			return TaotaoResult.ok();
		}
	
	@RequestMapping(value="/item/update",method=RequestMethod.POST)
	@ResponseBody
	private  TaotaoResult editItem(TbItem item) {
		
		TaotaoResult result = itemService.editItem(item);
		return result;
	}
	
	

}
