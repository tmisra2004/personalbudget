package com.tavishmisra.personalbudget.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Budget {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "items")
    private List<Item> items;

    public Budget(String name) {
        this.name = name;
    }



}
