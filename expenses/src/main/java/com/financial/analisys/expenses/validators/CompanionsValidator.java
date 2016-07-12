package com.financial.analisys.expenses.validators;

import com.financial.analisys.expenses.domain.Companion;

public interface CompanionsValidator {

	public ValidationResult validate(Companion companion,
			ValidationType validationType);

}
