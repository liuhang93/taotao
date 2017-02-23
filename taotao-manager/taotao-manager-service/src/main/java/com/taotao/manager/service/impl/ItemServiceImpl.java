package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.mapper.TbItemMapper;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemExample;
import com.taotao.manager.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuhang on 2017/2/22.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> itemList = itemMapper.selectByExample(example);
        PageInfo<TbItem> itemPageInfo = new PageInfo<>(itemList);
        long total = itemPageInfo.getTotal();
        return new EasyUIDataGridResult(total, itemList);
    }

    @Override
    public TbItem getItemById(long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }
}
