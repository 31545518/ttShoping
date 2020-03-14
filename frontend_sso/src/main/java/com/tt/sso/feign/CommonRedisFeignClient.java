package com.tt.sso.feign;

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
 * @Date: 2020-03-01
 * @Description: com.tt.sso.feign
 * @version:
 */
@FeignClient(value = "common-redis")
public interface CommonRedisFeignClient {

    @PostMapping("/sso/redis/insertUser")
    void insertUser(@RequestBody TbUser tbUser, @RequestParam("userToken") String userToken);

    @PostMapping("/sso/redis/logOut")
    void logOut(@RequestParam String userToken);

    @PostMapping("/redis/cart/selectCartByUserId")
    Map<String, CartItem> selectCartByUserId(@RequestParam("userId") String userId);

    @PostMapping("/redis/cart/insertCart")
    void insertCart(@RequestBody Map<String,Object> map);

}
