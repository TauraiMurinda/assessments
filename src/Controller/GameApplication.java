package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.standard.PrinterInfo;

import CrossCuttingConcern.HandCardsSetStrengthChecker;
import CrossCuttingConcern.Printer;
import CrossCuttingConcern.PrinterImpl;
import model.Card;
import model.Deck;
import model.Hand;
import service.DealService;
import service.PokerHandStrengthEvaluationService;
import service.ShuffleService;
import utility.Ranks;
import utility.Suit;

public class GameApplication {

	public static void main(String[] args) {		
		//Controller needs service to have access to the functionality

		Deck deck = new Deck();;
		List<Card> cardsofDeck = deck.getDeckOfCards();
		System.out.println("--------------------------DeckOfCards---------------------DeckOfCards---------------------");
        Printer  printer = new PrinterImpl(cardsofDeck);
        printer.print();
        
		ShuffleService shuffleService = new  ShuffleService(cardsofDeck );
		System.out.println("--------------------------Shuffling---------------------shuflling-------------------------");
		Printer  printe = new PrinterImpl(shuffleService.getShuffledCards());
		printe.print();
		Hand handInPoker = new Hand("John");
		//Scanner scannerHandSize =  new Scanner(System.in);
		int singleHandOf_5_Cards = 5;//game constraints cards counts
		//singleHandOf_5_Cards= scannerHandSize.nextInt();
		//assign cards to poker hand
		System.out.println("--------------------------Shuffling---------------------shuflling-------------------------");

		DealService dealService  = new DealService(shuffleService.getShuffledCards(), handInPoker,singleHandOf_5_Cards);
		Printer pri = new PrinterImpl(handInPoker.getHandSetOfCards());
		//PokerHandStrengthEvaluationService phs = new HandCardsSetStrengthChecker(handInPoker);
		
		HandCardsSetStrengthChecker hcs = new HandCardsSetStrengthChecker(handInPoker);
		System.out.print("Your hand: "); pri.print(); System.out.print(hcs.strength);

		Printer pr = new PrinterImpl(hcs.getDifferent());
		Printer p = new PrinterImpl(hcs.getSameRank());
		System.out.println("Your have: \n"); 


		
		
         
	   
	}

}
