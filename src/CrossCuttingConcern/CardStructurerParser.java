package CrossCuttingConcern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import model.Card;
import utility.Ranks;
import utility.Suit;

public class CardStructurerParser {
 
	private List<Character> elements = new ArrayList<>();


	public List<Character> getElements() {
		return elements;
	}


	public CardStructurerParser(Set<Card> handCards ) {
				
		Iterator<Card> iter = handCards.iterator();
 		char symbol = 0;

		while(iter.hasNext()) {
			
			String str = iter.next().toString();
			if(str.length()>2) {
				symbol = str.charAt(2);
				elements.add(symbol);
			}
			else{
				symbol = str.charAt(1);
				elements.add(symbol);
			}
		}
	}
	
}
