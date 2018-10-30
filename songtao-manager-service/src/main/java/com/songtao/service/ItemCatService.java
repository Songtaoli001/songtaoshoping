package com.songtao.service;

import java.util.List;

import com.songtao.common.pojo.TreeNode;
public interface ItemCatService {
	public List<TreeNode> getItemCatList(long parentId);
}
