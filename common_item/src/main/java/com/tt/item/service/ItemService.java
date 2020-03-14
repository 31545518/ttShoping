package com.tt.item.service;

import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.utils.PageResult;
import com.tt.utils.Result;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.item.service
 * @version:
 */
public interface ItemService {
    //查询所有商品- 分页
    PageResult selectTbItemAllByPage(Integer page,Integer rows);
    // 插入新增商品
    public Integer insertTbItem(TbItem tbItem);
    // 删除商品
    Integer updateItemById(TbItem tbItem);
    // 根据商品id查询商品信息
    Map<String, Object> preUpdateItem(Long itemId);
    // 根据商品ID查询商品
    TbItem selectItemInfo(Long itemId);

}
