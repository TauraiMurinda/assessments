package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.Card;
import model.Hand;
import utility.Ranks;
import utility.Suit;

public class HandCardsSetStrengthChecker {

	Map<Hand, List<Card>> pokerHand = new HashMap<>();
	Map<Hand, List<Ranks>> rank = new HashMap<>();
	Map<Hand, List<Suit>> suits = new HashMap<>();
	Map<Hand, List<String>> sameRank = new HashMap<>();

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

	Map<Hand, List<String>> sequential = new HashMap<>();
	Map<Hand, List<String>> different = new HashMap<>();
	Map<Hand, List<String>> wildCard = new HashMap<>();
	Hand hand;

	public HandCardsSetStrengthChecker(Hand hand) {
		this.hand = hand;
		pokerHand.put(hand, hand.getHandSetOfCards());
		parseCardofHand();
	}

	
	Map<Hand, List<Suit>> suitSame = new HashMap<>();
	Map<Hand, List<Suit>> suitDiff = new HashMap<>();
	Map<Hand, List<String>> wildCar = new HashMap<>();
	void parseCardofHand() {

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

		List<String> listSame = new ArrayList<String>();
		List<String> listdiff = new ArrayList<String>();
		List<String> seq =   new ArrayList<String>();
		List<Suit> suit = new ArrayList<>();
		List<Suit> su = new ArrayList<>();
		List<Suit> same = new ArrayList<>();
		List<Suit>listdif = new ArrayList<>();


		
	
		
		
		

		for (Entry<Hand, List<Suit>> me : suits.entrySet()) {
			suit = me.getValue();
			int x = 0;
			

			for (Suit ran : suit) {
				if (same.contains(ran) && (!(same.size() == 0))) {
					same.add(ran);

				} else {

					if (same.size() == 0) {
						same.add(ran);
						++x;

					}

					if (!same.contains(ran)) {
						listdif.add(ran);
						System.out.println("herreeeee: " + ran.toString());

					}

					if (!listdif.contains(same.get(0))) {
						listdif.add(same.get(0));
						same.remove(same.get(0));

					}
					
					//System.out.println("here");
					/*
					 * int y =0; if(Integer.valueOf(listdiff.get(y)) -
					 * Integer.valueOf(ran.toString()) ==1) { //System.out.println("here");
					 * seq.add(listdiff.get(y)); seq.add(ran.toString().trim());
					 * //listdiff.remove(listdiff.get(y));
					 * 
					 * y++; }
					 */
					
					
	



				}
			}
          
			suitSame.put(hand, same);
			suitDiff.put(hand, listdif);
			//sequential.put(hand,seq);
			//System.out.println(seq);
			System.out.println("herreeeee: " +  (listdif.size()) + " ");
			listdif = null;

			break;

		}
		

		


		for (Entry<Hand, List<Ranks>> me : rank.entrySet()) {
			List<Ranks> listRang = me.getValue();
			int x = 0;
			for (Ranks ran : listRang) {
				if (listSame.contains(ran.toString().trim()) && (!(listSame.size() == 0))) {
					listSame.add(ran.toString());

				} else {

					if (listSame.size() == 0) {
						listSame.add(ran.toString().trim());
						++x;

					}

					if (!listSame.contains(ran.toString().trim())) {
						listdiff.add(ran.toString().trim());

					}

					if (!listdiff.contains(listSame.get(0).trim())) {
						listdiff.add(listSame.get(0).trim());
						listSame.remove(listSame.get(0).trim());


					}
					
					//System.out.println("here");
					
					int y =0;
					if(Integer.valueOf(listdiff.get(y)) - Integer.valueOf(ran.toString()) ==1) {
						//System.out.println("here");
						seq.add(listdiff.get(y));
						seq.add(ran.toString().trim());
						//listdiff.remove(listdiff.get(y));

						y++;
					}
					
					
	



				}
			}
          
			sameRank.put(hand, listSame);
			different.put(hand, listdiff);
			sequential.put(hand,seq);
			System.out.println(seq);
			break;

		}

	}
}
