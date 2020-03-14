package com.tt.item.service;

import com.tt.pojo.TbItemParam;
import com.tt.utils.PageResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.service
 * @version:
 */
public interface ItemParamService {
    public TbItemParam selectItemParamByItemCatId(Long itemCatId);
    // 产品规格模板
    public PageResult selectItemParamAll(Integer page, Integer rows);
    // 添加商品规格
    Integer insertItemParam(TbItemParam tbItemParam);
    // 删除商品规格
    Integer deleteItemParamById(Long id);
}