package CrossCuttingConcern;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import model.Card;
import model.Hand;

public class PrinterImpl implements Printer {
	private Collection<Card> cardsofDeck = null;

	public PrinterImpl(Collection<Card> cardsofDeck) {
		this.cardsofDeck = cardsofDeck;
	}

	public PrinterImpl(Map<Hand, List<String>> values) {
		for (Entry<Hand, List<String>> me : values.entrySet()) {

			System.out.println("my name is " + me.getKey());
			System.out.print(me.getValue());
		}
	}

	@Override
	public void print() {
		Iterator<Card> iter = cardsofDeck.iterator();
		int suitLine = 0;
		while (iter.hasNext()) {
			if (suitLine < 12) {
				System.out.print(iter.next() + "\t");
				suitLine++;
			} else {
				System.out.println(iter.next());
				suitLine = 0;// reset to suitLine
			}
		}

	}

}
