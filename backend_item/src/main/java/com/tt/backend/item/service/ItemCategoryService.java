package com.tt.backend.item.service;

import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.service
 * @version:
 */
public interface ItemCategoryService {
    public Result selectItemCategoryByParentId(Long id);
}
