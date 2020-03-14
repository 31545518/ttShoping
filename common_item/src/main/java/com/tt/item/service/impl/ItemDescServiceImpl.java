package com.tt.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.item.service.ItemDescService;
import com.tt.mapper.TbItemDescMapper;
import com.tt.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: blackcat
 * @Date: 2020-01-31
 * @Description: com.tt.item.service.impl
 * @version:
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    @LcnTransaction
    public Integer insertItemDesc(TbItemDesc tbItemDesc) {
        return tbItemDescMapper.insert(tbItemDesc);
    }

    @Override
    @LcnTransaction
    public Integer updateItemDesc(TbItemDesc tbItemDesc) {
        tbItemDesc.setUpdated(new Date());
        return this.tbItemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
    }

    @Override
    public TbItemDesc selectItemDescByItemId(Long itemId) {
        return this.tbItemDescMapper.selectByPrimaryKey(itemId);
    }
}
