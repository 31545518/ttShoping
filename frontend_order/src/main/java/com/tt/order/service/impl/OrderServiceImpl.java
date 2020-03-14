package com.tt.order.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.mapper.TbOrderItemMapper;
import com.tt.mapper.TbOrderMapper;
import com.tt.mapper.TbOrderShippingMapper;
import com.tt.order.feign.CommonRedisFeignClient;
import com.tt.order.feign.FrontendCartFeignClient;
import com.tt.order.service.OrderService;
import com.tt.pojo.TbOrder;
import com.tt.pojo.TbOrderItem;
import com.tt.pojo.TbOrderShipping;
import com.tt.utils.IDUtils;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单服务业务层
 * @Auther: blackcat
 * @Date: 2020-03-04
 * @Description: com.tt.order.service.impl
 * @version:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;
    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;
    @Autowired
    private TbOrderShippingMapper tbOrderShippingMapper;
    @Autowired
    private CommonRedisFeignClient commonRedisFeignClient;
    @Autowired
    private FrontendCartFeignClient frontendCartFeignClient;

    /**
     * 创建订单
     * @param list
     * @param tbOrder
     * @param tbOrderShipping
     * @return
     */
    @Override
    @LcnTransaction
    public Result insertOrder(List<TbOrderItem> list, TbOrder tbOrder, TbOrderShipping tbOrderShipping) {
        // 获取订单ID
        Long orderId = this.commonRedisFeignClient.selectOrderId();
        // 补齐TbOrder数据
        tbOrder.setOrderId(orderId.toString());
        // 1.未支付 2.已支付 3.未发货 4.已发货 5.成功交易 6.交易关闭
        tbOrder.setStatus(1);
        Date date = new Date();
        tbOrder.setCreateTime(date);
        tbOrder.setUpdateTime(date);
        // 0.未评价 1.已评价
        tbOrder.setBuyerRate(0);
        // 将订单插入到数据库中
        this.tbOrderMapper.insert(tbOrder);

        // 插入订单中所包含的商品
        for (TbOrderItem item : list){
            item.setId(IDUtils.genItemId()+"");
            item.setOrderId(orderId.toString());
            this.tbOrderItemMapper.insert(item);
            this.frontendCartFeignClient.deleteItemFromCart(Long.parseLong(item.getItemId()),tbOrder.getUserId().toString());
        }
        // 插入物流表数据
        tbOrderShipping.setOrderId(orderId.toString());
        tbOrderShipping.setUpdated(date);
        tbOrderShipping.setCreated(date);
        this.tbOrderShippingMapper.insert(tbOrderShipping);

        return Result.ok(orderId);
    }
}
