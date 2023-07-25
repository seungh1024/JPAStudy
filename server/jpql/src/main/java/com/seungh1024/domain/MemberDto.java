package com.seungh1024.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String username;
    private int age;

    public MemberDto(String username, int age){
        this.username = username;
        this.age= age;
    }
}
