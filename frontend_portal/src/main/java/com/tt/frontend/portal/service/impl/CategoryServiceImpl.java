package com.tt.frontend.portal.service.impl;

import com.tt.frontend.portal.feign.CommonCategoryFeignClient;
import com.tt.frontend.portal.feign.CommonItemFeignClient;
import com.tt.frontend.portal.feign.CommonRedisFeignClient;
import com.tt.frontend.portal.service.CategoryService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.frontend.portal.service.impl
 * @version:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CommonCategoryFeignClient commonCategoryFeignClient;
    @Autowired
    private CommonRedisFeignClient CommonRedisFeignClient;


    /**
     * 查询首页大广告位
     * @return
     */
    @Override
    public Result selectFrontendContentByAD() {
        // 查询缓存
        try {
            List<Map> list = this.CommonRedisFeignClient.selectContentAD();
            if (list != null && list.size() > 0){
                return Result.ok(list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        List<Map> maps = commonCategoryFeignClient.selectFrontendContentByAD();
        if (maps.size() >0 && maps != null){
            // 将查询到的数据添加到缓存中
            this.CommonRedisFeignClient.insertContentAD(maps);
        }
        if (maps != null && maps.size() > 0){
            return Result.ok(maps);
        }
        return Result.error("查无结果");
    }
}
