package com.songtao.service;

import java.util.List;

import com.songtao.common.pojo.EUDataGridResult;
import com.songtao.common.utils.TaotaoResult;
import com.songtao.pojo.TbContent;

public interface ContentService {
	public TaotaoResult insertContent(TbContent content);

	public List<TbContent> selectaByID(long categoryId);

}
