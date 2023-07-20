package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    public Item() {
    }

    public Item(String name, Integer price, Integer stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
