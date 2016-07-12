package com.financial.analisys.expenses.gateways;

import java.util.List;

import com.financial.analisys.expenses.domain.Card;

public interface CardsGateway {

	public Card createCard(Card card);

	public void updateCard(Card card);

	public void deleteCard(Card card);

	public Card getCard(Card card);

	public List<Card> getAllCards();

}
