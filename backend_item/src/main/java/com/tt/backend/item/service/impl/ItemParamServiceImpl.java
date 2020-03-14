package com.tt.backend.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.backend.item.feign.CommonItemFeignClient;
import com.tt.backend.item.service.ItemParamService;
import com.tt.pojo.TbItemParam;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.backend.item.service.impl
 * @version:
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;

    @Override
    public Result selectItemParamByItemCatId(Long itemCatId) {
        TbItemParam tbItemParam = commonItemFeignClient.selectItemParamByItemCatId(itemCatId);
        if (tbItemParam != null){
            return Result.ok(tbItemParam);
        }

        return Result.error("查无结果");
    }

    @Override
    public Result selectItemParamAll(Integer page,Integer rows) {
        PageResult pageResult = commonItemFeignClient.selectItemParamAll(page, rows);
        if (pageResult != null && pageResult.getResult().size()>0){
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 添加商品分类规格参数模板
     * @param itemCatId
     * @param paramData
     * @return
     */

    @Override
    @LcnTransaction
    public Result insertItemParam(Long itemCatId ,String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(itemCatId);
        tbItemParam.setParamData(paramData);
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());

        Integer param = this.commonItemFeignClient.insertItemParam(tbItemParam);
        if (param != null){
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    @Override
    @LcnTransaction
    public Result deleteItemParamById(Long id) {
        Integer param = this.commonItemFeignClient.deleteItemParamById(id);
        if (param != null && param > 0){
            return Result.ok();
        }
        return Result.error("删除失败");
    }
}
