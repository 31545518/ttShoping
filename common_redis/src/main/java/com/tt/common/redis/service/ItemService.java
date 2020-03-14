package com.tt.common.redis.service;

import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;

/**
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.common.redis.service
 * @version:
 */
public interface ItemService {
    void insertItemBasicInfo(TbItem tbItem);

    TbItem selectItemBasicInfo(Long tbItemId);

    void insertItemDesc(TbItemDesc tbItemDesc);

    TbItemDesc selectItemDesc(Long tbItemId);

    void insertItemParamItem(TbItemParamItem tbItemParamItem);

    TbItemParamItem selectItemParamItem(Long tbItemId);
}
