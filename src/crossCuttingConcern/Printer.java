package crossCuttingConcern;

import java.util.Collection;

import model.Card;

public interface Printer {

	public void print();

	void print(Collection<Card> cardsofDeck);
}
