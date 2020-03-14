package com.tt.backend.item.controller;

import com.tt.backend.item.feign.CommonItemFeignClient;
import com.tt.backend.item.service.ItemCategoryService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.controller
 * @version:
 * 查询商品类目
 */
@RestController
@RequestMapping("/backend/itemCategory")
@RefreshScope
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * 根据类目Id查询子节点
     * @param id
     * @return
     */
    @RequestMapping("/selectItemCategoryByParentId")
    public Result selectItemCategoryByParentId(@RequestParam(value = "id",defaultValue = "0") Long id){
        try {
            return this.itemCategoryService.selectItemCategoryByParentId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }


}
