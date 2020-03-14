package com.tt.common.redis.service.impl;

import com.tt.common.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 订单处理业务
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.common.redis.service.impl
 * @version:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate<String,Object>redisTemplate;
    @Value("${order_item_key}")
    private String order_item_key;
    @Value("${init_item_id}")
    private Long init_item_id;

    @Override
    public Long selectOrderId() {
        Integer value = (Integer) this.redisTemplate.opsForValue().get(this.order_item_key);
        // 如果订单ID的值不存在，将默认值set到redis中
        if (value == null || value <= 0){
            this.redisTemplate.opsForValue().set(this.order_item_key,this.init_item_id);
        }
        // 通过redis中的自增长将默认值传递处理
        Long orderId = this.redisTemplate.opsForValue().increment(this.order_item_key);

        return orderId;
    }
}
