package com.financial.analisys.expenses.validators;

import com.financial.analisys.expenses.domain.User;

public interface UsersValidator {

	public ValidationResult validate(User user, ValidationType validationType);

}
