package com.taotao.manager.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.pojo.TbItem;

/**
 * Created by liuhang on 2017/2/22.
 */
public interface ItemService {
    TbItem getItemById(long itemId);

    EasyUIDataGridResult getItemList(int page, int rows);
}
