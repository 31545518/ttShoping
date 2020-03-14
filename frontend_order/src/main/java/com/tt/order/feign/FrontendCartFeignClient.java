package com.tt.order.feign;

import com.tt.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.order.feign
 * @version:
 */
@FeignClient(value = "frontend-cart")
public interface FrontendCartFeignClient {


    @PostMapping("/cart/deleteItemFromCart")
    Result deleteItemFromCart(@RequestParam("itemId") Long itemId, @RequestParam("userId") String userId);
}
