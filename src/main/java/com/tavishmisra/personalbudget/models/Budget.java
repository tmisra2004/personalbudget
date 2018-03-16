package com.tavishmisra.personalbudget.models;


import javax.persistence.*;

@Entity
@Table(name = "Budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "budget_id")
    private int id;

}
