package com.podkutin.controller;

import com.podkutin.entities.OrderDO;
import com.podkutin.exception.OrderNotFoundException;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.repositories.OrderRepository;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.utils.mapping.OrderMappingFunction;
import com.podkutin.views.OrderVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 9/6/2016.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderController(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public List<OrderVO> getOrderByClientId(@PathVariable final Long clientId) {

        ValidationUtils.validateParam(clientId, String.format("Error input value clientId=[%s]", clientId));

        final List<OrderVO> ordersVO = orderRepository.findByClientDO(
                clientRepository.findOne(clientId)).stream().
                map(new OrderMappingFunction()).
                collect(Collectors.<OrderVO>toList());

        return ordersVO;
    }

    @RequestMapping(value = "/show/{orderId}", method = RequestMethod.GET)
    public OrderVO showOrder(@PathVariable final Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));

        final OrderDO orderDO = orderRepository.findOne(orderId);

        if (orderDO == null) {
            throw new OrderNotFoundException(String.format("OrderDO with id=[%s], not found", orderId));
        }

        final OrderVO orderVO = new OrderMappingFunction().apply(orderDO);
        return orderVO;
    }

    @RequestMapping(value = "/destroy/{orderId}", method = RequestMethod.DELETE)
    public void destroyOrder(@PathVariable final Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));
        orderRepository.delete(orderId);
    }


}
