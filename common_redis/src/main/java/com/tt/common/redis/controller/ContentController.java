package com.tt.common.redis.controller;

import com.tt.common.redis.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 缓存首页打广告位
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/redis/content")
@RefreshScope
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 将大广告添加到缓存中
     * @param list
     */
    @RequestMapping("/insertContentAD")
    public void insertContentAD(@RequestBody List<Map> list){
        this.contentService.insertContentAD(list);
    }

    /**
     * 查询缓存中的首页大广告位
     * @return
     */
    @RequestMapping("/selectContentAD")
    public List<Map>selectContentAD(){
        return this.contentService.selectContentAD();
    }

}
