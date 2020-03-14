package com.tt.frontend.portal.controller;

import com.tt.frontend.portal.service.ItemService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品查询
 * @Auther: blackcat
 * @Date: 2020-02-28
 * @Description: com.tt.frontend.portal.controller
 * @version:
 */
@RestController
@RequestMapping("/frontend/item")
@RefreshScope
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * 根据商品ID查询商品
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemInfo")
    public Result selectItemInfo(Long itemId){
        try {
            return this.itemService.selectItemInfo(itemId);
        }catch (Exception e){

        }
        return Result.build(500,"ERROR");
    }

    /**
     * 查询商品简介
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemDescByItemId")
    public Result selectItemDescByItemId(Long itemId){
        try {
            return this.itemService.selectItemDescByItemId(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/selectTbItemParamItemByItemId")
    public Result selectTbItemParamItemByItemId(Long itemId){
        try {
            return this.itemService.selectTbItemParamItemByItemId(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

}
