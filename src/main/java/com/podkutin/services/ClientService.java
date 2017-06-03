package com.podkutin.services;

import com.podkutin.views.ClientVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apodkutin on 6/3/17.
 */

public interface ClientService {

    ClientVO showClient(Long clientId);

    List<ClientVO> getAllClients();

}
