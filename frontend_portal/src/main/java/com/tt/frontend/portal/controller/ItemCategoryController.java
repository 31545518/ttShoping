package com.tt.frontend.portal.controller;

import com.tt.frontend.portal.service.ItemCategoryService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页分类
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.frontend.portal.controller
 * @version:
 */
@RestController
@RequestMapping("/frontend/itemCategory")
@RefreshScope
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * 查询首页商品分类
     * @return
     */
    @RequestMapping("/selectItemCategoryAll")
    public Result selectItemCategoryAll(){
        try {
            return itemCategoryService.selectItemCategoryAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }
}
