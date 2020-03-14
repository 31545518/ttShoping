package com.tt.cart.fallback;


import com.tt.cart.feign.CommonItemFeignClient;
import com.tt.pojo.TbItem;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.cart.fallback
 * @version:
 */
@Component
public class CommonItemFeignClientFallbackFactory implements FallbackFactory<CommonItemFeignClient> {
    @Override
    public CommonItemFeignClient create(Throwable throwable) {
        return new CommonItemFeignClient() {
            @Override
            public TbItem selectItemInfo(Long itemId) {
                return null;
            }
        };
    }
}
