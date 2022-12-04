import java.util.Random;

public class PistiProject {

	public static int counter = 0;
	public static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	public static String[] deck = new String[52];
	public static Random random = new Random(); 
	
	public static void main(String[] args) {
		DeckOfCard();
		ShuffleCards(deck);
		for (int i = 0 ; i < deck.length ; i++) {
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
}