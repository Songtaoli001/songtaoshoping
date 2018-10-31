package com.songtao.service;

import java.util.List;

import com.songtao.common.pojo.TreeNode;
import com.songtao.common.utils.TaotaoResult;

public interface ContentCategoryService {
	public List<TreeNode> getCategoryList(long parentId);

	TaotaoResult insertContentCategory(long parentId, String name);
}
