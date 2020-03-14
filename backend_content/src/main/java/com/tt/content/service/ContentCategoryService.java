package com.tt.content.service;

import com.tt.pojo.TbContentCategory;
import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.service
 * @version:
 */
public interface ContentCategoryService {

    // 查询分类
    Result selectContentCategoryByParentId(Long parentId);
    // 添加内容分类
    Result insertContentCategory(TbContentCategory tbContentCategory);

    Result deleteContentCategoryById(Long categoryId);

    Result updateContentCategory(TbContentCategory tbContentCategory);
}
