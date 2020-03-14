package com.tt.sso.fallback;

import com.tt.pojo.TbUser;
import com.tt.sso.feign.CommonRedisFeignClient;
import com.tt.utils.CartItem;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.sso.fallback
 * @version:
 */
@Component
public class CommonRedisFeignClientFallback implements FallbackFactory<CommonRedisFeignClient> {
    @Override
    public CommonRedisFeignClient create(Throwable throwable) {
        return new CommonRedisFeignClient() {
            @Override
            public void insertUser(TbUser tbUser, String userToken) {

            }

            @Override
            public void logOut(String userToken) {

            }

            @Override
            public Map<String, CartItem> selectCartByUserId(String userId) {
                return null;
            }

            @Override
            public void insertCart(Map<String, Object> map) {

            }
        };
    }
}
