package com.podkutin.controller;

import com.podkutin.entities.ItemDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.exception.ItemNotFoundException;
import com.podkutin.exception.OrderNotFoundException;
import com.podkutin.repositories.ItemRepository;
import com.podkutin.repositories.OrderRepository;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.utils.mapping.ItemMappingFunction;
import com.podkutin.views.ItemVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 10/30/16.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public ItemController(final ItemRepository itemRepository, final OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public List<ItemVO> getItemsByOrderId(@PathVariable final Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));

        final List<ItemVO> itemsVO = itemRepository.findByOrderDO(
                orderRepository.findOne(orderId)).stream().
                map(new ItemMappingFunction()).
                collect(Collectors.<ItemVO>toList());

        return itemsVO;

    }

    @RequestMapping(value = "/show/{itemId}", method = RequestMethod.GET)
    public ItemVO showItem(@PathVariable final Long itemId) {

        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));

        final ItemDO itemDO = itemRepository.findOne(itemId);

        if (itemDO == null) {
            throw new ItemNotFoundException(String.format("ItemDO with id=[%s], not found", itemId));
        }

        final ItemVO itemVO = new ItemMappingFunction().apply(itemDO);
        return itemVO;
    }

    @RequestMapping(value = "/destroy/{itemId}", method = RequestMethod.DELETE)
    public void destroyItem(@PathVariable final Long itemId) {

        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));

        itemRepository.delete(itemId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody ItemVO createItem(@RequestBody final ItemVO itemVO) {

        ValidationUtils.validateParam(itemVO.getOrderId(),
                String.format("Error input value orderId=[%s]", itemVO.getOrderId()));

        OrderDO orderDO = orderRepository.findOne(itemVO.getOrderId());
        if (orderDO == null) {
            throw new OrderNotFoundException(String.format("OrderDO with id=[%s], not found",
                    itemVO.getOrderId()));
        }

        ItemDO itemDO = new ItemDO(itemVO.getName(), orderDO, itemVO.getQuantity());
        itemRepository.save(itemDO);
        return new ItemMappingFunction().apply(itemDO);
    }

}