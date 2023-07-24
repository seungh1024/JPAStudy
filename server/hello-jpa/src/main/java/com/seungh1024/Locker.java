package com.seungh1024;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "locker_id")
    private Long id;
    private String name;

//    @OneToOne(mappedBy = "locker")
//    private Member member;

    public Locker(){}
}
