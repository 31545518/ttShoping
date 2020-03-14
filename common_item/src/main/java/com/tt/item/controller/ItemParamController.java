package com.tt.item.controller;

import com.tt.item.service.ItemParamService;
import com.tt.pojo.TbItemParam;
import com.tt.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.controller
 * @version:
 */
@RestController
@RequestMapping("/service/itemParam")
@RefreshScope
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;


    /**
     * 根据商品分类id查询规格参数模板
     * @param itemCatId
     * @return
     */
    @RequestMapping("/selectItemParamByItemCatId")
    public TbItemParam selectItemParamByItemCatId(@RequestParam Long itemCatId){
        return itemParamService.selectItemParamByItemCatId(itemCatId);
    }

    @RequestMapping("/selectItemParamAll")
    public PageResult selectItemParamAll(Integer page,Integer rows){
        return this.itemParamService.selectItemParamAll(page,rows);
    }

    /**
     * 添加商品规格
     * @param tbItemParam
     * @return
     */
    @RequestMapping("/insertItemParam")
    public Integer insertItemParam(@RequestBody TbItemParam tbItemParam){
        return this.itemParamService.insertItemParam(tbItemParam);
    }

    @RequestMapping("/deleteItemParamById")
    public Integer deleteItemParamById(@RequestParam Long id){
        return this.itemParamService.deleteItemParamById(id);
    }

}
