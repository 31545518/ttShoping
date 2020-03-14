package com.tt.content.service;

import com.tt.pojo.TbContentCategory;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.service
 * @version:
 */
public interface ContentCategoryService {
    // 根据父节点查询子节点
    List<TbContentCategory> selectContentCategoryByParentId(Long parentId);
    // 添加内容分类
    Integer insertContentCategory(TbContentCategory tbContentCategory);

    Integer deleteContentCategoryById(Long categoryId);

    Integer updateContentCategory(TbContentCategory tbContentCategory);
}
