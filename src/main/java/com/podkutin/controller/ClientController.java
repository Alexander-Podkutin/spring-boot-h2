package com.podkutin.controller;

import com.podkutin.repositories.ClientRepository;
import com.podkutin.services.ClientService;
import com.podkutin.views.ClientVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by apodkutin on 8/7/16.
 */

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping
    public List<ClientVO> listClients() {
        return clientService.listClients();
    }

    @RequestMapping(path = "/{clientId}", method = RequestMethod.GET)
    public ClientVO getClient(@PathVariable final Long clientId) {
        return clientService.getClient(clientId);
    }

}
