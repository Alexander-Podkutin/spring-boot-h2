package com.podkutin.services;

import com.podkutin.views.ItemVO;

import java.util.List;

/**
 * Created by apodkutin on 6/3/17.
 */
public interface ItemService {

    ItemVO createItem(final ItemVO itemVO);

    ItemVO getItem(final Long itemId);

    void deleteItem(final Long itemId);

    List<ItemVO> listItemsByOrderId(final Long orderId);
}
