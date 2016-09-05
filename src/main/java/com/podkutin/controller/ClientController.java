package com.podkutin.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.podkutin.entities.ClientDO;
import com.podkutin.exception.ClientNotFoundException;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.utils.mapping.ClientMappingFunction;
import com.podkutin.view.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 8/7/16.
 */

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/show/{clientId}", method = RequestMethod.GET)
    public ClientVO showClient(@PathVariable final Long clientId) {
        validateShowClient(clientId);

        final ClientDO clientDO = clientRepository.findOne(clientId);
        if (clientDO == null) {
            throw new ClientNotFoundException(String.format("ClientDO with id=[%s], not found", clientId));
        }

        final ClientVO clientVO = new ClientMappingFunction().apply(clientDO);
        return clientVO;
    }

    @RequestMapping("/all")
    public List<ClientVO> getAllClients() {
        final List<ClientDO> clientListDO = ImmutableList.copyOf(clientRepository.findAll());
        final ClientMappingFunction clientMappingFunction = new ClientMappingFunction();
        return clientListDO.stream().map(new ClientMappingFunction()).collect(Collectors.<ClientVO>toList());
    }

    private static void validateShowClient(final Long clientId) {
        try {
            Preconditions.checkNotNull(clientId);
        } catch (NullPointerException ex) {
            throw new ClientNotFoundException("ClientDO not found, because you not set id of client.");
        }
    }

}
