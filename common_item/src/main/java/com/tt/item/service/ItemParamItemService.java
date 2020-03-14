package com.tt.item.service;

import com.tt.pojo.TbItemParamItem;

/**
 * @Auther: blackcat
 * @Date: 2020-02-01
 * @Description: com.tt.item.service
 * @version:
 */
public interface ItemParamItemService {

    Integer insertTbItemParamItem(TbItemParamItem tbItemParamItem);

    Integer upateItemParamItem(TbItemParamItem tbItemParamItem);

    TbItemParamItem selectTbItemParamItemByItemId(Long itemId);
}
