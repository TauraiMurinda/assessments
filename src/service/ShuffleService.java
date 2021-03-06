package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import model.Card;
import model.Deck;

public class ShuffleService {

	private Deck deck = null;;
	private Set<String> set = new HashSet<String>(52);
	private List<Card> shuffledCards = new ArrayList<>(52);

	private List<Card> cardsofDeck2;

	public ShuffleService(List<Card> cardsofDeck2) {
		this.cardsofDeck2 = cardsofDeck2;
	}

	public Deck getDeck() {
		return deck;
	}

	public List<Card> getShuffledCards() {

		Random random_01 = new Random();
		Random random_02 = new Random();
		int y = 50;

		while (shuffledCards.size() != cardsofDeck2.size()) {
			int r = random_01.nextInt(52);
			String str = String.valueOf(r);
			if (!set.contains(str)) {
				set.add(str);
				shuffledCards.add(cardsofDeck2.get(Integer.valueOf(str)));

			}
		}
		return shuffledCards;
	}
	
	
	public List<Card> getShuffledCards(int removeAllocated) {

		for(int x =0; x<removeAllocated;x++) {
			shuffledCards.remove(x);			
		}
		return shuffledCards;
	}

}
