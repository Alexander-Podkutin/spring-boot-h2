package com.podkutin.views;

/**
 * Created by apodkutin on 8/12/16.
 */
public class ItemVO {

    private Long id;

    private String name;

    private Long orderId;

    private Integer quantity;

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

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getOrderId() {
        return orderId;
    }
}
