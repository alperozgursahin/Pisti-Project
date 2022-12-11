package main;

import java.util.Random;
import java.util.Scanner;

public class Deck {
	
	
	
	
	public static String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
	public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	public static String[] deck = new String[52];
	public static String[] floor = new String[52];
	public static String[] userCards = new String[4];
	public static String[] computerCards = new String[4];
	public static String[] collectedUserCards = new String[deck.length*2];
	public static String[] collectedComputerCards = new String[deck.length*2];
	public static String lastPlayedComputerCard = "";
	public static String LastFloorCard = "";
	public static int counter = 0;
	public static int round = 1;
	public static int userPisti = 0;
	public static int computerPisti = 0;
	public static int userScore = 0;
	public static int computerScore = 0;
	public static int floorCardsNumber = 0;
	public static int running = 1;
	public static int insideCounter;
	public static int insideCounter2 = 4;
	public static int insideCounter3;
	public static int collectedUserCardsNumber = 0;
	public static int collectedComputerCardsNumber = 0;
 	public static int computerRandomPlayCounter;	
	public static int lastIndex;
	public static boolean computerTurn;
	public static Random random = new Random();
	public static Scanner scanner = new Scanner(System.in);
	
	
	public String[] getCollectedUserCards() {
		return collectedUserCards;
	}
	public String[] getCollectedComputerCards() {
		return collectedComputerCards;
	}
	
	
	
	public String[] DeckOfCard() {
		System.out.println("The cards are dealing..");
		for (int i = 0; i<suits.length ; i++) {
			for (int j = 0; j<ranks.length ; j++) {
				deck[counter++] = suits[i] +" " +ranks[j];	
			}
		}
		return deck;
}
	
	
	public void ShuffleCards(String[] deck) {
		System.out.println("The cards are shuffling..");
		String temp = "";
		for (int i = 0; i < deck.length ; i++) {
			temp = deck[i];
			int randomNumber = random.nextInt(52);
			deck[i] = deck[randomNumber];
			deck[randomNumber] = temp;
		}
	}
	
	public void cutDeck(String[] deck) {
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
	
	public void floorPlacement(String[] deck) {   //Floor cards
		for (int i = 0; i < 4; i++) {
			floor[i] = deck[deck.length-1-i];
			//System.out.println("Cards on the floor are: "+ floor[i]);
		}
		floorCardsNumber = 4;
		LastFloorCard = floor[3];
		//System.out.println("The Last card on the floor is: "+ LastFloorCard);
		
	}
	
	
	public void dealCards(String[] deck, int round) {		//DealCards
		int k = 4*(round-1);
		for (int i = 4*round; i<(8*round)-k; i++)  {
			userCards[i-4*round] = deck[deck.length-1-i];
			computerCards[i-4*round] = deck[deck.length-1-i-4];
		}
		lastIndex = 3;
		insideCounter = 0;
		insideCounter3 = 0;
		computerRandomPlayCounter = 4;
		
	}
	
public void gameRun() {
		
		String[] lastCard = new String[1];

		/*if (LastFloorCard.equals("  ")) {
			System.out.println("The floor is empty.");
		} else {
			System.out.println("The new floor card is: "+LastFloorCard);
		}*/
		System.out.println("The last card is: "+LastFloorCard);
		System.out.println();
		
		//User Play Part
		
		System.out.println("Your Cards: ");
		for (int i = 0; i < 4-insideCounter ; i++) {
			System.out.println((i+1)+")"+userCards[i]);
		}
		System.out.println();
		
		lastCard[0] = "  ";
		
		System.out.println("Which one do you want to throw to floor ? Type a number please!");
		int userChoice = scanner.nextInt();
		
		lastCard[0] = userCards[userChoice-1];
		
		floor[insideCounter2] = lastCard[0];
		insideCounter2 ++;
		floorCardsNumber++;
		
		if (floorCardsNumber > 0 ) {
			if (lastCard[0].substring(lastCard[0].length()-2,lastCard[0].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length()))) {  //Checks last 2 index 
				if (floorCardsNumber ==1) {
					userPisti ++;
					System.out.println("You made a pisti. Bravo!");
					floorCardsNumber = 0;
					LastFloorCard = "  ";
				}
				else {
					for (int i = 0 ; i <floorCardsNumber  ; i++) {
						collectedUserCards[i+collectedUserCardsNumber] = floor[i];
						floor[i] = "  ";
					}
					collectedUserCardsNumber += floorCardsNumber;
					floorCardsNumber = 0;
					LastFloorCard = "  ";
					System.out.println("You collected all cards.");
				}
				
			} 
			else if (lastCard[0].substring(lastCard[0].length()-4, lastCard[0].length()).equals("Jack")) {	//Checks last 4 index 
				if (floorCardsNumber == 1) {
					userPisti++ ;
					System.out.println("You made a pisti. Bravo!");
					floorCardsNumber = 0;
					LastFloorCard = "  ";
				}
				else if (lastCard[0].substring(lastCard[0].length()-4, lastCard[0].length()).equals("Jack")){
					for (int i = 0 ; i < floorCardsNumber; i++) {
						collectedUserCards[i+collectedUserCardsNumber] = floor[i];
						floor[i] = "  ";
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
		
		int computerRandomPlay = random.nextInt(computerRandomPlayCounter);
		
		//Computer Play Part
		
		
		//Computer's first hand
		
		/*for (int i = 0; i < computerCards.length; i++) {
			System.out.println("The computer cards: "+ computerCards[i]);
		}*/
			if (computerTurn) {
				if (floorCardsNumber > 0) {
					for (int i = 0; i< computerCards.length-insideCounter3 ; i++) {
						if (computerCards[i].substring(computerCards[i].length()-2,computerCards[i].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length())) ) {
							if (floorCardsNumber == 1) {
								computerPisti ++;
								computerCards[i] = "  ";
								System.out.println("The computer made pisti!!");
								for (int j = 0; j<floorCardsNumber; j++) {
									floor[j] = "  ";
								}
								floorCardsNumber = 0;
								LastFloorCard = "  ";
								computerTurn = false;
								break;
								
							}
							else {
								for (int j = 0; j < floorCardsNumber ; j++) {
									collectedComputerCards[j+collectedComputerCardsNumber] = floor[j];
									floor[j] = "  ";
								}
								System.out.println("The computer collected all cards!!");
								collectedComputerCardsNumber += floorCardsNumber;
								computerCards[i] = "  ";
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
					
					
				} /*else {
					computerCards[computerRandomPlay] = LastFloorCard;
					computerCards[computerRandomPlay] = "";
					floorCardsNumber ++;
					computerTurn = false;*/
					
				}
			if (computerTurn) {				//Checks Jack's
				for (int i = 0; i< computerCards.length ; i++) {
					if (computerCards[i].equals("F Jack")) {
						for (int j = 0; j < floorCardsNumber ; j++) {
							collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
							floor[j] = "  ";
							computerCards[i] = "  ";
							
						}		
						System.out.println("The computer collected all cards!!");
						collectedComputerCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
						computerTurn = false;
						break;
					}
					else if (computerCards[i].equals("Spades Jack")) {
						for (int j = 0; j < floorCardsNumber ; j++) {
							collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
							floor[j] = "  ";
							computerCards[i] = "  ";
						}
						System.out.println("The computer collected all cards!!");
						collectedComputerCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
						computerTurn = false;
						break;
					}
					else if (computerCards[i].equals("Hearts Jack")) {
						for (int j = 0; j < floorCardsNumber ; j++) {
							collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
							floor[j] = "  ";
							computerCards[i] = "  ";
						}
						System.out.println("The computer collected all cards!!");
						collectedComputerCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
						computerTurn = false;
						break;
					}
					else if (computerCards[i].equals("Diamonds Jack")) {
						for (int j = 0; j < floorCardsNumber ; j++) {
							collectedComputerCards[j+collectedComputerCardsNumber] = floor[j]; 
							floor[j] = "  ";
							computerCards[i] = "  ";
						}
						System.out.println("The computer collected all cards!!");
						collectedComputerCardsNumber += floorCardsNumber;
						floorCardsNumber = 0;
						LastFloorCard = "  ";
						computerTurn = false;
						break;
					}
					
					
				}
				
				
			}
			
			if (computerTurn) {
				System.out.println("Computer played.");
				LastFloorCard = computerCards[computerRandomPlay];
				computerCards[computerRandomPlay] = "  ";
				floorCardsNumber ++;
				
					
				
			}
			
			//Computer's new hand
			
			/*for (int i = 0; i < computerCards.length; i++) {						
				System.out.println("The new computer cards: "+ computerCards[i]); 
				}*/
				
	
			String temp = "  ";
			temp = userCards[lastIndex];
			userCards[userChoice-1] = temp;
			userCards[lastIndex] = "  ";
			insideCounter++;
			
			String temp2 = "  ";
			temp2 = computerCards[lastIndex];
			computerCards[computerRandomPlay] = temp2;
			computerCards[lastIndex] = "  ";
			computerRandomPlayCounter --;
			insideCounter3++;
			
			lastIndex--;
			
			
	
	
}
	
	
}
