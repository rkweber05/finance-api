package com.api.finance.services;

import com.api.finance.entities.Budget;
import com.api.finance.entities.Category;
import com.api.finance.repositories.BudgetRepository;
import com.api.finance.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryOptional.get().setName(category.getName());
            categoryOptional.get().setBalance(category.getBalance());
            categoryOptional.get().setPercentage(category.getPercentage());
            categoryOptional.get().setBudget(category.getBudget());
            categoryOptional.get().setCategorytransactions(category.getCategorytransactions());

            return categoryOptional.get();
        }

        return null;
    }

    public Category deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
            return categoryOptional.get();
        }

        return null;
    }
}
