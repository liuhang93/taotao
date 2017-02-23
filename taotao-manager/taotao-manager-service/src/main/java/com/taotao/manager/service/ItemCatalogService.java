package com.taotao.manager.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by liuhang on 2017/2/23.
 */
public interface ItemCatalogService {
    List<EasyUITreeNode> getItemCatalogList(long parentId);
}
