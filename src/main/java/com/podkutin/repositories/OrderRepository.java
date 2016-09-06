package com.podkutin.repositories;

import com.podkutin.entities.ClientDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.views.OrderVO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apodkutin on 9/4/2016.
 */
public interface OrderRepository extends CrudRepository<OrderDO, Long> {
    List<OrderDO> findByClientDO(ClientDO clientDO);
}
