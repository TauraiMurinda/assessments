package Test;

import java.util.List;

import CrossCuttingConcern.Printer;
import CrossCuttingConcern.PrinterImpl;
import model.Card;
import model.Deck;
import model.Hand;
import service.DealService;
import service.ShuffleService;

public class FlushCheckerTest {

	public static void main(String[] args) {
		Deck deck = new Deck();
		;
		List<Card> cardsofDeck = deck.getDeckOfCards();
		System.out
				.println("--------------------------DeckOfCards---------------------DeckOfCards---------------------");
		Printer printer = new PrinterImpl(cardsofDeck);
		printer.print();

		ShuffleService shuffleService = new ShuffleService(cardsofDeck);
		System.out
				.println("--------------------------Shuffling---------------------shuflling-------------------------");
		Printer printe = new PrinterImpl(shuffleService.getShuffledCards());
		printe.print();
		Hand handInPoker = new Hand("Chipo");
		int singleHandOf_5_Cards = 5;
		System.out
				.println("--------------------------Shuffling---------------------shuflling-------------------------");

		DealService dealService = new DealService(shuffleService.getShuffledCards(), handInPoker, singleHandOf_5_Cards);
		Printer pri = new PrinterImpl(handInPoker.getHandSetOfCards());
		pri.print();
		// PokerHandStrengthEvaluationService phs = new
		// HandCardsSetStrengthChecker(handInPoker);

		// FlushChecker fl = new FlushChecker();
		// fl.isFromSameSuit(handInPoker);
		// fl.extracted();
	}

}
