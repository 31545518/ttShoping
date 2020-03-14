package com.tt.item.controller;

import com.tt.item.service.ItemDescService;
import com.tt.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.item.controller
 * @version:
 */
@RestController
@RequestMapping("/service/itemDesc")
@RefreshScope
public class ItemDescController {
    @Autowired
    private ItemDescService itemDescService;

    /**
     * 添加商品描述
     * @param tbItemDesc
     * @return
     */
    @RequestMapping(value = "/insertItemDesc",method = RequestMethod.POST)
    public Integer insertItemDesc(@RequestBody TbItemDesc tbItemDesc){
        return itemDescService.insertItemDesc(tbItemDesc);
    }

    /**
     * 更新产品描述
     * @param tbItemDesc
     * @return
     */
    @RequestMapping("/updateItemDesc")
    public Integer updateItemDesc(@RequestBody TbItemDesc tbItemDesc){
        return  this.itemDescService.updateItemDesc(tbItemDesc);
    }

    /**
     * 根据ID查询商品详情
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemDescByItemId")
    public TbItemDesc selectItemDescByItemId(@RequestParam Long itemId){
        return this.itemDescService.selectItemDescByItemId(itemId);
    }

}
