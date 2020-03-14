package com.tt.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.item.service.ItemParamService;
import com.tt.mapper.TbItemParamMapper;
import com.tt.pojo.TbItemParam;
import com.tt.pojo.TbItemParamExample;
import com.tt.pojo.TbItemParamItemExample;
import com.tt.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.service.impl
 * @version:
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public TbItemParam selectItemParamByItemCatId(Long itemCatId) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(itemCatId);
        List<TbItemParam> tbItemParams = this.itemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams != null && tbItemParams.size()>0){
            return tbItemParams.get(0);
        }
        return null;
    }

    /**
     * 查询所有产品规格模板
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult selectItemParamAll(@RequestParam Integer page,@RequestParam Integer rows) {
        PageHelper.startPage(page,rows);
        TbItemParamExample example = new TbItemParamExample();
        List<TbItemParam> list = this.itemParamMapper.selectByExampleWithBLOBs(example);
        PageInfo<TbItemParam>paramPageInfo = new PageInfo<>(list);
        PageResult pageResult = new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setResult(paramPageInfo.getList());
        pageResult.setTotalPage(paramPageInfo.getTotal());
        return pageResult;
    }

    @Override
    @LcnTransaction
    public Integer insertItemParam(TbItemParam tbItemParam) {
        return this.itemParamMapper.insertSelective(tbItemParam);
    }

    @Override
    @LcnTransaction
    public Integer deleteItemParamById(Long id) {

        return itemParamMapper.deleteByPrimaryKey(id);
    }
}
