package Controller;

import java.util.List;
import java.util.Scanner;
import CrossCuttingConcern.HandCardsSetStrengthChecker;
import CrossCuttingConcern.Printer;
import CrossCuttingConcern.PrinterImpl;
import model.Card;
import model.Deck;
import model.Hand;
import service.DealService;
import service.ShuffleService;

public class GameApplication {
	public static void main(String[] args) {
		Deck deck = new Deck();
		List<Card> cardsofDeck = deck.getDeckOfCards();
		Printer printer = new PrinterImpl(cardsofDeck);
		Scanner scanner = new Scanner(System.in);
		System.out.format("%s ", "Do wish to display deck of cards Y/n :", System.getProperty("line.separator"));
		if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
			printer.print();
		} else {
			System.out.println("You  have choosen not display deck !");
		}

		ShuffleService shuffleService = new ShuffleService(cardsofDeck);
		System.out
				.println("--------------------------Shuffling---------------------shuflling-------------------------");
		Printer printe = new PrinterImpl(shuffleService.getShuffledCards());

		System.out.format("%s ", "Do wish to display your shuffled cards  Y/n :", System.getProperty("line.separator"));
		if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
			printe.print();
		} else {
			System.out.println("You  have choosen not display cardsy !");
		}

		Hand handInPoker = new Hand("John");
		int singleHandOf_5_Cards = 5;// game constraints cards counts

		System.out
				.println("--------------------------Shuffling---------------------shuflling-------------------------");

		DealService dealService = new DealService(shuffleService.getShuffledCards(), handInPoker, singleHandOf_5_Cards);
		Printer pri = new PrinterImpl(handInPoker.getHandSetOfCards());

		System.out.format("%s ", "Please proceed to show poker strength:");
		scanner.nextLine();

		HandCardsSetStrengthChecker hcs = new HandCardsSetStrengthChecker(handInPoker);
		System.out.print("Your hand: ");
		pri.print();
		System.out.println();
		System.out.println("You have: " + hcs.getStrength());

	}

}
