package com.gmail.grind3x.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;


}
