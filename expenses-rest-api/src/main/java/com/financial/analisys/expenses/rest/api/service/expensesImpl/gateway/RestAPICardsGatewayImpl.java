package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.domain.Card;
import com.financial.analisys.expenses.exceptions.CardException;
import com.financial.analisys.expenses.gateways.CardsGateway;
import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.repository.CardRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICardsGatewayImpl implements CardsGateway {

	private CardRepository cardRepository;

	public RestAPICardsGatewayImpl(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@Override
	public Card createCard(Card card) {
		try {
			CardBO cardBO = cardRepository.save(BOUtils.transformObject(card,
					CardBO.class));
			card.setCardId(cardBO.getCardId());
			return card;
		} catch (Exception e) {
			throw new CardException(e);
		}
	}

	@Override
	public void updateCard(Card card) {
		try {
			cardRepository.save(BOUtils.transformObject(card, CardBO.class));
		} catch (Exception e) {
			throw new CardException(e);
		}
	}
	
	@Override
	public void deleteCard(Card card) {
		try {
			cardRepository.delete(BOUtils.transformObject(card, CardBO.class));
		} catch (Exception e) {
			throw new CardException(e);
		}
	}
	
	@Override
	public Card getCard(Card card) {
		try {
			CardBO cardBO = cardRepository.findOne(card.getCardId());
			return BOUtils.transformObject(cardBO, Card.class);
		} catch (Exception e) {
			throw new CardException(e);
		}

	}
	
	@Override
	public List<Card> getAllCards() {
		try {
			List<CardBO> list = cardRepository.findAll();
			return BOUtils.transformObjectList(list, Card.class);
		} catch (Exception e) {
			throw new CardException(e);
		}
	}
}