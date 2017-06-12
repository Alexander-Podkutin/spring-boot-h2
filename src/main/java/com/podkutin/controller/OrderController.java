package com.podkutin.controller;

import com.podkutin.services.OrderService;
import com.podkutin.views.OrderVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by apodkutin on 9/6/2016.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/clients/{clientId}", method = RequestMethod.GET)
    public List<OrderVO> listOrdersByClientId(@PathVariable final Long clientId) {
        return orderService.getOrdersByClientId(clientId);
    }

    @RequestMapping(path = "/{orderId}", method = RequestMethod.GET)
    public OrderVO getOrder(@PathVariable final Long orderId) {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(path = "/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable final Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody OrderVO createOrder(@RequestBody final OrderVO orderVO) {
        return orderService.createOrder(orderVO);
    }
}
