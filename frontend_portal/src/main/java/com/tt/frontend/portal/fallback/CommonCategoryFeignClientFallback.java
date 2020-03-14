package com.tt.frontend.portal.fallback;

import com.tt.frontend.portal.feign.CommonCategoryFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.frontend.portal.fallback
 * @version:
 */
@Component
public class CommonCategoryFeignClientFallback implements FallbackFactory<CommonCategoryFeignClient> {
    @Override
    public CommonCategoryFeignClient create(Throwable throwable) {
        return new CommonCategoryFeignClient() {
            @Override
            public List<Map> selectFrontendContentByAD() {
                return null;
            }
        };
    }
}
