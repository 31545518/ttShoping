package com.tt.common.redis.service.impl;

import com.tt.common.redis.service.ItemCategroyService;
import com.tt.utils.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 缓存首页商品分类业务层
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.service.impl
 * @version:
 */
@Service
public class ItemCategroyServiceImpl implements ItemCategroyService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${frontend_catresult_reids_key}")
    private String frontend_catresult_reids_key;

    /**
     * 向首页中添加缓存数据
     * @param catResult
     */
    @Override
    public void insertItemCategory(CatResult catResult) {
        this.redisTemplate.opsForValue().set(frontend_catresult_reids_key,catResult);
    }

    /**
     * 查询首页中的数据
     * @return
     */
    @Override
    public CatResult selectItemCategory() {
        return (CatResult) redisTemplate.opsForValue().get(this.frontend_catresult_reids_key);
    }
}
