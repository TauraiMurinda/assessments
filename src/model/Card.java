package model;

import java.util.Comparator;

import utility.Ranks;
import utility.Suit;

public class Card {

	private Suit suit;
	private Ranks rank;

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	public Card(Ranks rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + "" + suit;
	}

	private static Comparator<Suit> suitComparator = new Comparator<Suit>() {

		@Override
		public int compare(Suit o1, Suit o2) {
			return o1.getSuitSymbol().getBytes().length - o2.getSuitSymbol().getBytes().length;
		}

	};

	private static Comparator<Ranks> rankComparator = new Comparator<Ranks>() {

		@Override
		public int compare(Ranks o1, Ranks o2) {
			return o1.toString().compareTo(o2.toString());
		}
	};

}
