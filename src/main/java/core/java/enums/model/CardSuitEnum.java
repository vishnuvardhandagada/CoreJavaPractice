package core.java.enums.model;

import java.util.HashMap;
import java.util.Map;

enum CardColorEnum {
	RED, BLACK;
}

public enum CardSuitEnum {
	SPADE("Spade", "S", CardColorEnum.RED), HEART("Heart", "H", CardColorEnum.BLACK), DIAMOND("Diamond", "D",
			CardColorEnum.RED), CLUB("Club", "C", CardColorEnum.BLACK);

	private String cardName;
	private String cardSymbol;
	private CardColorEnum cardColor;
	private static final Map<String, CardSuitEnum> lookupMap = new HashMap<>(CardSuitEnum.values().length);

	static {
		for (CardSuitEnum cardSuitEnum : CardSuitEnum.values()) {
			lookupMap.put(cardSuitEnum.getCardName(), cardSuitEnum);
		}
	}

	public static CardSuitEnum lookupByName(String name) {
		return lookupMap.get(name);
	}

	private CardSuitEnum(String cardName, String cardSymbol, CardColorEnum cardColor) {
		this.cardName = cardName;
		this.cardSymbol = cardSymbol;
		this.cardColor = cardColor;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardSymbol() {
		return cardSymbol;
	}

	public void setCardSymbol(String cardSymbol) {
		this.cardSymbol = cardSymbol;
	}

	public CardColorEnum getCardColor() {
		return cardColor;
	}

	public void setCardColor(CardColorEnum cardColor) {
		this.cardColor = cardColor;
	}
}