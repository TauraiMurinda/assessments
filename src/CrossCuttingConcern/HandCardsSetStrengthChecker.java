package CrossCuttingConcern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.Card;
import model.Hand;
import utility.Ranks;
import utility.Suit;

public class HandCardsSetStrengthChecker {

	private Map<Hand, List<Card>> pokerHand = new HashMap<>();
	private Map<Hand, List<Ranks>> rank = new HashMap<>();
	private Map<Hand, List<Suit>> suits = new HashMap<>();
	private Map<Hand, List<String>> sameRank = new HashMap<>();

	public Map<Hand, List<String>> getSameRank() {
		return sameRank;
	}

	public void setSameRank(Map<Hand, List<String>> sameRank) {
		this.sameRank = sameRank;
	}

	public Map<Hand, List<String>> getDifferent() {
		return different;
	}

	public void setDifferent(Map<Hand, List<String>> different) {
		this.different = different;
	}

	private Map<Hand, List<String>> different = new HashMap<>();
	Hand hand;

	public HandCardsSetStrengthChecker(Hand hand) {
		this.hand = hand;
		pokerHand.put(hand, hand.getHandSetOfCards());
		parseCardofHand();
	}

	private Map<Suit, Integer> handSuit = new HashMap<>();

	private void parseCardofHand() {

		List<Card> listCard = new ArrayList<>();
		List<Ranks> listRank = new ArrayList<>();
		List<Suit> listSuit = new ArrayList<>();

		for (Entry<Hand, List<Card>> me : pokerHand.entrySet()) {
			listCard = me.getValue();

			for (Card card : listCard) {
				listRank.add(card.getRank());
				listSuit.add(card.getSuit());
			}
			rank.put(me.getKey(), listRank);
			suits.put(me.getKey(), listSuit);
		}

		List<Suit> suit1 = new ArrayList<>();
		List<Suit> suit2 = new ArrayList<>();

		for (Entry<Hand, List<Suit>> me : suits.entrySet()) {
			suit1 = me.getValue();
			suit2 = me.getValue();
		}

		int z = 0;
		Iterator<Suit> s = suit1.iterator();
		while (s.hasNext()) {
			Suit l = s.next();
			handSuit.put(l, Collections.frequency(suit1, l));

		}

		// System.out.println("handei " + Collections.max(suit1));

		Map<Ranks, Integer> sameRa = new HashMap<>();
		Iterator<Ranks> ra = listRank.iterator();
		while (ra.hasNext()) {
			Ranks l = ra.next();
			sameRa.put(l, Collections.frequency(listRank, l));
		}

		Collection<Integer> listInteger = new ArrayList<Integer>();
		int frequency = 0;

		for (Map.Entry<Ranks, Integer> same : sameRa.entrySet()) {
			listInteger = sameRa.values();
			// System.out.println(same.getKey() + "_________________" + (same.getValue()));
			frequency = Collections.max(listInteger);
			// System.out.println("frequency "+frequency);
		}

		switch (frequency) {

		case 1:
			isFlush(handSuit);
			break;

		case 2:
			setStrength("One pair");
			break;

		case 3:
			setStrength("Three of a Kind");
			break;

		case 4:
			setStrength("four of a Kind");
			break;

		case 5:
			setStrength("Four of a Kind");
			break;

		default:
			break;
		}

	}

	public void isFlush(Map<Suit, Integer> handSuitRecord) {
		List<Integer> suitFrequencyRecordings = new ArrayList<Integer>();
		for (Map.Entry<Suit, Integer> handSuitRecord1 : handSuitRecord.entrySet()) {
			suitFrequencyRecordings.add(handSuitRecord1.getValue());
			int suitFrequency = Collections.max(suitFrequencyRecordings);
			if (suitFrequency == 4 | suitFrequency == 5) {
				System.out.println("helo here");
				setStrength("flush");
			} else {
				setStrength("strength to be determined");

			}
		}
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	private String strength;
}
