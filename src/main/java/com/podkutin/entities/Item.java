package com.podkutin.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "order", nullable = false)
    private Order order;

    private Integer quantity;

    protected Item() {}

    public Item(String name, Order order, Integer quantity) {
        this.name = name;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Item[id=[%s], name=[%s], order=[%s] quantity=[%s]]",
                this.id, this.name, this.order, this.quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(order, item.order) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, order, quantity);
    }
}
