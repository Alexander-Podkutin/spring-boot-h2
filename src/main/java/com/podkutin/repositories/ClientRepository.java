package com.podkutin.repositories;

import com.podkutin.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apodkutin on 9/2/2016.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

}
