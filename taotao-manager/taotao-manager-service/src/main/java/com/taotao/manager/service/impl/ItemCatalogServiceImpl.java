package com.taotao.manager.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.manager.mapper.TbItemCatMapper;
import com.taotao.manager.pojo.TbItemCat;
import com.taotao.manager.pojo.TbItemCatExample;
import com.taotao.manager.service.ItemCatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhang on 2017/2/23.
 */
@Service
public class ItemCatalogServiceImpl implements ItemCatalogService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatalogList(long parentId) {
        TbItemCatExample itemCatExample = new TbItemCatExample();
        itemCatExample.createCriteria().andParentIdEqualTo(parentId);
        List<TbItemCat> itemCats = itemCatMapper.selectByExample(itemCatExample);
        List<EasyUITreeNode> easyUITreeNodes = new ArrayList<>();
        for (TbItemCat itemCat : itemCats) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode(itemCat.getId(), itemCat.getName()
                    , itemCat.getIsParent() ? "closed" : "open");
            easyUITreeNodes.add(easyUITreeNode);
        }
        return easyUITreeNodes;
    }

}
