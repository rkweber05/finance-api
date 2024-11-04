package com.api.finance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer percentage;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "fk_budget", nullable = false)
    private Budget budget;

    @OneToMany(mappedBy = "category")
    private List<Categorytransaction> categorytransactions;
}
