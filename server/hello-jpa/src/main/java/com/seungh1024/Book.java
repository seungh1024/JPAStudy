package com.seungh1024;

import javax.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private String isbn;
}
