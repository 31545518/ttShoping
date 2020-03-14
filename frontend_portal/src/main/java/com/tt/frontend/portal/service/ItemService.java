package com.tt.frontend.portal.service;

import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-02-28
 * @Description: com.tt.frontend.portal.service
 * @version:
 */
public interface ItemService {
    Result selectItemInfo(Long itemId);

    Result selectItemDescByItemId(Long itemId);

    Result selectTbItemParamItemByItemId(Long itemId);
}
