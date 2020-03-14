package com.tt.content.controller;

import com.tt.content.service.ContentCategoryService;
import com.tt.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.controller
 * @version:
 */
@RestController
@RequestMapping("/service/contentCategory")
@RefreshScope
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 查询内容分类
     * @param parentId
     * @return
     */
    @RequestMapping("/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long parentId){
        return this.contentCategoryService.selectContentCategoryByParentId(parentId);
    }

    /**
     * 添加内容分类
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/insertContentCategory")
    public Integer insertContentCategory(@RequestBody TbContentCategory tbContentCategory){
        return this.contentCategoryService.insertContentCategory(tbContentCategory);
    }

    /**
     * 删除节点内容
     * @param categoryId
     * @return
     */
    @RequestMapping("/deleteContentCategoryById")
    public Integer deleteContentCategoryById(@RequestParam Long categoryId){
        return this.contentCategoryService.deleteContentCategoryById(categoryId);
    }

    /**
     * 修改节点内容
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/updateContentCategory")
    public Integer updateContentCategory(@RequestBody TbContentCategory tbContentCategory){
        return this.contentCategoryService.updateContentCategory(tbContentCategory);
    }

}
