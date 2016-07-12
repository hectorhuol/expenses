package com.financial.analisys.expenses.validators;

import com.financial.analisys.expenses.domain.Card;

public interface CardsValidator {

	public ValidationResult validate(Card card, ValidationType validationType);

}
