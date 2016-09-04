package com.podkutin.utils.mapping;

import com.podkutin.entities.OrderDO;
import com.podkutin.view.OrderVO;

import java.util.function.Function;

/**
 * Created by apodkutin on 9/4/2016.
 */
public class OrderMappingFunction implements Function<OrderDO, OrderVO> {
    @Override
    public OrderVO apply(OrderDO order) {
        if (order == null) {
            return null;
        }

        OrderVO orderVO = new OrderVO(order.getId(), order.getNumber(), null);
        return orderVO;
    }
}
