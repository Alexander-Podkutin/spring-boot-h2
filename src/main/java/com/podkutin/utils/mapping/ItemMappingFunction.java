package com.podkutin.utils.mapping;

import com.podkutin.entities.ItemDO;
import com.podkutin.views.ItemVO;

import java.util.function.Function;

/**
 * Created by apodkutin on 9/5/2016.
 */
public class ItemMappingFunction implements Function<ItemDO, ItemVO> {
    @Override
    public ItemVO apply(final ItemDO itemDO) {
        if (itemDO == null)
            return null;


        final ItemVO itemVO = new ItemVO(itemDO.getId(),
                itemDO.getName(),
                itemDO.getOrderDO() != null ? itemDO.getOrderDO().getId() : null,
                itemDO.getQuantity());
        return itemVO;
    }
}
