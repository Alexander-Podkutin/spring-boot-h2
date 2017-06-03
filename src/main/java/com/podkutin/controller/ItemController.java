package com.podkutin.controller;

import com.podkutin.services.ItemService;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.views.ItemVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by apodkutin on 10/30/16.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public List<ItemVO> getItemsByOrderId(@PathVariable final Long orderId) {

        ValidationUtils.validateParam(orderId, String.format("Error input value orderId=[%s]", orderId));
        return itemService.getItemsByOrderId(orderId);
    }

    @RequestMapping(value = "/show/{itemId}", method = RequestMethod.GET)
    public ItemVO showItem(@PathVariable final Long itemId) {

        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));
        return itemService.showItem(itemId);
    }

    @RequestMapping(value = "/destroy/{itemId}", method = RequestMethod.DELETE)
    public void destroyItem(@PathVariable final Long itemId) {

        ValidationUtils.validateParam(itemId, String.format("Error input value itemId=[%s]", itemId));
        itemService.destroyItem(itemId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody ItemVO createItem(@RequestBody final ItemVO itemVO) {

        ValidationUtils.validateParam(itemVO.getOrderId(),
                String.format("Error input value orderId=[%s]", itemVO.getOrderId()));

        return itemService.createItem(itemVO);
    }

}