package com.podkutin.repositories;

import com.podkutin.entities.ItemDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apodkutin on 9/5/2016.
 */
public interface ItemRepository extends CrudRepository<ItemDO, Long> {
}
