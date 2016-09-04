package com.podkutin.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Order> orders;

    protected Client() {}

    public Client(String login, String firstName, String lastName, List<Order> orders) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("Client[id=[%s], login=[%s], firstName=[%s], lastName=[%s], orders=[%s]]",
                this.id, this.login, this.firstName, this.lastName, "empty");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(login, client.login) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, firstName, lastName);
    }
}
