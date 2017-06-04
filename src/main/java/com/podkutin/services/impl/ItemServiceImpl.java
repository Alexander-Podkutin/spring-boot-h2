package com.podkutin.services.impl;

import com.podkutin.entities.ItemDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.exception.ItemNotFoundException;
import com.podkutin.exception.OrderNotFoundException;
import com.podkutin.repositories.ItemRepository;
import com.podkutin.repositories.OrderRepository;
import com.podkutin.services.ItemService;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.utils.mapping.ItemMappingFunction;
import com.podkutin.views.ItemVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 6/3/17.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public ItemServiceImpl(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ItemVO createItem(ItemVO itemVO) {

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

    @Override
    public ItemVO showItem(Long itemId) {

        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));
        final ItemDO itemDO = itemRepository.findOne(itemId);

        if (itemDO == null) {
            throw new ItemNotFoundException(String.format("ItemDO with id=[%s], not found", itemId));
        }

        return new ItemMappingFunction().apply(itemDO);
    }

    @Override
    public void destroyItem(Long itemId) {
        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));
        itemRepository.delete(itemId);
    }

    @Override
    public List<ItemVO> getItemsByOrderId(Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));

        return itemRepository.findByOrderDO(
                orderRepository.findOne(orderId)).stream().
                map(new ItemMappingFunction()).
                collect(Collectors.<ItemVO>toList());
    }
}
