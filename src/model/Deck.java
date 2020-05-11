package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utility.Ranks;
import utility.Suit;
import model.Hand;

public class Deck {

	private Card card;
	private static final int deckCardsTotalNumber = 52;
	private static final int suitSize = 4;
	private static final int ranksSize = 13;
	private static final Card[][] deck = new Card[deckCardsTotalNumber / suitSize][deckCardsTotalNumber / ranksSize];
	private List<Card> cards = new ArrayList<Card>();

	public final List<Card> getDeckOfCards() {

		for (Suit s_c_c : Suit.values()) {
			for (Ranks ranks : Ranks.values()) {

				this.card = this.deck[ranks.ordinal()][s_c_c.ordinal()] = new Card(ranks, s_c_c);
				cards.add(card);
			}
		}

		return cards;

	}

}
