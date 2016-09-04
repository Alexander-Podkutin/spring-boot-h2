package com.podkutin.utils.mapping;

import com.podkutin.entities.ClientDO;
import com.podkutin.view.ClientVO;
import com.podkutin.view.OrderVO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 9/4/2016.
 */
public class ClientMappingFunction implements Function<ClientDO, ClientVO> {
    @Override
    public ClientVO apply(ClientDO client) {
        if (client == null) {
            return null;
        }
        List<OrderVO> ordersVO = client.getOrdersDO() != null ?
                client.getOrdersDO().stream().map(
                        new OrderMappingFunction()).collect(Collectors.<OrderVO>toList()) :
                null;

        ClientVO clientVO = new ClientVO(client.getId(), client.getLogin(),
                client.getFirstName(), client.getLastName(), ordersVO);

        return clientVO;
    }
}
