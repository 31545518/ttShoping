package com.tt.backend.item.feign;

import com.tt.backend.item.fallback.CommonItemFeignClientFallbackFactory;
import com.tt.pojo.*;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.backend.item.feign
 * @version:
 */
@FeignClient(value = "common-item", fallbackFactory = CommonItemFeignClientFallbackFactory.class)
public interface CommonItemFeignClient {
    //-------------------------------------
    @PostMapping("/service/item/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
    @PostMapping("/service/item/insertTbItem")
    Integer insertTbItem(@RequestBody TbItem tbItem);
    @PostMapping("/service/item/deleteItemById")
    Integer deleteItemById(@RequestBody TbItem tbItem);
    @PostMapping("/service/item/preUpdateItem")
    Map<String,Object> preUpdateItem(@RequestParam("itemId") Long itemId);
    @PostMapping("/service/item/updateTbitem")
    Integer updateTbitem(@RequestBody TbItem tbItem);

    //----------------------------------------
    @PostMapping("/service/itemDesc/insertItemDesc")
    Integer insertItemDesc(@RequestBody TbItemDesc tbItemDesc);
    @PostMapping("/service/itemDesc/updateItemDesc")
    Integer updateItemDesc(@RequestBody TbItemDesc tbItemDesc);
    //-----------------------------------------
    @PostMapping("/service/itemParamItem/insertTbItemParamItem")
    Integer insertTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem);
    @PostMapping("/service/itemParamItem/upateItemParamItem")
    Integer upateItemParamItem(@RequestBody TbItemParamItem tbItemParamItem);

    //-------------------------------------
    @GetMapping("/service/itemCategory/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id") Long id);

    //-------------------------------------
    @PostMapping("/service/itemParam/selectItemParamByItemCatId")
    TbItemParam selectItemParamByItemCatId(@RequestParam("itemCatId") Long itemCatId);

    @PostMapping("/service/itemParam/selectItemParamAll")
    PageResult selectItemParamAll(@RequestParam Integer page,@RequestParam Integer rows);

    @PostMapping("/service/itemParam/insertItemParam")
    Integer insertItemParam(@RequestBody TbItemParam tbItemParam);


    @PostMapping("/service/itemParam/deleteItemParamById")
    Integer deleteItemParamById(@RequestParam Long id);


}
