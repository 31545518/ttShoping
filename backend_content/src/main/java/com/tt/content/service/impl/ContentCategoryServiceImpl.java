package com.tt.content.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.content.feign.CommonContentFeignClient;
import com.tt.content.service.ContentCategoryService;
import com.tt.pojo.TbContentCategory;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.service.impl
 * @version:
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private CommonContentFeignClient commonContentFeignClient;

    @Override
    public Result selectContentCategoryByParentId(Long parentId) {
        List<TbContentCategory> tbContentCategories = this.commonContentFeignClient.selectContentCategoryByParentId(parentId);
        if (tbContentCategories != null && tbContentCategories.size() > 0) {
            return Result.ok(tbContentCategories);
        }
        return Result.error("查无结果");

    }

    @Override
    @LcnTransaction
    public Result insertContentCategory(TbContentCategory tbContentCategory) {
        Integer category = this.commonContentFeignClient.insertContentCategory(tbContentCategory);
        if (category != null)
            return Result.ok();
        if (category == null){
            throw new RuntimeException();
        }
        return Result.error("添加失败");
    }

    @Override
    @LcnTransaction
    public Result deleteContentCategoryById(Long categoryId) {
        Integer integer = this.commonContentFeignClient.deleteContentCategoryById(categoryId);
        if (integer == 200) {
            Result.ok();
        }
        if (integer == null){
            throw new RuntimeException();
        }
        return Result.error("删除失败");
    }

    @Override
    @LcnTransaction
    public Result updateContentCategory(TbContentCategory tbContentCategory) {
        Integer integer = this.commonContentFeignClient.updateContentCategory(tbContentCategory);
        if (integer != null) {
            return Result.ok();
        }
        if (integer == null){
            throw new RuntimeException();
        }
        return Result.error("更新失败");
    }
}
