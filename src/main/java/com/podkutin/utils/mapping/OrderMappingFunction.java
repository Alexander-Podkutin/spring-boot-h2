package com.podkutin.utils.mapping;

import com.podkutin.entities.OrderDO;
import com.podkutin.views.ItemVO;
import com.podkutin.views.OrderVO;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 9/4/2016.
 */
public class OrderMappingFunction implements Function<OrderDO, OrderVO> {
    @Override
    public OrderVO apply(final OrderDO orderDO) {
        if (orderDO == null) {
            return null;
        }

        final Set<ItemVO> itemsVO = orderDO.getItemsDO() != null ?
                orderDO.getItemsDO().stream().map(
                        new ItemMappingFunction()).collect(Collectors.<ItemVO>toSet()) :
                null;

        final OrderVO orderVO = new OrderVO(orderDO.getId(),
                orderDO.getNumber(),
                orderDO.getClientDO() != null ? orderDO.getClientDO().getId() : null,
                itemsVO);
        return orderVO;
    }
}
