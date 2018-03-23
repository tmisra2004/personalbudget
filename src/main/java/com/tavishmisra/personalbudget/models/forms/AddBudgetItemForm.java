package com.tavishmisra.personalbudget.models.forms;

import com.tavishmisra.personalbudget.models.Budget;
import com.tavishmisra.personalbudget.models.Item;

import javax.validation.constraints.NotNull;

public class AddBudgetItemForm {


    private Budget budget;


    private Iterable<Item> items;

    @NotNull
    private int budgetId;

    @NotNull
    private int itemId;

    public AddBudgetItemForm() {
    }

    public AddBudgetItemForm(Budget budget, Iterable<Item> items) {
        this.budget = budget;
        this.items = items;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Iterable<Item> getItems() {
        return items;
    }

    public void setItems(Iterable<Item> items) {
        this.items = items;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


}