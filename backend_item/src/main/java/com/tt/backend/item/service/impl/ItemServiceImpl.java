package com.tt.backend.item.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.sun.org.apache.regexp.internal.RE;
import com.tt.backend.item.feign.CommonItemFeignClient;
import com.tt.backend.item.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import com.tt.utils.IDUtils;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.backend.item.service.impl
 * @version:
 * 商品管理
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Value("${test}")
    private String test;

    @Autowired
    private CommonItemFeignClient commonItemFeignClient;
    @Override
    public Result selectTbItemAllByPage(Integer page, Integer rows) {
        //System.out.println("---------=====测试======--------------"+this.test);
        PageResult pageResult = this.commonItemFeignClient.selectTbItemAllByPage(page, rows);
        if (pageResult != null && pageResult.getResult() != null && pageResult.getResult().size() > 0){
            return  Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 添加TbItem，TbItemDesc,TbItemParamItem
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @Override
    @LcnTransaction
    public Result insertTbItem(TbItem tbItem, String desc, String itemParams) {
        Date d = new Date();
        // 补齐TbItem数据
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        tbItem.setStatus((byte) 1);
        tbItem.setUpdated(d);
        tbItem.setCreated(d);
        Integer tbItemNum = this.commonItemFeignClient.insertTbItem(tbItem);

        // 补齐商品描述对象
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(d);
        tbItemDesc.setUpdated(d);
        Integer tbItemDescNum = this.commonItemFeignClient.insertItemDesc(tbItemDesc);

        // 补齐商品规格参数
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setCreated(d);
        tbItemParamItem.setUpdated(d);
        Integer itemParamItemNum = this.commonItemFeignClient.insertTbItemParamItem(tbItemParamItem);

        if (tbItemNum == null || tbItemDescNum == null || itemParamItemNum == null){
            throw new RuntimeException();
        }

        return Result.ok();
    }

    @Override
    @LcnTransaction
    public Result deleteItemById(Long itemId) {
        TbItem item = new TbItem();
        item.setId(itemId);
        item.setStatus((byte) 3);
        Integer itemById = commonItemFeignClient.deleteItemById(item);
        if (itemById!=null){
            return Result.ok();
        }
        if (itemById == null){
            throw new RuntimeException();
        }
        return Result.error("删除失败");
    }

    @Override
    public Result preUpdateItem(Long itemId) {
        Map<String,Object> map = this.commonItemFeignClient.preUpdateItem(itemId);
        if (map != null){
            return Result.ok(map);
        }
        return Result.error("查无结果");
    }

    @Override
    @LcnTransaction
    public Result updateTbItem(TbItem tbItem, String desc, String itemParam) {
        // 更新商品信息
        this.commonItemFeignClient.updateTbitem(tbItem);

        // 更新商品描述
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(tbItem.getId());
        tbItemDesc.setUpdated(new Date());
        tbItemDesc.setItemDesc(desc);
        Integer tbItemDescNum = commonItemFeignClient.updateItemDesc(tbItemDesc);

        // 更新商品规格参数
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(tbItem.getId());
        tbItemParamItem.setUpdated(new Date());
        tbItemParamItem.setParamData(itemParam);
        Integer tbItemParamItemNum = commonItemFeignClient.insertTbItemParamItem(tbItemParamItem);
        if (tbItemDescNum == null || tbItemParamItemNum == null){
            throw new RuntimeException();
        }

        return Result.ok();
    }
}
