package com.podkutin.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class ItemDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "orderDO", nullable = false)
    private OrderDO orderDO;

    private Integer quantity;

    protected ItemDO() {}

    public ItemDO(String name, OrderDO orderDO, Integer quantity) {
        this.name = name;
        this.orderDO = orderDO;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderDO getOrderDO() {
        return orderDO;
    }

    public void setOrderDO(OrderDO orderDO) {
        this.orderDO = orderDO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ItemDO[id=[%s], name=[%s], order.id=[%s] quantity=[%s]]",
                this.id,
                this.name,
                this.orderDO != null ? this.orderDO.getId() : null,
                this.quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDO item = (ItemDO) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(orderDO, item.orderDO) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        int result = 0;

        if (this == null)
            return result;

        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 31 * result + (this.orderDO == null ? 0 : this.orderDO.hashCode());
        result = 31 * result + (this.quantity == null ? 0 : this.quantity.hashCode());

        return result;
    }
}
