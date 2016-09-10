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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<ItemVO> getItems() {
        return items;
    }

    public void setItems(Set<ItemVO> items) {
        this.items = items;
    }


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
