package com.seungh1024;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Address address;

    public AddressEntity(String city, String street, String zipcode){
        this.address = new Address(city,street,zipcode);
    }

    public AddressEntity() {

    }

}
