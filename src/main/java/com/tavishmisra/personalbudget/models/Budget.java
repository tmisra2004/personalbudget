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
    private String month;

    @NotNull
    private String year;

    @NotNull
    private double total = 0.0;

    @ManyToMany
    private List<Item> items;

    public Budget(String month, String year) {
        this.month = month;
        this.year = year;
    }

    public Budget() {}

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Item> getItems() {
        return items;
    }


    public void addItem(Item item) {
        items.add(item);
    }
}
