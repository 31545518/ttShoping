package com.tt.frontend.portal.service.impl;

import com.tt.frontend.portal.feign.CommonItemFeignClient;
import com.tt.frontend.portal.feign.CommonRedisFeignClient;
import com.tt.frontend.portal.service.ItemCategoryService;
import com.tt.utils.CatResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.frontend.portal.service.impl
 * @version:
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;
    @Autowired
    private CommonRedisFeignClient commonRedisFeignClient;

    @Override
    public Result selectItemCategoryAll() {
        // 查询缓存
        try{
            CatResult catResult = this.commonRedisFeignClient.selectItemCategory();
            // 判断缓存中是否有数据
            if (catResult != null && catResult.getData()!= null && catResult.getData().size() > 0){
                return Result.ok(catResult);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 查询数据库
        CatResult catResult = commonItemFeignClient.selectItemCategoryAll();
        // 添加到缓存
        try {
            if (catResult != null && catResult.getData() != null && catResult.getData().size() > 0){
                this.commonRedisFeignClient.insertItemCategory(catResult);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (catResult != null && catResult.getData() != null && catResult.getData().size() > 0){
            return Result.ok(catResult);
        }

        return Result.error("查无结果");
    }
}
