package com.financial.analisys.expenses.validators;

import com.financial.analisys.expenses.domain.Expense;

public interface ExpensesValidator {

	public ValidationResult validate(Expense expense,
			ValidationType validationType);

}
