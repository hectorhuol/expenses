package com.financial.analisys.expenses.managers;

import java.util.List;

import com.financial.analisys.expenses.domain.Card;
import com.financial.analisys.expenses.exceptions.CardException;
import com.financial.analisys.expenses.exceptions.TechnicalException;
import com.financial.analisys.expenses.gateways.CardsGateway;
import com.financial.analisys.expenses.validators.CardsValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class CardsManager {

	private CardsGateway cardsGateway;
	private CardsValidator cardsValidator;

	private CardsManager() {
	}

	private CardsManager(CardsGateway cardsGateway,
			CardsValidator cardsValidator) {
		this.cardsGateway = cardsGateway;
		this.cardsValidator = cardsValidator;
	}

	public static CardsManager getNewCardsManager(CardsGateway cardsGateway,
			CardsValidator cardsValidator) {
		return new CardsManager(cardsGateway, cardsValidator);
	}

	public Card createCard(Card card) {
		try {
			ValidationResult result = cardsValidator.validate(card,
					ValidationType.CREATE);
			if (result.isValid())
				return cardsGateway.createCard(card);
			throw new CardException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public void updateCard(Card card) {
		try {
			ValidationResult result = cardsValidator.validate(card,
					ValidationType.UPDATE);
			if (result.isValid())
				cardsGateway.updateCard(card);
			else
				throw new CardException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public void deleteCard(Card card) {
		try {
			ValidationResult result = cardsValidator.validate(card,
					ValidationType.DELETE);
			if (result.isValid())
				cardsGateway.deleteCard(card);
			else
				throw new CardException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public Card getCard(Card card) {
		try {
			ValidationResult result = cardsValidator.validate(card,
					ValidationType.READ);
			if (result.isValid())
				return cardsGateway.getCard(card);
			throw new TechnicalException(result.getReason());
		} catch (Exception e) {
			throw new CardException(e);
		}
	}

	public List<Card> getAllCards() {
		return cardsGateway.getAllCards();
	}
}