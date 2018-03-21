package com.tavishmisra.personalbudget.controller;

import com.tavishmisra.personalbudget.models.Budget;
import com.tavishmisra.personalbudget.models.Item;
import com.tavishmisra.personalbudget.models.data.BudgetDao;
import com.tavishmisra.personalbudget.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;
import java.text.DecimalFormat;

@Controller
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    private BudgetDao budgetDao;

    @Autowired
    private ItemDao itemDao;

@RequestMapping(value = "")
public String index(Model model) {
    model.addAttribute("budgets", budgetDao.findAll());
    model.addAttribute("title", "Budgets");
    return "budget/index";

    }

@RequestMapping(value = "add", method = RequestMethod.GET)
public String addBudget(Model model) {
    model.addAttribute("title", "Create A New Budget");
    model.addAttribute("budget", new Budget());
    return "budget/add";
}

@RequestMapping(value = "add", method = RequestMethod.POST)
public String addBudget(Model model, @ModelAttribute @Valid Budget budget, Errors errors) {

    if (errors.hasErrors()) {
        return "budget/add";
    }
    budgetDao.save(budget);
    return "redirect:view/" + budget.getId();

    }

@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
public String viewBudget(Model model, @PathVariable int id) {
    Budget budget = budgetDao.findOne(id);
    DecimalFormat df2 = new DecimalFormat(".##");
    model.addAttribute("title", budget.getMonth() + " " + budget.getYear() + " Budget");
    model.addAttribute("budget", budget);
    model.addAttribute("total", df2.format(budget.getTotal()));
    model.addAttribute("budgetid", budget.getId());
    return "budget/view";
    }

@RequestMapping(value = "additem/{id}", method = RequestMethod.GET)
public String addBudgetItem(Model model, @PathVariable int id) {
    Budget budget = budgetDao.findOne(id);
    model.addAttribute("title", "Add Budget Item to " + budget.getMonth() + " " + budget.getYear() + " Budget");
    model.addAttribute("item", new Item());
    return "budget/additem";
}

@RequestMapping(value = "additem", method = RequestMethod.POST)
public String addBudgetItem(Model model, @ModelAttribute @Valid Item item, Errors errors) {
    if (errors.hasErrors()) {
        return "budget/additem";
    }
    itemDao.save(item);
    return "redirect";
}


}
