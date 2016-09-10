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

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "orderDO", fetch = FetchType.EAGER)
    private Set<ItemDO> itemsDO = new HashSet<>();

    protected OrderDO() {}

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
        return String.format("OrderDO[id=[%s], number=[%s], clientDO.id=[%s], items=[%s]]",
                this.id,
                this.number,
                this.clientDO != null ? this.clientDO.getId() : null,
                this.itemsDO != null ? this.itemsDO : null);
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
        int result = 0;

        if (this == null)
            return result;

        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.number == null ? 0 : this.number.hashCode());
        result = 31 * result + (this.clientDO == null ? 0 : this.clientDO.hashCode());

        return result;
    }
}
