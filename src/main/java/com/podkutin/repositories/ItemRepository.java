package com.podkutin.repositories;

import com.podkutin.entities.ItemDO;
import com.podkutin.entities.OrderDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apodkutin on 9/5/2016.
 */
public interface ItemRepository extends CrudRepository<ItemDO, Long> {
    List<ItemDO> findByOrderDO(OrderDO orderDO);
}
