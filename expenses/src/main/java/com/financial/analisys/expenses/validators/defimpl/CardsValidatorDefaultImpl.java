package com.financial.analisys.expenses.validators.defimpl;

import com.financial.analisys.expenses.domain.Card;
import com.financial.analisys.expenses.validators.CardsValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class CardsValidatorDefaultImpl implements CardsValidator {

	private ValidationResult validationResult = new ValidationResult();

	public ValidationResult validate(Card card, ValidationType validationType) {

		validationResult.setValid(true);

		switch (validationType) {
		case CREATE:
			if (isCardNull(card)) {
				setInvalidCardReason("Card should not be null");
			}
			break;
		case READ:
			if (isCardIdNullOrEmpty(card)) {
				setInvalidCardReason("Card Id should not be null or empty");
			}
			break;
		case UPDATE:
			if (isCardIdNullOrEmpty(card)) {
				setInvalidCardReason("Card Id should not be null or empty");
			}
			break;
		case DELETE:
			if (isCardIdNullOrEmpty(card)) {
				setInvalidCardReason("Card Id should not be null or empty");
			}
			break;
		default:
			setInvalidCardReason("The validation type is not valid or is not configured");
			break;
		}

		return validationResult;
	}

	private void setInvalidCardReason(String message) {
		validationResult.setValid(false);
		validationResult.setReason(message);
	}

	private boolean isCardIdNullOrEmpty(Card card) {
		return card.getCardId() == null || card.getCardId().equals("");
	}

	private boolean isCardNull(Card card) {
		return card == null;
	}

}
