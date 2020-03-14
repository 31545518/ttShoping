package com.tt.search.controller;

import com.tt.search.service.SolrService;
import com.tt.utils.Result;
import com.tt.utils.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 搜索服务
 * @Auther: blackcat
 * @Date: 2020-02-28
 * @Description: com.tt.search.controller
 * @version:
 */
@RestController
@RequestMapping("/search")
@RefreshScope
public class SolrController {
    @Autowired
    private SolrService solrService;

    /**
     * 向solr索引库导入数据
     * @return
     */
    @RequestMapping("/importAll")
    public Result importAll(){
        return solrService.importAll();
    }

    /**
     * 搜索数据
     * @param q
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public List<SolrDocument> selectByQ(String q, @RequestParam(defaultValue = "1") Long page,@RequestParam(defaultValue = "10") Integer pageSize){
        try {
            return solrService.selectByQ(q,page,pageSize);
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

}

















