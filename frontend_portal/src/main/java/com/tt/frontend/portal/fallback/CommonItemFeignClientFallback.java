package com.tt.frontend.portal.fallback;

import com.tt.frontend.portal.feign.CommonItemFeignClient;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import com.tt.utils.CatResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.frontend.portal.fallback
 * @version:
 */
@Component
public class CommonItemFeignClientFallback implements FallbackFactory<CommonItemFeignClient> {
    @Override
    public CommonItemFeignClient create(Throwable throwable) {
        return new CommonItemFeignClient() {
            @Override
            public CatResult selectItemCategoryAll() {
                return null;
            }

            @Override
            public TbItem selectItemInfo(Long itemId) {
                return null;
            }

            @Override
            public TbItemDesc selectItemDescByItemId(Long itemId) {
                return null;
            }

            @Override
            public TbItemParamItem selectTbItemParamItemByItemId(Long itemId) {
                return null;
            }
        };
    }
}
