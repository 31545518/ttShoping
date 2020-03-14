package com.tt.frontend.portal.feign;

import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemParamItem;
import com.tt.utils.CatResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.frontend.portal.feign
 * @version:
 */
@FeignClient(value = "common-item")
public interface CommonItemFeignClient {


    //-------------------------
    @PostMapping("/service/itemCategory/selectItemCategoryAll")
    CatResult selectItemCategoryAll();

    @PostMapping("/service/item/selectItemInfo")
    TbItem selectItemInfo(@RequestParam("itemId") Long itemId);

    //---------------------------
    @PostMapping("/service/itemDesc/selectItemDescByItemId")
    TbItemDesc selectItemDescByItemId(@RequestParam("itemId") Long itemId);

    //---------------------------
    @PostMapping("/service/itemParamItem/selectTbItemParamItemByItemId")
    TbItemParamItem selectTbItemParamItemByItemId(@RequestParam("itemId") Long itemId);

}
