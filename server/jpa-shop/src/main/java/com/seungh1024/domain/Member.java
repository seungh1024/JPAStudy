package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;
    private String name;

    private String city;

    private String street;

    private String zipCode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member(){};

    public Member(String name, String city, String street, String zipCode){
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode =zipCode;
    }
}
