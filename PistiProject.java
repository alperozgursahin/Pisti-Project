import java.util.Random;
import java.util.Scanner;

public class PistiProject {

	public static int counter = 0;
	public static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	public static String[] deck = new String[52];
	public static Random random = new Random(); 
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		DeckOfCard();
		ShuffleCards(deck);
		for (int i = 0 ; i < deck.length ; i++) {
			System.out.println(deck[i]);
		}
		cutDeck(deck);
		for (int i = 0; i < deck.length ; i++ ) {
			System.out.println(deck[i]);
		}
	}
	
	public static void DeckOfCard() {
		for (int i = 0; i<suits.length ; i++) {
			for (int j = 0; j<ranks.length ; j++) {
				deck[counter++] = suits[i] +" " +ranks[j];	
			}
		}
}
	public static void ShuffleCards(String[] deck) {
		String temp = "";
		for (int i = 0; i < deck.length ; i++) {
			temp = deck[i];
			int randomNumber = random.nextInt(52);
			deck[i] = deck[randomNumber];
			deck[randomNumber] = temp;
		}
	}
	public static void cutDeck(String[] deck) {
	    System.out.println("Cut please. 'Choose between 1-" + (deck.length - 1) + "'");
	    int cutPoint = scanner.nextInt();
	    
	    // Check that the cut point is within the valid range for the deck size
	    if (cutPoint < 1 || cutPoint >= deck.length) {
	        System.out.println("Invalid cut point. Please try again.");
	        return;
	    }
	    
	    // Create the top and bottom halves of the deck
	    String[] topDeck = new String[cutPoint];
	    String[] bottomDeck = new String[deck.length - cutPoint];
	    for (int i = 1; i <= cutPoint; i++) {
	        topDeck[i-1] = deck[deck.length -i];
	    }
	    for (int i = 0; i < deck.length-cutPoint; i++) {
	        bottomDeck[i] = deck[i];
	    }
	    
	    // Reverse the top half of the deck
	    for (int i = 0; i < cutPoint / 2; i++) {
	        String temp = topDeck[i];
	        topDeck[i] = topDeck[topDeck.length -i -1];
	        topDeck[topDeck.length - i - 1] = temp;
	    }
	    
	    // Combine the top and bottom halves to create the shuffled deck
	    for (int i = 0; i < deck.length; i++) {
	        if (i < cutPoint) {
	            deck[i] = topDeck[i];
	        } else {
	            deck[i] = bottomDeck[i - cutPoint];
	        }
	    }
	}
}