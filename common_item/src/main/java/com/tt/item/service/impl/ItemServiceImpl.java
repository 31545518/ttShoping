package com.tt.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.item.service.ItemService;
import com.tt.mapper.TbItemCatMapper;
import com.tt.mapper.TbItemDescMapper;
import com.tt.mapper.TbItemMapper;
import com.tt.mapper.TbItemParamItemMapper;
import com.tt.pojo.*;
import com.tt.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.item.service.impl
 * @version:
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    /**
     * 查询所有商品并分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult selectTbItemAllByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        List<TbItem>list = this.tbItemMapper.selectByExample(example);
        PageInfo<TbItem>pageInfo = new PageInfo<>(list);
        PageResult result = new PageResult();
        result.setPageIndex(page);
        result.setTotalPage(pageInfo.getTotal());
        result.setResult(list);

        return result;
    }

    /**
     * 添加商品规格
     * @param tbItem
     * @return
     */
    @Override
    @LcnTransaction
    public Integer insertTbItem(TbItem tbItem) {

        return this.tbItemMapper.insert(tbItem);
    }

    @Override
    @LcnTransaction
    public Integer updateItemById(TbItem tbItem) {
        tbItem.setUpdated(new Date());
        return this.tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    @Override
    public Map<String, Object> preUpdateItem(Long itemId) {
        Map<String,Object>map = new HashMap<>();
        // 根据商品ID查询商品
        TbItem item = this.tbItemMapper.selectByPrimaryKey(itemId);
        map.put("item",item);
        // 根据商品ID查询商品描述
        TbItemDesc tbItemDesc = this.tbItemDescMapper.selectByPrimaryKey(itemId);
        map.put("itemDesc",tbItemDesc.getItemDesc());
        // 根据商品ID查询商品类目
        TbItemCat itemCat = this.tbItemCatMapper.selectByPrimaryKey(item.getCid());
        map.put("itemCat",itemCat.getName());
        // 根据商品ID查询商品规格参数
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size() > 0){
            map.put("itemParamItem",list.get(0));
        }

        return map;
    }

    @Override
    public TbItem selectItemInfo(Long itemId) {

        return this.tbItemMapper.selectByPrimaryKey(itemId);
    }


}
