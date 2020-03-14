package com.tt.common.redis.controller;

import com.tt.common.redis.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存商品信息
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/redis/item")
@RefreshScope
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 缓存商品基本信息
     * @param tbItem
     */
    @RequestMapping("/insertItemBasicInfo")
    public void insertItemBasicInfo(@RequestBody TbItem tbItem){
        this.itemService.insertItemBasicInfo(tbItem);
    }

    /**
     * 商品查询信息
     * @param tbItemId
     * @return
     */
    @RequestMapping("/selectItemBasicInfo")
    public TbItem selectItemBasicInfo(@RequestParam Long tbItemId){
        return this.itemService.selectItemBasicInfo(tbItemId);
    }

    /**
     * 缓存商品简绍信息
     * @param tbItemDesc
     */
    @RequestMapping("/insertItemDesc")
    public void insertItemDesc(@RequestBody TbItemDesc tbItemDesc){
        this.itemService.insertItemDesc(tbItemDesc);
    }

    /**
     * 查询缓存中的商品简绍
     * @param tbItemId
     * @return
     */
    @RequestMapping("/selectItemDesc")
    public TbItemDesc selectItemDesc(@RequestParam Long tbItemId){
        return this.itemService.selectItemDesc(tbItemId);
    }

    /**
     * 缓存商品规格参数
     * @param tbItemParamItem
     */
    @RequestMapping("/insertItemParamItem")
    public void insertItemParamItem(@RequestBody TbItemParamItem tbItemParamItem){
        this.itemService.insertItemParamItem(tbItemParamItem);
    }

    /**
     * 查询缓存中的商品规格参数
     * @param tbItemId
     * @return
     */
    @RequestMapping("/selectItemParamItem")
    public TbItemParamItem selectItemParamItem(@RequestParam Long tbItemId){
        return this.itemService.selectItemParamItem(tbItemId);
    }

}
