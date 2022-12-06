import java.util.Random;
import java.util.Scanner;

public class PistiProject {

	public static int counter = 0;
	public static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	public static String[] deck = new String[52];
	public static Random random = new Random(); 
	public static Scanner scanner = new Scanner(System.in);
	public static String[] floor = new String[52];
	public static String[] userCards = new String[4];
	public static String[] computerCards = new String[4];
	public static int round = 1;
	public static String LastFloorCard = "  ";
	public static int floorCardsNumber = 0;
	
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
		floorPlacement(deck);
		deliveryCard(deck, round);
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
	public static void floorPlacement(String[] deck) {   //Floor cards
		for (int i = 0; i < 4; i++) {
			floor[i] = deck[deck.length-1-i];
			System.out.println("Cards on the floor are: "+ floor[i]);
		}
		floorCardsNumber = 4;
		LastFloorCard = floor[3];
		System.out.println("The Last card on the floor is: "+ LastFloorCard);
		
	}
	
	
	public static void deliveryCard(String[] deck, int round) {		//Delivery Cards
		int count = 2;
		for (int i = 1*round ; i<=8 ;i++) {
			if (count %2 == 0 ) {
				userCards[(i-1)/2] = deck[deck.length-(i*round)-4];
				count++;
				
			}
			else {
				computerCards[(i-1)/2] = deck[deck.length-(i*round)-4];
				count++;
			}	
			
		}
		
	}
}