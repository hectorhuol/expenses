package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.service.CategoryService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public CategoryBO createCategory(CategoryBO categoryBO) {
		try {
			Category category = expensesAPIFacade
					.getCategoriesManager()
					.createCategory(
							BOUtils.transformObject(categoryBO, Category.class));
			categoryBO.setCategoryId(category.getCategoryId());
			return categoryBO;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCategory(CategoryBO categoryBO) {
		try {
			expensesAPIFacade.getCategoriesManager().updateCategory(
					BOUtils.transformObject(categoryBO, Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCategory(String id) {
		try {
			Category category = new Category();
			category.setCategoryId(id);
			expensesAPIFacade.getCategoriesManager().deleteCategory(category);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public CategoryBO getCategory(String id) {
		try {
			Category category = new Category();
			category.setCategoryId(id);
			category = expensesAPIFacade.getCategoriesManager().getCategory(
					category);
			return BOUtils.transformObject(category, CategoryBO.class);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CategoryBO> getAllCategories() {
		try {
			List<Category> categories = expensesAPIFacade.getCategoriesManager()
					.getAllCategories();
			return BOUtils.transformObjectList(categories, CategoryBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
