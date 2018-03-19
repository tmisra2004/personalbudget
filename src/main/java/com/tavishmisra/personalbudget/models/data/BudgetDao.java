package com.tavishmisra.personalbudget.models.data;

import com.tavishmisra.personalbudget.models.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BudgetDao extends CrudRepository<Budget, Integer> {
}
