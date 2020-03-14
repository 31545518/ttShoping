package com.tt.backend.item.controller;

import com.tt.backend.item.service.ItemParamService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.controller
 * @version:
 */
@RestController
@RequestMapping("/backend/itemParam")
@RefreshScope
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    /**
     * 根据商品分类ID查询规格参数模板
     * @param itemCatId
     * @return
     */
    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId){
        try {
            return itemParamService.selectItemParamByItemCatId(itemCatId);
        }catch (Exception e){

        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer rows){
        try {
            return this.itemParamService.selectItemParamAll( page, rows);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId , String paramData){
        try{
            return this.itemParamService.insertItemParam(itemCatId,paramData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 删除商品规格
     * @param id
     * @return
     */
    @RequestMapping("/deleteItemParamById")
    public Result deleteItemParamById(@RequestParam Long id){
        return this.itemParamService.deleteItemParamById(id);
    }
}
