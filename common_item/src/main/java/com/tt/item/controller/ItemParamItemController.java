package com.tt.item.controller;

import com.tt.item.service.ItemParamItemService;
import com.tt.pojo.TbItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: blackcat
 * @Date: 2020-02-01
 * @Description: com.tt.item.controller
 * @version:
 */
@RestController
@RequestMapping("/service/itemParamItem")
@RefreshScope
public class ItemParamItemController {
    @Autowired
    private ItemParamItemService itemParamItemService;

    /**
     * 添加商品规格参数
     * @param tbItemParamItem
     * @return
     */
    @RequestMapping(value = "/insertTbItemParamItem", method = RequestMethod.POST)
    public Integer insertTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem){
        return itemParamItemService.insertTbItemParamItem(tbItemParamItem);
    }

    // 更新商品规格
    @RequestMapping("/upateItemParamItem")
    public Integer upateItemParamItem(@RequestBody TbItemParamItem tbItemParamItem){
        return this.itemParamItemService.upateItemParamItem(tbItemParamItem);
    }

    /**
     * 根据商品ID查询商品规格参数
     * @param itemId
     * @return
     */
    @RequestMapping("/selectTbItemParamItemByItemId")
    public TbItemParamItem selectTbItemParamItemByItemId(@RequestParam Long itemId){
        return this.itemParamItemService.selectTbItemParamItemByItemId(itemId);
    }

}
