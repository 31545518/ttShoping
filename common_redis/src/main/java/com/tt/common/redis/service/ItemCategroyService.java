package com.tt.common.redis.service;

import com.tt.utils.CatResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.service
 * @version:
 */
public interface ItemCategroyService {

    void insertItemCategory( CatResult catResult);
    CatResult selectItemCategory();
}
