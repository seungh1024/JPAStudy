package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(LocalDateTime orderDate, OrderStatus status) {
        this.orderDate = orderDate;
        this.status = status;
    }

    public void changeMember(Member member){
        this.member = member;
    }

    public void changeOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.changeOrder(this );
    }
}
