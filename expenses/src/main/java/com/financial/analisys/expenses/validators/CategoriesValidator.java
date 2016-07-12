package com.financial.analisys.expenses.validators;

import com.financial.analisys.expenses.domain.Category;

public interface CategoriesValidator {

	public ValidationResult validate(Category category,
			ValidationType validationType);

}
