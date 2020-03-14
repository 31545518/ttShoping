package com.tt.content.controller;

import com.tt.content.service.ContentService;
import com.tt.pojo.TbContent;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.controller
 * @version:
 */
@RestController
@RequestMapping("/content")
@RefreshScope
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/selectTbContentAllByCategoryId")
    public Result selectTbContentAllByCategoryId(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows , @RequestParam("categoryId") Long categoryId){
        try {
            return this.contentService.selectTbContentAllByCategoryId(page,rows,categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 分类内容添加
     * @param tbContent
     * @return
     */
    @RequestMapping("/insertTbContent")
    public Result insertTbContent(TbContent tbContent){
        try {
            return this.contentService.insertTbContent(tbContent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 删除分类信息
     * @param ids
     * @return
     */
    @RequestMapping("/deleteContentByIds")
    public Result deleteContentByIds(Long ids){
        try {
            return this.contentService.deleteContentByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }


}
