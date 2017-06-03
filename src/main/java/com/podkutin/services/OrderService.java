package com.podkutin.services;

import com.podkutin.views.OrderVO;

import java.util.List;

/**
 * Created by apodkutin on 6/3/17.
 */
public interface OrderService {

    OrderVO createOrder(final OrderVO orderVO);

    OrderVO showOrder( final Long orderId);

    void destroyOrder(final Long orderId);

    List<OrderVO> getOrdersByClientId(final Long clientId);
}
