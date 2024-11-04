package com.api.finance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "budget_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetId;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "fk_customer", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "budget")
    private List<Category> categories;

    @OneToMany(mappedBy = "budget")
    private List<BudgetTransaction> budgetTransactions;
}
