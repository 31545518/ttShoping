package com.tt.content.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.content.feign.CommonContentFeignClient;
import com.tt.content.service.ContentService;
import com.tt.pojo.TbContent;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.service.impl
 * @version:
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private CommonContentFeignClient commonContentFeignClient;


    @Override
    public Result selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId) {

        PageResult pageResult = commonContentFeignClient.selectTbContentAllByCategoryId(page, rows, categoryId);
        if (pageResult != null && pageResult.getResult().size()>0){
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 分类内容添加
     * @param tbContent
     * @return
     */
    @Override
    @LcnTransaction
    public Result insertTbContent(TbContent tbContent) {
        Integer integer = this.commonContentFeignClient.insertTbContent(tbContent);
        if (integer != null){
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    /**
     * 删除分类信息
     * @param ids
     * @return
     */
    @Override
    @LcnTransaction
    public Result deleteContentByIds(Long ids) {
        Integer integer = this.commonContentFeignClient.deleteContentByIds(ids);
        if (integer != null){
            return Result.ok();
        }
        return Result.error("删除失败");
    }
}
