package com.api.finance.controllers;

import com.api.finance.entities.Budget;
import com.api.finance.repositories.BudgetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("budgets")
@AllArgsConstructor
@CrossOrigin("*")
public class BudgetController {
    private final BudgetRepository budgetRepository;

    @GetMapping
    public ResponseEntity<List<Budget>> findAllBudgets() {
        return ResponseEntity.ok(budgetRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Budget> findBudgetById(@PathVariable Long id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        return budget.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        return ResponseEntity.ok(budgetRepository.save(budget));
    }

    @PutMapping("{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            budgetOptional.get().setBalance(budget.getBalance());
            budgetOptional.get().setCategories(budget.getCategories());

            return ResponseEntity.ok(budgetRepository.save(budgetOptional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Budget> deleteBudget(@PathVariable Long id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            budgetRepository.delete(budgetOptional.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
