package com.tt.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.order.feign
 * @version:
 */
@FeignClient(value = "common-redis")
public interface CommonRedisFeignClient {

    @PostMapping("/redis/order/selectOrderId")
    Long selectOrderId();
}
