package com.financial.analisys.expenses.gateways;

import java.util.List;

import com.financial.analisys.expenses.domain.Category;

public interface CategoriesGateway {

	public Category createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

	public Category getCategory(Category category);

	public List<Category> getAllCategories();

}
