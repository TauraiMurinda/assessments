package utility;

import java.util.Comparator;

import model.Card;
import model.Deck;

public enum Suit {
	
    SPADES("\u2660"), 
    HEARTS("\u2665"), 
    DIAMONDS("\u2666"),
    CLUBS("\u2663"); 

 private final String suitSymbol;

 public String getSuitSymbol() {
	return suitSymbol;
}

private Suit(String suitSymbol){
      this.suitSymbol = suitSymbol;
       }
 
 @Override
 public String toString() {
	 return this.suitSymbol;
 }

 

}
  

