package com.tt.backend.item.service;

import com.tt.pojo.TbItem;
import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.backend.item.service
 * @version:
 */
public interface ItemService {
    // 查询商品
    Result selectTbItemAllByPage(Integer page,Integer rows);
    // 插入商品
    public Result insertTbItem(TbItem tbItem, String desc, String ItemParams);
    // 删除商品
    Result deleteItemById(Long itemId);
    // 商品预更新
    Result preUpdateItem(Long itemId);

    Result updateTbItem(TbItem tbItem, String desc, String itemParam);
}
