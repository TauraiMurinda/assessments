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
		List<String> seq = new ArrayList<String>();
		List<Suit> suit1 = new ArrayList<>();
		List<Suit> suit2 = new ArrayList<>();
		Map<Suit,Integer> same_1 = new HashMap<>();
		
		
		
		

		for (Entry<Hand, List<Suit>> me : suits.entrySet()) {
			suit1 = me.getValue();
			suit2 = me.getValue();
		}
		
		int z = 0;
		
		Iterator<Suit> s = suit1.iterator();
		while(s.hasNext()) {
			Suit l = s.next();
        	same_1.put(l,Collections.frequency(suit1, l));

	        
		}
		
		
		
		for(Map.Entry<Suit,Integer> same : same_1.entrySet()) {
			
			   System.out.println(same.getKey() + "_________________" + (same.getValue()));
		}
		
		Map<Ranks,Integer> sameRa = new HashMap<>();
		Iterator<Ranks> ra = listRank.iterator();
		while(ra.hasNext()) {
			Ranks l = ra.next();
			sameRa.put(l,Collections.frequency(listRank, l));

	        
		}
		
		Collection<Integer>listInteger = new ArrayList<Integer>();
		  int frequency =  0;

		for(Map.Entry<Ranks,Integer> same : sameRa.entrySet()) {
			    listInteger = sameRa.values();
			  // System.out.println(same.getKey() + "_________________" + (same.getValue()));
			   
			  frequency =  Collections.max(listInteger);
			  
			  
			  
			  System.out.println("frequency "+frequency);
		}
			   
			   switch (frequency) {
			   
			   case 1:
				   strength = "Different cards\n";
             	   System.out.print(strength);
				break;
						   				
              case 2:
            	   strength = "One pair\\n";
             	   System.out.print("One pair\n");
				break;
				
				
              case 3:
              	   System.out.print("Three of a Kind\n");
            	  break;
            	  
              case 4 : 
           	   System.out.print("four of a Kind\\n");
            	  break;
              
              case 5 :
            	   System.out.print("Four of a Kind\n");
            	  break;

			default:
				break;
			}
		
		
	
		/*
		 * 1. Straight Flush 2. Four of a Kind 3. Full House 4. Flush 5. Straight 6.
		 * Three of a Kind 7. Two Pair 8. One Pair 9. High Cards
		 */
		
		

		

	}
	
	public String strength;
}
