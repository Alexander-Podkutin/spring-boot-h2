package com.podkutin.views;

import java.util.Set;

/**
 * Created by apodkutin on 8/12/16.
 */
public class OrderVO {

    private Long id;

    private String number;

    private Long clientId;

    private Set<ItemVO> items;

    public OrderVO(Long id, String number, Long clientId, Set<ItemVO> items) {
        this.id = id;
        this.number = number;
        this.clientId = clientId;
        this.items = items;
    }

    public OrderVO() {
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getClientId() {
        return clientId;
    }

    public Set<ItemVO> getItems() {
        return items;
    }
}
