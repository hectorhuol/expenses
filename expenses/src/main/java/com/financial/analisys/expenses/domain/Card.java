package com.financial.analisys.expenses.domain;

public class Card {

	private String cardId;
	private String name;
	private CardType type;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card card = (Card) obj;
			return card.getCardId().equals(this.getCardId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getCardId()) * 17;
	}
}