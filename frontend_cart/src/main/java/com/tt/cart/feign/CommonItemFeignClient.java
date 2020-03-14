package com.tt.cart.feign;

import com.tt.pojo.TbItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.cart.feign
 * @version:
 */
@FeignClient(value = "common-item")
public interface CommonItemFeignClient {

    @PostMapping("/service/item/selectItemInfo")
    TbItem selectItemInfo(@RequestParam("itemId") Long itemId);

}
