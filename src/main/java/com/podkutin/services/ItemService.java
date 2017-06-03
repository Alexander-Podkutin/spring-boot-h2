package com.podkutin.services;

import com.podkutin.views.ItemVO;

import java.util.List;

/**
 * Created by apodkutin on 6/3/17.
 */
public interface ItemService {

    ItemVO createItem(final ItemVO itemVO);

    ItemVO showItem(final Long itemId);

    void destroyItem(final Long itemId);

    List<ItemVO> getItemsByOrderId(final Long orderId);
}
