package com.tt.content.controller;

import com.tt.content.service.ContentService;
import com.tt.pojo.TbContent;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.controller
 * @version:
 */
@RestController
@RequestMapping("/service/content")
@RefreshScope
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 查询分类
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    @RequestMapping("/selectTbContentAllByCategoryId")
    public PageResult selectTbContentAllByCategoryId(@RequestParam Integer page,@RequestParam Integer rows ,@RequestParam Long categoryId){
        return this.contentService.selectTbContentAllByCategoryId(page,rows,categoryId);
    }

    /**
     * 添加分类
     * @param tbContent
     * @return
     */
    @RequestMapping("/insertTbContent")
    public Integer insertTbContent(@RequestBody TbContent tbContent){
        return this.contentService.insertTbContent(tbContent);
    }

    /**
     * 删除分类下内容
     * @param id
     * @return
     */
    @RequestMapping("/deleteContentByIds")
    public Integer deleteContentByIds(@RequestParam Long id){
        return this.contentService.deleteContentByIds(id);
    }

    /**
     * 查询首页大广告位
     * @return
     */
    @RequestMapping("/selectFrontendContentByAD")
    public List<Map> selectFrontendContentByAD(){
        return this.contentService.selectFrontendContentByAD();
    }


}
