package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.exceptions.CategoryException;
import com.financial.analisys.expenses.gateways.CategoriesGateway;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.repository.CategoryRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICategoriesGatewayImpl implements CategoriesGateway {

	private CategoryRepository categoryRepository;

	public RestAPICategoriesGatewayImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category createCategory(Category category) {
		try {
			CategoryBO categoryBO = categoryRepository.save(BOUtils
					.transformObject(category, CategoryBO.class));
			category.setCategoryId(categoryBO.getCategoryId());
			return category;
		} catch (Exception e) {
			throw new CategoryException(e);
		}
	}

	@Override
	public void updateCategory(Category category) {
		try {
			categoryRepository.save(BOUtils.transformObject(category,
					CategoryBO.class));
		} catch (Exception e) {
			throw new CategoryException(e);
		}
	}

	@Override
	public void deleteCategory(Category category) {
		try {
			categoryRepository.delete(BOUtils.transformObject(category,
					CategoryBO.class));
		} catch (Exception e) {
			throw new CategoryException(e);
		}
	}
	
	@Override
	public Category getCategory(Category category) {
		try {
			CategoryBO categoryBO = categoryRepository.findOne(category
					.getCategoryId());
			return BOUtils.transformObject(categoryBO, Category.class);
		} catch (Exception e) {
			throw new CategoryException(e);
		}

	}

	@Override
	public List<Category> getAllCategories() {
		try {
			List<CategoryBO> list = categoryRepository.findAll();
			return BOUtils.transformObjectList(list, Category.class);
		} catch (Exception e) {
			throw new CategoryException(e);
		}
	}
}