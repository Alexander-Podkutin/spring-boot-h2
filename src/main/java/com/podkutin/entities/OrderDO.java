package com.podkutin.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class OrderDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "clientDO", nullable = false)
    private ClientDO clientDO;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderDO")
    private Set<ItemDO> itemsDO = new HashSet<>();

    protected OrderDO() {}

    public OrderDO(String number) {
        this.number = number;
    }

    public OrderDO(String number, ClientDO clientDO) {
        this.number = number;
        this.clientDO = clientDO;
    }

    public OrderDO(String number, ClientDO clientDO, Set<ItemDO> itemsDO) {
        this.number = number;
        this.clientDO = clientDO;
        this.itemsDO = itemsDO;
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

    public ClientDO getClientDO() {
        return clientDO;
    }

    public void setClientDO(ClientDO clientDO) {
        this.clientDO = clientDO;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<ItemDO> getItemsDO() {
        return itemsDO;
    }

    public void setItemsDO(Set<ItemDO> itemsDO) {
        this.itemsDO = itemsDO;
    }

    @Override
    public String toString() {
        return String.format("OrderDO[id=[%s], number=[%s], clientDO=[%s], items=[%s]]",
                this.id, this.number, this.clientDO, this.itemsDO != null ? this.itemsDO.size() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDO order = (OrderDO) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(number, order.number) &&
                Objects.equals(clientDO, order.clientDO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, clientDO);
    }
}
