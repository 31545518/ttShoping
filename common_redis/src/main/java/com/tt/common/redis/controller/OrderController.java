package com.tt.common.redis.controller;

import com.tt.common.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单业务
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/redis/order")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单ID
     * @return
     */
    @RequestMapping("/selectOrderId")
    public Long selectOrderId(){
        return this.orderService.selectOrderId();
    }

}
