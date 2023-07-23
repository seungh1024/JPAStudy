package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer orderPrice;

    private Integer count;

    public OrderItem(){}

    public OrderItem( Integer orderPrice, Integer count) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public void changeOrder(Order order){
        this.order = order;
        order.getOrderItems().add(this);
    }

    public void changeItem(Item item){
        this.item = item;
    }
}
