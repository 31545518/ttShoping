package com.tt.common.redis.service.impl;

import com.netflix.discovery.converters.Auto;
import com.tt.common.redis.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.common.redis.service.impl
 * @version:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RedisTemplate<String,Object>redisTemplate;
    @Value("${frontend_item_basic_info_key}")
    private String frontend_item_basic_info_key;
    @Value("frontend_item_desc_key")
    private String frontend_item_desc_key;
    @Value("frontend_item_param_key")
    private String frontend_item_param_key;

    /**
     * 缓存商品基本信息
     * @param tbItem
     */
    @Override
    public void insertItemBasicInfo(TbItem tbItem) {
        this.redisTemplate.opsForValue().set(this.frontend_item_basic_info_key+":"+tbItem.getId(),tbItem);
    }

    /**
     * 查询缓存中的商品基本信息
     * @param tbItemId
     * @return
     */
    @Override
    public TbItem selectItemBasicInfo(Long tbItemId) {
        return (TbItem) this.redisTemplate.opsForValue().get(this.frontend_item_basic_info_key+":"+tbItemId);
    }

    /**
     * 缓存商品简绍信息
     * @param tbItemDesc
     */
    @Override
    public void insertItemDesc(TbItemDesc tbItemDesc) {
        this.redisTemplate.opsForValue().set(this.frontend_item_desc_key+":"+tbItemDesc.getItemId(),tbItemDesc);
    }

    /**
     * 查询缓存简绍信息
     * @param tbItemId
     * @return
     */
    @Override
    public TbItemDesc selectItemDesc(Long tbItemId) {
        return (TbItemDesc) this.redisTemplate.opsForValue().get(this.frontend_item_desc_key+":"+tbItemId);
    }

    /**
     * 缓存商品规格参数
     * @param tbItemParamItem
     */
    @Override
    public void insertItemParamItem(TbItemParamItem tbItemParamItem) {
        this.redisTemplate.opsForValue().set(this.frontend_item_param_key+":"+tbItemParamItem.getItemId(),tbItemParamItem);
    }

    /**
     * 查询缓存中的商品规格参数
     * @param tbItemId
     * @return
     */
    @Override
    public TbItemParamItem selectItemParamItem(Long tbItemId) {
        return (TbItemParamItem) this.redisTemplate.opsForValue().get(this.frontend_item_param_key+":"+tbItemId);
    }
}
