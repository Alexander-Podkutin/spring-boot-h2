package com.podkutin.utils.mapping;

import com.podkutin.entities.ClientDO;
import com.podkutin.views.ClientVO;
import com.podkutin.views.OrderVO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 9/4/2016.
 */
public class ClientMappingFunction implements Function<ClientDO, ClientVO> {
    @Override
    public ClientVO apply(final ClientDO clientDO) {
        if (clientDO == null) {
            return null;
        }
        final List<OrderVO> ordersVO = clientDO.getOrdersDO() != null ?
                clientDO.getOrdersDO().stream().map(
                        new OrderMappingFunction()).collect(Collectors.<OrderVO>toList()) :
                null;

        final ClientVO clientVO = new ClientVO(clientDO.getId(), clientDO.getLogin(),
                clientDO.getFirstName(), clientDO.getLastName(), ordersVO);

        return clientVO;
    }
}
