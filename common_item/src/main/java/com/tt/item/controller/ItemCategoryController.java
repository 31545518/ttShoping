package com.tt.item.controller;

import com.tt.item.service.ItemCategoryService;
import com.tt.pojo.TbContentCategory;
import com.tt.pojo.TbItemCat;
import com.tt.utils.CatResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.controller
 * @version:
 */
@RestController
@RequestMapping("/service/itemCategory")
@RefreshScope
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * 根据父节点查询字节的
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectItemCategoryByParentId", method = RequestMethod.GET)
    public List<TbItemCat> selectItemCategoryByParentId(@RequestParam Long id){
        return itemCategoryService.selectItemCategoryByParentId(id);
    }

    /**
     * 查询商品分类 -左侧菜单
     * @return
     */
    @RequestMapping("/selectItemCategoryAll")
    public CatResult selectItemCategoryAll(){
        return this.itemCategoryService.selectItemCategoryAll();
    }

}
