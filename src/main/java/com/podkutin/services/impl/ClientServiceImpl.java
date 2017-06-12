package com.podkutin.services.impl;

import com.google.common.collect.ImmutableList;
import com.podkutin.entities.ClientDO;
import com.podkutin.exception.ClientNotFoundException;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.services.ClientService;
import com.podkutin.utils.ValidationUtils;
import com.podkutin.utils.mapping.ClientMappingFunction;
import com.podkutin.views.ClientVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 6/3/17.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientVO getClient(Long clientId) {

        ValidationUtils.validateParam(clientId, String.format("Error input value clientId=[%s]", clientId));
        final ClientDO clientDO = clientRepository.findOne(clientId);

        if (clientDO == null) {
            throw new ClientNotFoundException(String.format("ClientDO with id=[%s], not found", clientId));
        }

        return new ClientMappingFunction().apply(clientDO);
    }

    @Override
    public List<ClientVO> listClients() {
        final List<ClientDO> clientListDO = ImmutableList.copyOf(clientRepository.findAll());
        return clientListDO.stream().map(new ClientMappingFunction()).collect(Collectors.<ClientVO>toList());
    }
}
