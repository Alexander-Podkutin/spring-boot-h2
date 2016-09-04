package com.podkutin.repositories;

import com.podkutin.entities.OrderDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apodkutin on 9/4/2016.
 */
public interface OrderRepository extends CrudRepository<OrderDO, Long> {
}
