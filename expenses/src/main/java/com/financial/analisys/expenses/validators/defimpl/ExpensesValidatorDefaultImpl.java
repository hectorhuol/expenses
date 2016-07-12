package com.financial.analisys.expenses.validators.defimpl;

import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.validators.ExpensesValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class ExpensesValidatorDefaultImpl implements ExpensesValidator {

	private ValidationResult validationResult = new ValidationResult();

	public ValidationResult validate(Expense expense,
			ValidationType validationType) {

		validationResult.setValid(true);

		switch (validationType) {
		case CREATE:
			if (isExpenseNull(expense)) {
				setInvalidExpenseReason("Expense should not be null");
			}
			break;
		case READ:
			if (isExpenseIdNullOrEmpty(expense)) {
				setInvalidExpenseReason("Expense Id should not be null or empty");
			}
			break;
		case UPDATE:
			if (isExpenseIdNullOrEmpty(expense)) {
				setInvalidExpenseReason("Expense Id should not be null or empty");
			}
			break;
		case DELETE:
			if (isExpenseIdNullOrEmpty(expense)) {
				setInvalidExpenseReason("Expense Id should not be null or empty");
			}
			break;
		default:
			setInvalidExpenseReason("The validation type is not valid or is not configured");
			break;
		}

		return validationResult;
	}

	private void setInvalidExpenseReason(String message) {
		validationResult.setValid(false);
		validationResult.setReason(message);
	}

	private boolean isExpenseIdNullOrEmpty(Expense expense) {
		return expense.getExpenseId() == null
				|| expense.getExpenseId().equals("");
	}

	private boolean isExpenseNull(Expense expense) {
		return expense == null;
	}

}
