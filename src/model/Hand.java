package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {

	List<Card> handSetOfCards ; 
	private String handName;
	
	public Hand(String handName) {
		this.handName = handName;
	}

	public void setHandSetOfCards(List<Card> handSetOfCards) {
		if(handSetOfCards.size()==5) {
			this.handSetOfCards = handSetOfCards;
		} else {
			throw new IllegalArgumentException("size of handSet must be 5");   //game constraints
		}
	}
	
     public List<Card>  getHandSetOfCards() {
  	 		return handSetOfCards;
	
	}
     
     @Override public  String toString() {
    	 return handName;
     }

}
