package com.tt.backend.item.controller;

import com.netflix.discovery.converters.Auto;
import com.tt.backend.item.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.backend.item.controller
 * @version:
 */
@RestController
@RequestMapping("backend/item")
@RefreshScope
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 查询商品并分页处理
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "2") Integer rows){
        try{
            return this.itemService.selectTbItemAllByPage(page,rows);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItem tbItem,String desc, String itemParams){
        try{
            return this.itemService.insertTbItem(tbItem,desc,itemParams);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }

    @RequestMapping("/deleteItemById")
    public Result deleteItemById(Long itemId){
        try {
            return this.itemService.deleteItemById(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(Long itemId){
        try {
            return itemService.preUpdateItem(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 更新商品
     * @param tbItem
     * @param desc
     * @param itemParam
     * @return
     */
    @RequestMapping("/updateTbItem")
    public Result updateTbItem(TbItem tbItem,String desc,String itemParam){
        try{
            return this.itemService.updateTbItem(tbItem,desc,itemParam);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }












}
