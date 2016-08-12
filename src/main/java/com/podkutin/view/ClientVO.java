package com.podkutin.view;

import java.util.List;

/**
 * Created by apodkutin on 8/7/16.
 */
public class ClientVO {

    private long id;

    private String login;

    private String firstName;

    private String lastName;

    private List<OrderVO> orders;

    public ClientVO(long id, String login, String firstName, String lastName, List<OrderVO> orders) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OrderVO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderVO> orders) {
        this.orders = orders;
    }
}
