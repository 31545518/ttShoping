package com.tt.backend.item.service;

import com.tt.pojo.TbItemParam;
import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.service
 * @version:
 */
public interface ItemParamService {
    public Result selectItemParamByItemCatId(Long itemCatId);

    Result selectItemParamAll(Integer page,Integer rows);

    // 根据商品分类添加规格参数模板
    Result insertItemParam(Long itemCatId ,String paramData);
    // 删除商品规格信息
    Result deleteItemParamById(Long id);
}
