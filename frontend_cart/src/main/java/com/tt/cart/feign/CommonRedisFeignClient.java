package com.tt.cart.feign;

import com.tt.pojo.TbUser;
import com.tt.utils.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-02
 * @Description: com.tt.cart.feign
 * @version:
 */
@FeignClient(value = "common-redis")
public interface CommonRedisFeignClient {

    @PostMapping("/redis/cart/insertCart")
    void insertCart(@RequestBody Map<String,Object> map);

    @PostMapping("/redis/cart/selectCartByUserId")
    Map<String, CartItem> selectCartByUserId(@RequestParam("userId") String userId);

    @PostMapping("/sso/redis/checkUserToken")
    TbUser checkUserToken(@RequestParam("token") String token);
}
