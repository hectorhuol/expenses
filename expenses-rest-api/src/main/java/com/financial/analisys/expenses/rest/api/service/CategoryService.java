package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.domain.Category;

public interface CategoryService {

	public Category createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

	public Category getCategory(Category category);

	public List<Category> getAllCategories();

}
