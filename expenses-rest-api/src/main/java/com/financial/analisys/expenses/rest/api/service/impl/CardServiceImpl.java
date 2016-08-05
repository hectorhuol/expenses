package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.domain.Card;
import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.service.CardService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public CardBO createCard(CardBO cardBO) {
		try {
			Card card = expensesAPIFacade.getCardsManager().createCard(
					BOUtils.transformObject(cardBO, Card.class));
			cardBO.setCardId(card.getCardId());
			return cardBO;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCard(CardBO cardBO) {
		try {
			expensesAPIFacade.getCardsManager().updateCard(
					BOUtils.transformObject(cardBO, Card.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCard(String id) {
		try {
			Card card = new Card();
			card.setCardId(id);
			expensesAPIFacade.getCardsManager().deleteCard(card);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public CardBO getCard(String id) {
		try {
			Card card = new Card();
			card.setCardId(id);
			card = expensesAPIFacade.getCardsManager().getCard(card);
			return BOUtils.transformObject(card, CardBO.class);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CardBO> getAllCards() {
		try {
			List<Card> cards = expensesAPIFacade.getCardsManager().getAllCards();
			return BOUtils.transformObjectList(cards, CardBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
