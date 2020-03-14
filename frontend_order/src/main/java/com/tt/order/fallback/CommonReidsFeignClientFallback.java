package com.tt.order.fallback;

import com.tt.order.feign.CommonRedisFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.order.fallback
 * @version:
 */
@Component
public class CommonReidsFeignClientFallback implements FallbackFactory<CommonRedisFeignClient> {
    @Override
    public CommonRedisFeignClient create(Throwable throwable) {
        return new CommonRedisFeignClient() {
            @Override
            public Long selectOrderId() {
                return null;
            }
        };
    }
}
