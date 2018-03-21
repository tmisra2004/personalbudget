package com.tavishmisra.personalbudget.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private double balance = 0.0;

    @ManyToMany(mappedBy = "items")
    private List<Budget> budgets;

    public Item() {
    }

    public Item(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }
}
