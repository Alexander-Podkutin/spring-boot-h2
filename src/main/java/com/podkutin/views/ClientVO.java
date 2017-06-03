package com.podkutin.views;

import java.util.List;

/**
 * Created by apodkutin on 8/7/16.
 */
public class ClientVO {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private List<OrderVO> orders;

    public ClientVO(Long id, String login, String firstName, String lastName, List<OrderVO> orders) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public ClientVO() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<OrderVO> getOrders() {
        return orders;
    }
}
