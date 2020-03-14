package com.tt.content.controller;

import com.tt.content.service.ContentCategoryService;
import com.tt.pojo.TbContentCategory;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.controller
 * @version:
 */
@RestController
@RequestMapping("/content")
@RefreshScope
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/selectContentCategoryByParentId")
    public Result selectContentCategoryByParentId(@RequestParam(defaultValue = "0") Long id){
        try {
             return this.contentCategoryService.selectContentCategoryByParentId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 添加分类管理
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(TbContentCategory tbContentCategory){
        try {
            return this.contentCategoryService.insertContentCategory(tbContentCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 删除分类
     * @param categoryId
     * @return
     */
    @RequestMapping("/deleteContentCategoryById")
    public Result deleteContentCategoryById(Long categoryId){
        try {
            return this.contentCategoryService.deleteContentCategoryById(categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 修改分类
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/updateContentCategory")
    public Result updateContentCategory(TbContentCategory tbContentCategory){
        try {
            return this.contentCategoryService.updateContentCategory(tbContentCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

}
