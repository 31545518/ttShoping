package com.tt.order.fallback;

import com.tt.order.feign.FrontendCartFeignClient;
import com.tt.utils.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.order.fallback
 * @version:
 */
@Component
public class FrontendCartFeignClientFallback implements FallbackFactory<FrontendCartFeignClient> {
    @Override
    public FrontendCartFeignClient create(Throwable throwable) {
        return new FrontendCartFeignClient() {
            @Override
            public Result deleteItemFromCart(Long itemId, String userId) {
                return null;
            }
        };
    }
}
