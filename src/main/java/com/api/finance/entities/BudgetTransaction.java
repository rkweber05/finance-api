package com.api.finance.entities;

import com.api.finance.enums.InputType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "budgetTransaction_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetTransactionId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private InputType type;

    @ManyToOne
    @JoinColumn(name = "fk_budget", nullable = false)
    private Budget budget;
}
