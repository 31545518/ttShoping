package com.tt.backend.item.service.impl;

import com.tt.backend.item.feign.CommonItemFeignClient;
import com.tt.backend.item.service.ItemCategoryService;
import com.tt.pojo.TbItemCat;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.service.impl
 * @version:
 * 商品类目
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;

    /**
     * 根据类目查询子类目
     * @param id
     * @return
     */
    @Override
    public Result selectItemCategoryByParentId(Long id) {
        List<TbItemCat> tbItemCats = commonItemFeignClient.selectItemCategoryByParentId(id);
        if (tbItemCats != null && tbItemCats.size()>0){
            return Result.ok(tbItemCats);
        }
        return Result.error("查无结果");
    }
}
