package com.podkutin.utils.mapping;

import com.podkutin.entities.Client;
import com.podkutin.view.ClientVO;

import java.util.function.Function;

/**
 * Created by apodkutin on 9/4/2016.
 */
public class ClientMappingFunction implements Function<Client, ClientVO> {
    @Override
    public ClientVO apply(Client client) {
        if (client == null) {
            return null;
        }
        ClientVO clientVO = new ClientVO(client.getId(), client.getLogin(),
                client.getFirstName(), client.getLastName(), null);

        return clientVO;
    }
}
