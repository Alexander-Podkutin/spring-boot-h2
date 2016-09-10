package com.podkutin.views;

/**
 * Created by apodkutin on 8/12/16.
 */
public class ItemVO {

    private Long id;

    private String name;

    private Long orderId;

    private int quantity;

    public ItemVO(Long id, String name, Long orderId, int quantity) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public ItemVO() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
