package com.taotao.manager.service.impl;

import com.taotao.manager.mapper.TbItemMapper;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuhang on 2017/2/22.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
