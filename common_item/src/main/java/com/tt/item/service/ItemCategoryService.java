package com.tt.item.service;

import com.tt.pojo.TbItemCat;
import com.tt.utils.CatResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.service
 * @version:
 */
public interface ItemCategoryService {

    List<TbItemCat> selectItemCategoryByParentId(Long id);
    CatResult selectItemCategoryAll();
}
