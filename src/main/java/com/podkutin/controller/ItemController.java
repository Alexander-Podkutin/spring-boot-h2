package com.podkutin.controller;

import com.podkutin.services.ItemService;
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

    @RequestMapping(path = "/orders/{orderId}", method = RequestMethod.GET)
    public List<ItemVO> listItemsByOrderId(@PathVariable final Long orderId) {
        return itemService.listItemsByOrderId(orderId);
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
    public ItemVO getItem(@PathVariable final Long itemId) {
        return itemService.getItem(itemId);
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable final Long itemId) {
        itemService.deleteItem(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ItemVO createItem(@RequestBody final ItemVO itemVO) {
        return itemService.createItem(itemVO);
    }

}