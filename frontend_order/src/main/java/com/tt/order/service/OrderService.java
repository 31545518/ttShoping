package com.tt.order.service;

import com.tt.pojo.TbOrder;
import com.tt.pojo.TbOrderItem;
import com.tt.pojo.TbOrderShipping;
import com.tt.utils.Result;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.order.service
 * @version:
 */
public interface OrderService {
    Result insertOrder(List<TbOrderItem> list, TbOrder tbOrder, TbOrderShipping tbOrderShipping);
}
