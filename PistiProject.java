import java.util.Random;
import java.util.Scanner;

public class PistiProject {

	public static String[] suits = {"Sinek", "Maca", "Karo", "Kupa"};
	public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	public static String[] deck = new String[52];
	public static int counter = 0;
	public static Random random = new Random();
	public static Scanner scanner = new Scanner(System.in);
	public static String[] floor = new String[52];
	public static String[] userCards = new String[4];
	public static String[] computerCards = new String[4];
	public static int round = 1;
	public static int userPisti = 0;
	public static int computerPisti = 0;
	public static String[] collectedUserCards = new String[deck.length];
	public static String[] collectedComputerCards = new String[deck.length];
	public static int userScore = 0;
	public static int computerScore = 0;
	public static String LastFloorCard = "";
	public static int floorCardsNumber = 0;
	public static int running = 1;
	public static int insideCounter = 0;
	public static int insideCounter2 = 4;
	public static int insideCounter3 = 0;
	public static int collectedUserCardsNumber = 0;
	public static int collectedComputerCardsNumber = 0;
	public static String lastPlayedComputerCard = "";
 	
	public static void main(String[] args) {
		
		System.out.println("The game begins!");
		int computerRandomPlayCounter = 4;
		String[] lastCard = new String[1];
		DeckOfCard();
		ShuffleCards(deck);
		cutDeck(deck);
		floorPlacement(deck);
		
	while (round < 7) {
		
		boolean	computerTurn = false;
		deliveryCard(deck, round);
		int lastIndex = 3;
		insideCounter = 0;
		insideCounter3 = 0;
		computerRandomPlayCounter = 4;
		
		
		while (running < 5) {
			
			if (LastFloorCard.equals("  ")) {
				System.out.println("The floor is empty.");
			} else {
				System.out.println("The new floor card is: "+LastFloorCard);
			}
			
			
			//User Play Part
			
			for (int i = 0; i < 4-insideCounter ; i++) {
				System.out.println("Your "+(i+1)+". card is: "+userCards[i]);
			}
			
			System.out.println("Which one do you want to throw to floor ? Type a number please!");
			int userChoice = scanner.nextInt();
			
			lastCard[0] = userCards[userChoice-1];
			
			floor[insideCounter2] = lastCard[0];
			insideCounter2 ++;
			floorCardsNumber++;
			
			if (floorCardsNumber > 0 ) {
				if (lastCard[0].substring(lastCard[0].length()-2,lastCard[0].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length()))) {
					if (floorCardsNumber ==1) {
						userPisti ++;
						System.out.println("You made a pisti. Bravo!");
						floorCardsNumber = 0;
						LastFloorCard = "  ";
					}
					else {
						for (int i = 0 ; i <floorCardsNumber  ; i++) {
							collectedUserCards[i+collectedUserCardsNumber] = floor[i];
							floor[i] = "";
						}
						collectedUserCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
						System.out.println("You collected all cards.");
					}
					
				} 
				else if (lastCard[0].substring(lastCard[0].length()-4, lastCard[0].length()).equals("Jack")) {
					if (floorCardsNumber == 1) {
						userPisti++ ;
						System.out.println("You made a pisti. Bravo!");
						floorCardsNumber = 0;
						LastFloorCard = "  ";
					}
					else if (lastCard[0].substring(lastCard[0].length()-4, lastCard[0].length()).equals("Jack")){
						for (int i = 0 ; i < floorCardsNumber; i++) {
							collectedUserCards[i+collectedUserCardsNumber] = floor[i];
							floor[i] = "";
						}
						System.out.println("You collected all cards.");
						collectedUserCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
					}
				}
				
				else {
					floorCardsNumber ++;
					LastFloorCard = lastCard[0];
				}
				
			}
			else {
				LastFloorCard = lastCard[0];
				floorCardsNumber ++;
			}
			
			
			computerTurn = true;
		
			
			//Computer Play Part
			
			int computerRandomPlay = random.nextInt(computerRandomPlayCounter);
				
			for (int i = 0; i < computerCards.length; i++) {
				System.out.println("The computer cards: "+ computerCards[i]);
			}
				if (computerTurn) {
					if (floorCardsNumber > 0) {
						for (int i = 0; i< computerCards.length-insideCounter3 ; i++) {
							if (computerCards[i].substring(computerCards[i].length()-2,computerCards[i].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length())) ) {
								if (floorCardsNumber == 1) {
									computerPisti ++;
									computerCards[i] = "  ";
									for (int j = 0; j<floorCardsNumber; j++) {
										floor[j] = "";
									}
									floorCardsNumber = 0;
									LastFloorCard = "  ";
									computerTurn = false;
									break;
									
								}
								else {
									for (int j = 0; j < floorCardsNumber ; j++) {
										collectedComputerCards[j+collectedComputerCardsNumber] = floor[j];
										floor[j] = "";
									}
									collectedComputerCardsNumber += floorCardsNumber;
									computerCards[i] = "";
									floorCardsNumber = 0;
									LastFloorCard = "  ";
									computerTurn = false;
									break;
								}
							
							}	
							/*collectedComputerCardsNumber += floorCardsNumber;
							floorCardsNumber = 0;
							LastFloorCard = "  ";
							computerTurn = false;*/
						}
						
						
					} else {
						computerCards[computerRandomPlay] = LastFloorCard;
						computerCards[computerRandomPlay] = "";
						floorCardsNumber ++;
						computerTurn = false;
						
					}
				}
					if (computerTurn) {
						for (int i = 0; i< computerCards.length ; i++) {
							if (computerCards[i].equals("Sinek Jack")) {
								for (int j = 0; j < floorCardsNumber ; j++) {
									collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
									floor[j] = "";
									computerCards[i] = "";
									
								}		
								collectedComputerCardsNumber += floorCardsNumber;
								floorCardsNumber = 0;
								LastFloorCard = "  ";
								computerTurn = false;
								break;
							}
							else if (computerCards[i].equals("Maca Jack")) {
								for (int j = 0; j < floorCardsNumber ; j++) {
									collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
									floor[j] = "";
									computerCards[i] = "";
								}
								collectedComputerCardsNumber += floorCardsNumber;
								floorCardsNumber = 0;
								LastFloorCard = "  ";
								computerTurn = false;
								break;
							}
							else if (computerCards[i].equals("Kupa Jack")) {
								for (int j = 0; j < floorCardsNumber ; j++) {
									collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
									floor[j] = "";
									computerCards[i] = "";
								}
								collectedComputerCardsNumber += floorCardsNumber;
								floorCardsNumber = 0;
								LastFloorCard = "  ";
								computerTurn = false;
								break;
							}
							else if (computerCards[i].equals("Karo Jack")) {
								for (int j = 0; j < floorCardsNumber ; j++) {
									collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
									floor[j] = "";
									computerCards[i] = "";
								}
								collectedComputerCardsNumber += floorCardsNumber;
								floorCardsNumber = 0;
								LastFloorCard = "  ";
								computerTurn = false;
								break;
							}
							
							else {
								computerCards[computerRandomPlay] = LastFloorCard;
								computerCards[computerRandomPlay] = "";
								floorCardsNumber ++;
								
							}
							
						}
					}
					
				
			for (int i = 0; i < computerCards.length; i++) {
				System.out.println("The new computer cards: "+ computerCards[i]); 
				}
				
	
			String temp = "";
			temp = userCards[lastIndex];
			userCards[userChoice-1] = temp;
			userCards[lastIndex] = "  ";
			insideCounter++;
			
			String temp2 = "";
			temp2 = computerCards[lastIndex];
			computerCards[computerRandomPlay] = temp2;
			computerCards[lastIndex] = "  ";
			computerRandomPlayCounter --;
			insideCounter3++;
			
			lastIndex--;
			running ++;
			
		}
		
		/*for (int i = 0; i < 4 ; i++) {
			System.out.println("Computer cards are: "+computerCards[i]);
		}*/
		running = 1;
		
	}
	round++;
}
	public static void DeckOfCard() {
		System.out.println("The cards are dealing..");
		for (int i = 0; i<suits.length ; i++) {
			for (int j = 0; j<ranks.length ; j++) {
				deck[counter++] = suits[i] +" " +ranks[j];	
			}
		}
}
	public static void ShuffleCards(String[] deck) {
		System.out.println("The cards are shuffling..");
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
	public static void calculator(String[] collectedUserCards, String[] collectedComputerCards) {

		int userKaro10 = 0;
		int computerKaro10 = 0;
		int userSinek2 = 0;
		int computerSinek2 = 0;
		int userAce = 0;
		int computerAce = 0;
		int userJack = 0;
		int computerJack = 0;
		
		if (collectedUserCards.length > collectedComputerCards.length) {
			userScore +=3;
		}
		else if (collectedUserCards.length > collectedComputerCards.length) {
			userScore +=0;
		}
		else {
			computerScore += 3;
		}
		if (userPisti>0) {
			userScore += userPisti*3;
		}
		if (computerPisti>0) {
			computerScore += computerPisti*3;
		}
		for (int i = 0; i<collectedUserCards.length; i++ ) {
			if (collectedUserCards[i] == "Karo 10") {
				userKaro10 ++;
			}
			if (collectedUserCards[i] == "Sinek 2") {
				userSinek2 ++;
			}
			if (collectedUserCards[i] == "Sinek Ace" || collectedUserCards[i] == "Maca Ace" || collectedUserCards[i] == "Karo Ace" || collectedUserCards[i] == "Kupa Ace") {
				userAce ++;
			}
			if (collectedUserCards[i] == "Sinek Jack" || collectedUserCards[i] == "Maca Jack" || collectedUserCards[i] == "Karo Jack" || collectedUserCards[i] == "Kupa Jack") {
				userJack ++;
			}
			
		}
		for (int i = 0; i<collectedComputerCards.length; i++ ) {
			if (collectedComputerCards[i] == "Karo 10") {
				computerKaro10 ++;
			}
			if (collectedComputerCards[i] == "Sinek 2") {
				computerSinek2 ++;
			}
			if (collectedComputerCards[i] == "Sinek Ace" || collectedComputerCards[i] == "Maca Ace" || collectedComputerCards[i] == "Karo Ace" || collectedComputerCards[i] == "Kupa Ace") {
				computerAce ++;
			}
			if (collectedComputerCards[i] == "Sinek Jack" || collectedComputerCards[i] == "Maca Jack" || collectedComputerCards[i] == "Karo Jack" || collectedComputerCards[i] == "Kupa Jack") {
				computerJack ++;
			}
			
		}
		if (userKaro10 > 0 ) {
			userScore += 10;
		}
		if (computerKaro10 > 0 ) {
			computerScore += 10;
		}
		if (userSinek2 > 0) {
			userScore += 2;
		}
		if (computerSinek2 > 0) {
			computerScore += 2;
		}
		if (userAce >0) {
			userScore += userAce*1;
		}
		if (computerAce >0) {
			computerScore += computerAce*1;
		}
		if (userJack > 0) {
			userScore += userJack*1;	
		}
		if (computerJack > 0) {
			computerScore += computerJack*1;
		}
	}

		
}
	
	
