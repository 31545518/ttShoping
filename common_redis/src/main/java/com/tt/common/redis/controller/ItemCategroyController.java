package com.tt.common.redis.controller;

import com.netflix.discovery.converters.Auto;
import com.tt.common.redis.service.ItemCategroyService;
import com.tt.utils.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存首页商品分类
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/redis/itemCategory")
@RefreshScope
public class ItemCategroyController {

    @Autowired
    private ItemCategroyService itemCategroyService;

    /**
     * 向rendis中添加缓存数据
     * @param catResult
     */
    @RequestMapping("/insertItemCategory")
    public void insertItemCategory(@RequestBody CatResult catResult){
        itemCategroyService.insertItemCategory(catResult);
    }

    /**
     * 查询Redis中缓存的首页商品分类
     * @return
     */
    @RequestMapping("/selectItemCategory")
    public CatResult selectItemCategory(){
        return  this.itemCategroyService.selectItemCategory();
    }
}
