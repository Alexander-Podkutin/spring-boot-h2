package com.podkutin.controller;

import com.podkutin.services.OrderService;
import com.podkutin.utils.ValidationUtils;
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

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public List<OrderVO> getOrdersByClientId(@PathVariable final Long clientId) {
        return orderService.getOrdersByClientId(clientId);
    }

    @RequestMapping(value = "/show/{orderId}", method = RequestMethod.GET)
    public OrderVO showOrder(@PathVariable final Long orderId) {
        return orderService.showOrder(orderId);
    }

    @RequestMapping(value = "/destroy/{orderId}", method = RequestMethod.DELETE)
    public void destroyOrder(@PathVariable final Long orderId) {
        orderService.destroyOrder(orderId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody OrderVO createOrder(@RequestBody final OrderVO orderVO) {
        return orderService.createOrder(orderVO);
    }
}
