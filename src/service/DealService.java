package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Card;
import model.Hand;

//allocates cards to hand
public class DealService {

	List<Card> shuffledCards;
	List<Card> handSetOfCards;

	Hand handInPoker;

	// get the shuffled cards
	public DealService(List<Card> shuffledCards, Hand handInPoker, int singleHandOf_5_Cards) {
		this.shuffledCards = shuffledCards;
		this.handInPoker = handInPoker;
		this.handSetOfCards = new ArrayList<Card>(singleHandOf_5_Cards);// to be delegated to object factory creation
																		// function;
		allocatehandSetOfCardseCards();
	}

	// alocate 5 cards sequentially to hand
	public void allocatehandSetOfCardseCards() {
		Iterator<Card> iter = shuffledCards.iterator();
		int cardCount = 0;
		while (iter.hasNext()) {
			cardCount++;
			handSetOfCards.add(iter.next());
			if (cardCount == 5) {
				break;
			}
		}
		handInPoker.setHandSetOfCards(handSetOfCards);
	}

}
