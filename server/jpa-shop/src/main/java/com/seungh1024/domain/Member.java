package com.seungh1024.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;
    private String name;

    private String city;

    private String street;

    private String zipCode;

    public Member(){};

    public Member(Long id, String name, String city, String street, String zipCode){
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode =zipCode;
    }
}
