package com.tt.content.fallback;

import com.tt.content.feign.CommonContentFeignClient;
import com.tt.pojo.TbContent;
import com.tt.pojo.TbContentCategory;
import com.tt.utils.PageResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-09
 * @Description: com.tt.content.fallback
 * @version:
 */
@Component
public class CommonContentFeignFallbackFactory implements FallbackFactory<CommonContentFeignClient> {
    @Override
    public CommonContentFeignClient create(Throwable throwable) {
        return new CommonContentFeignClient() {
            @Override
            public List<TbContentCategory> selectContentCategoryByParentId(Long parentId) {
                return null;
            }

            @Override
            public Integer insertContentCategory(TbContentCategory tbContentCategory) {
                return null;
            }

            @Override
            public Integer deleteContentCategoryById(Long categoryId) {
                return null;
            }

            @Override
            public Integer updateContentCategory(TbContentCategory tbContentCategory) {
                return null;
            }

            @Override
            public PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId) {
                return null;
            }

            @Override
            public Integer insertTbContent(TbContent tbContent) {
                return null;
            }

            @Override
            public Integer deleteContentByIds(Long id) {
                return null;
            }

            @Override
            public List<Map> selectFrontendContentByAD() {
                return null;
            }
        };
    }
}
