package com.tt.common.redis.service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.service
 * @version:
 */
public interface ContentService {
    void insertContentAD(List<Map> list);

    List<Map> selectContentAD();
}
