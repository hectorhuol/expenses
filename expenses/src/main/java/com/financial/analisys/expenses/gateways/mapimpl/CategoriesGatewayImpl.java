package com.financial.analisys.expenses.gateways.mapimpl;

import java.util.ArrayList;
import java.util.List;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.gateways.CategoriesGateway;

public class CategoriesGatewayImpl implements CategoriesGateway {

	public Category createCategory(Category category) {
		if (category.getCategoryId() == null)
			category.setCategoryId(getNextCategoryId());
		Repository.categoriesRepository.put(category.getCategoryId(), category);
		Repository.saveCategoriesRepository();
		return category;
	}

	private String getNextCategoryId() {
		List<Category> values = getValuesList();
		if(values==null || values.isEmpty())
			return "1";
		Integer nextId = Integer.valueOf(values.get(values.size() - 1)
				.getCategoryId()) + 1;
		return nextId.toString();
	}

	public void updateCategory(Category category) {
		Repository.categoriesRepository.replace(category.getCategoryId(),
				category);
		Repository.saveCategoriesRepository();
	}

	public void deleteCategory(Category category) {
		Repository.categoriesRepository.remove(category.getCategoryId());
		Repository.saveCategoriesRepository();
	}

	public Category getCategory(Category category) {
		return Repository.categoriesRepository.get(category.getCategoryId());

	}

	public List<Category> getAllCategories() {
		List<Category> values = getValuesList();
		return values;
	}

	private List<Category> getValuesList() {
		List<Category> values = new ArrayList<Category>(
				Repository.categoriesRepository.values());
		return values;
	}

}