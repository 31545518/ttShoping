package com.tt.item.controller;

import com.tt.item.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.item.controller
 * @version:
 */
@RestController
@RequestMapping("/service/item")
@RefreshScope
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 查询商品数据
     */
    @RequestMapping(value = "/selectTbItemAllByPage",method = RequestMethod.POST)
    public PageResult selectTbItemAllByPage(@RequestParam Integer page,@RequestParam Integer rows){
        return this.itemService.selectTbItemAllByPage(page,rows);
    }

    /**
     * 添加商品规格
     * @param tbItem
     * @return
     */
    @RequestMapping(value = "/insertTbItem",method = RequestMethod.POST)
    public Integer insertTbItem(@RequestBody TbItem tbItem){
        return itemService.insertTbItem(tbItem);
    }

    /**
     * 删除商品信息
     * @param tbItem
     * @return
     */
    @RequestMapping("/deleteItemById")
    public Integer deleteItemById(@RequestBody TbItem tbItem){
        return this.itemService.updateItemById(tbItem);
    }

    /**
     * 根据商品ID查询商品，商品分类，商品描述，商品规格参数
     * @param itemId
     * @return
     */
    @RequestMapping("/preUpdateItem")
    public Map<String,Object> preUpdateItem(Long itemId){
        return this.itemService.preUpdateItem(itemId);
    }


    @RequestMapping("/updateTbitem")
    public Integer updateTbitem(@RequestBody TbItem tbItem){
        return this.itemService.updateItemById(tbItem);
    }

    /**
     * 根据商品ID查询商品
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemInfo")
    public TbItem selectItemInfo(@RequestParam Long itemId){
        return this.itemService.selectItemInfo(itemId);
    }


















}
