package com.tt.item.service;

import com.tt.pojo.TbItemDesc;

/**
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.item.service
 * @version:
 */
public interface ItemDescService {

    Integer insertItemDesc(TbItemDesc tbItemDesc);

    Integer updateItemDesc(TbItemDesc tbItemDesc);

    // 商品详情
    TbItemDesc selectItemDescByItemId(Long itemId);
}
