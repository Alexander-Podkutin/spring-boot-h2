package com.podkutin.services.impl;

import com.podkutin.entities.ClientDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.exception.ClientNotFoundException;
import com.podkutin.exception.OrderNotFoundException;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.repositories.OrderRepository;
import com.podkutin.services.OrderService;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.utils.mapping.OrderMappingFunction;
import com.podkutin.views.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 6/3/17.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public OrderVO createOrder(OrderVO orderVO) {

        ValidationUtils.validateParam(orderVO.getClientId(),
                String.format("Error input value clientId=[%s]", orderVO.getClientId()));
        final ClientDO client = clientRepository.findOne(orderVO.getClientId());

        if (client == null) {
            throw new ClientNotFoundException(String.format("ClientDO with id=[%s], not found",
                    orderVO.getClientId()));
        }
        final OrderDO orderDO = new OrderDO(orderVO.getNumber(), client);
        orderRepository.save(orderDO);

        return new OrderMappingFunction().apply(orderDO);
    }

    @Override
    public OrderVO showOrder(Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));
        final OrderDO orderDO = orderRepository.findOne(orderId);

        if (orderDO == null) {
            throw new OrderNotFoundException(String.format("OrderDO with id=[%s], not found", orderId));
        }

        return new OrderMappingFunction().apply(orderDO);
    }

    @Override
    public void destroyOrder(Long orderId) {
        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));
        orderRepository.delete(orderId);
    }

    @Override
    public List<OrderVO> getOrdersByClientId(Long clientId) {

        ValidationUtils.validateParam(clientId, String.format("Error input value clientId=[%s]", clientId));
        return orderRepository.findByClientDO(
                clientRepository.findOne(clientId)).stream().
                map(new OrderMappingFunction()).
                collect(Collectors.<OrderVO>toList());
    }
}
