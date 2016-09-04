package com.podkutin.entities;

import com.podkutin.view.ItemVO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<Item> items;

    protected Order() {}

    public Order(String number, Client client, Set<Item> items) {
        this.number = number;
        this.client = client;
        this.items = items;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("Order[id=[%s], number=[%s], client=[%s], items=[%s]]",
                this.id, this.number, this.client, this.items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(number, order.number) &&
                Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, client);
    }
}
