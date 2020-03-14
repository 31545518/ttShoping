package com.tt.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.item.service.ItemParamItemService;
import com.tt.mapper.TbItemParamItemMapper;
import com.tt.pojo.TbItemParamItem;
import com.tt.pojo.TbItemParamItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-01
 * @Description: com.tt.item.service.impl
 * @version:
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Override
    @LcnTransaction
    public Integer insertTbItemParamItem(TbItemParamItem tbItemParamItem) {
        return tbItemParamItemMapper.insert(tbItemParamItem);
    }

    @Override
    @LcnTransaction
    public Integer upateItemParamItem(TbItemParamItem tbItemParamItem) {
        tbItemParamItem.setUpdated(new Date());
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(tbItemParamItem.getItemId());
        return tbItemParamItemMapper.updateByExampleSelective(tbItemParamItem,example);
    }

    /**
     * 根据商品ID查询商品规格参数
     * @param itemId
     * @return
     */
    @Override
    public TbItemParamItem selectTbItemParamItemByItemId(Long itemId) {
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = this.tbItemParamItemMapper.selectByExampleWithBLOBs(example);

        return tbItemParamItems.get(0);
    }
}
