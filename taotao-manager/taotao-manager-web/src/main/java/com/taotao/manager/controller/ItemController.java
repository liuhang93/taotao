package com.taotao.manager.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuhang on 2017/2/22.
 * 商品控制器
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @RequestMapping("/list")
    @ResponseBody
    private EasyUIDataGridResult getItemList(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "30") int rows) {
        return itemService.getItemList(page, rows);
    }


}
