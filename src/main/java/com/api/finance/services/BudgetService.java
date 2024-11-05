package com.api.finance.services;

import com.api.finance.entities.Budget;
import com.api.finance.entities.Customer;
import com.api.finance.repositories.BudgetRepository;
import com.api.finance.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Budget findBudgetById(Long id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        return budget.orElse(null);
    }

    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Long id, Budget budget) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            budgetOptional.get().setBalance(budget.getBalance());
            budgetOptional.get().setCategories(budget.getCategories());
            budgetOptional.get().setBudgetTransactions(budget.getBudgetTransactions());
            budgetOptional.get().setCustomer(budget.getCustomer());

            return budgetOptional.get();
        }

        return null;
    }

    public Budget deleteBudget(Long id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            budgetRepository.delete(budgetOptional.get());
            return budgetOptional.get();
        }

        return null;
    }
}
