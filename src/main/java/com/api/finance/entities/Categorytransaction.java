package com.api.finance.entities;

import com.api.finance.enums.InputType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categoryTransaction_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorytransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryTransactionId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private InputType type;

    @ManyToOne
    @JoinColumn(name = "fk_category", nullable = false)
    private Category category;
}
