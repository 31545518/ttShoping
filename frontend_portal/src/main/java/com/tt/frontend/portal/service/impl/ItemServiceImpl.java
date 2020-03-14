package com.tt.frontend.portal.service.impl;

import com.tt.frontend.portal.feign.CommonItemFeignClient;
import com.tt.frontend.portal.feign.CommonRedisFeignClient;
import com.tt.frontend.portal.service.ItemService;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询商品业务层
 * @Auther: blackcat
 * @Date: 2020-02-28
 * @Description: com.tt.frontend.portal.service.impl
 * @version:
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;
    @Autowired
    private CommonRedisFeignClient commonRedisFeignClient;

    /**
     * 查询商品基本信息
     * @param itemId
     * @return
     */
    @Override
    public Result selectItemInfo(Long itemId) {
        try {
            TbItem item = commonRedisFeignClient.selectItemBasicInfo(itemId);
            if (item != null){
                return Result.ok(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TbItem item = commonItemFeignClient.selectItemInfo(itemId);
        try {
            if (item != null){
                this.commonRedisFeignClient.insertItemBasicInfo(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (item != null){
            return Result.ok(item);
        }
        return Result.error("查无结果");
    }

    /**
     * 查询商品介绍
     * @param itemId
     * @return
     */
    @Override
    public Result selectItemDescByItemId(Long itemId) {

        try {
            TbItemDesc tbItemDesc = this.commonRedisFeignClient.selectItemDesc(itemId);
            if (tbItemDesc != null){
                return Result.ok(tbItemDesc);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        TbItemDesc tbItemDesc = this.commonItemFeignClient.selectItemDescByItemId(itemId);
        try {
            if (tbItemDesc != null){
                this.commonRedisFeignClient.insertItemDesc(tbItemDesc);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (tbItemDesc != null){
            return Result.ok(tbItemDesc);
        }
        return Result.error("查无结果");
    }

    /**
     * 根据商品ID查询商品规格参数
     * @param itemId
     * @return
     */
    @Override
    public Result selectTbItemParamItemByItemId(Long itemId) {
        try{
            TbItemParamItem tbItemParamItem = this.commonRedisFeignClient.selectItemParamItem(itemId);
            if (tbItemParamItem != null){
                return Result.ok(tbItemParamItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        TbItemParamItem tbItemParamItem = this.commonItemFeignClient.selectTbItemParamItemByItemId(itemId);
        try {
            if (tbItemParamItem != null){
                this.commonRedisFeignClient.insertItemParamItem(tbItemParamItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if (tbItemParamItem != null){
            return Result.ok(tbItemParamItem);
        }
        return Result.error("查无结果");
    }
}
