package core.java.enums;

import org.junit.Test;

import core.java.enums.model.CardSuitEnum;

public class ReadEnumPractice {

	/**
	 * Very poor implementation - not preferable 
	 * Using Enum.valueOf is great when you know the input is valid. However, if you pass in an invalid name, 
	 * an exception will be thrown. In some cases, this is fine. Oftentimes. we would prefer to just ignore it and return null.
	 */
	@Test
	public void enumValueOf() {
		System.out.println(CardSuitEnum.valueOf("SPADE"));
		try {
			System.out.println(CardSuitEnum.valueOf("Spade"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find by iteration - better but not preferable
	 */
	@Test
	public void enumIteration() {
		String name = "Diamond";
		for (CardSuitEnum cardSuitEnum : CardSuitEnum.values()) {
			if (name.equals(cardSuitEnum.getCardName())) {
				System.out.println(cardSuitEnum);
			}
		}
	}

	/**
	 * Best implementation - using static HashMap
	 * Steps: 
	 * 1. Create static HashMap in Enum
	 * 2. write static block and initialize HashMap
	 * 3. write a static method lookupName(String name) and return the Enum object using name
	 */
	@Test
	public void lookupMap() {
		String name = "Heart";
		CardSuitEnum cardSuitEnum = CardSuitEnum.lookupByName(name);
		System.out.println("cardSuitEnum: " + cardSuitEnum);
	}
}