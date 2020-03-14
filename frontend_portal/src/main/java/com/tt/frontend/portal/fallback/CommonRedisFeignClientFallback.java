package com.tt.frontend.portal.fallback;

import com.tt.frontend.portal.feign.CommonRedisFeignClient;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import com.tt.utils.CatResult;
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
public class CommonRedisFeignClientFallback implements FallbackFactory<CommonRedisFeignClient> {
    @Override
    public CommonRedisFeignClient create(Throwable throwable) {
        return new CommonRedisFeignClient() {
            @Override
            public void insertItemCategory(CatResult catResult) {

            }

            @Override
            public CatResult selectItemCategory() {
                return null;
            }

            @Override
            public void insertContentAD(List<Map> list) {

            }

            @Override
            public List<Map> selectContentAD() {
                return null;
            }

            @Override
            public void insertItemBasicInfo(TbItem tbItem) {

            }

            @Override
            public TbItem selectItemBasicInfo(Long tbItemId) {
                return null;
            }

            @Override
            public void insertItemDesc(TbItemDesc tbItemDesc) {

            }

            @Override
            public TbItemDesc selectItemDesc(Long tbItemId) {
                return null;
            }

            @Override
            public void insertItemParamItem(TbItemParamItem tbItemParamItem) {

            }

            @Override
            public TbItemParamItem selectItemParamItem(Long tbItemId) {
                return null;
            }
        };
    }
}
