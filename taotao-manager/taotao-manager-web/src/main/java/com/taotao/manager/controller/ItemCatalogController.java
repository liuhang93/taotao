package com.taotao.manager.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.manager.service.ItemCatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuhang on 2017/2/23.
 * 商品目录
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatalogController {
    @Autowired
    private ItemCatalogService itemCatalogService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatalogList(@RequestParam(value = "id", defaultValue =
            "0") long parentId) {
        return itemCatalogService.getItemCatalogList(parentId);
    }
}
