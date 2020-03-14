package com.tt.order.controller;

import com.tt.order.service.OrderService;
import com.tt.pojo.TbOrder;
import com.tt.pojo.TbOrderItem;
import com.tt.pojo.TbOrderShipping;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.order.controller
 * @version:
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/insertOrder")
    public Result insertOrder(String orderItem, TbOrder tbOrder, TbOrderShipping tbOrderShipping){
        try {
            Result res = Result.formatObjectToList(orderItem, TbOrderItem.class);
            List<TbOrderItem> list = (List<TbOrderItem>) res.getData();
            return this.orderService.insertOrder(list,tbOrder,tbOrderShipping);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }


}
