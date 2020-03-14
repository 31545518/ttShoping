package com.tt.cart.fallback;

import com.tt.cart.feign.CommonRedisFeignClient;
import com.tt.pojo.TbUser;
import com.tt.utils.CartItem;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.cart.fallback
 * @version:
 */
@Component
public class CommonRedisFeignClientFallbackFactory implements FallbackFactory<CommonRedisFeignClient> {
    @Override
    public CommonRedisFeignClient create(Throwable throwable) {
        return new CommonRedisFeignClient() {
            @Override
            public void insertCart(Map<String, Object> map) {

            }

            @Override
            public Map<String, CartItem> selectCartByUserId(String userId) {
                return null;
            }

            @Override
            public TbUser checkUserToken(String token) {
                return null;
            }
        };
    }
}
