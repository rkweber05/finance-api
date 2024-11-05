package com.api.finance.controllers;

import com.api.finance.entities.Budget;
import com.api.finance.entities.Customer;
import com.api.finance.repositories.BudgetRepository;
import com.api.finance.services.BudgetService;
import com.api.finance.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("budgets")
@AllArgsConstructor
@CrossOrigin("*")
public class BudgetController {
    private final BudgetService budgetService;

    @GetMapping
    public ResponseEntity<List<Budget>> findAllBudget() {
        return ResponseEntity.ok(budgetService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Budget> findBudgetById(@PathVariable Long id) {
        return new ResponseEntity<>(budgetService.findBudgetById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        return new ResponseEntity<>(budgetService.saveBudget(budget), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return new ResponseEntity<>(budgetService.updateBudget(id, budget), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Budget> deleteBudget(@PathVariable Long id) {
        return new ResponseEntity<>(budgetService.deleteBudget(id), HttpStatus.NO_CONTENT);
    }

}
