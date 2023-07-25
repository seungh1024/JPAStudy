package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Delivery(Order order, Address address, DeliveryStatus status){
        this.order = order;
        this.address = address;
        this.status = status;
    }
}
