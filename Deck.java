package main;

import java.util.Random;
import java.util.Scanner;

public class Deck {
	

	private static String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
	private static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};
	private static String[] deck = new String[52];
	private static String[] floor = new String[52];
	private static String[] userCards = new String[4];
	private static String[] computerCards = new String[4];
	private static String[] collectedUserCards = new String[deck.length];
	private static String[] collectedComputerCards = new String[deck.length];
	private static String LastFloorCard = "";
	private static int counter = 0;
	private static int userPisti = 0;
	private static int computerPisti = 0;
	private static int floorCardsNumber;
	private static int insideCounter;
	//private static int insideCounter2 = 4;
	private static int insideCounter3;
	private static int collectedUserCardsNumber = 0;
	private static int collectedComputerCardsNumber = 0;
 	private static int computerRandomPlayCounter;	
	private static int lastIndex;
	private static boolean computerTurn;
	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);
	private static int lastWin; 
	
	
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
	public void organizeComputerCards(String[] computerCards, int i) {
		String temp2 = "  ";
		temp2 = computerCards[lastIndex];			//Organising Computer Cards
		computerCards[i] = temp2;
		computerCards[lastIndex] = "    ";
		computerRandomPlayCounter --;
		insideCounter3++;
	}
	
public void gameRun() {
		
	System.out.println("Floor cards number is: "+floorCardsNumber);
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
		

		
		if (floorCardsNumber > 0 ) {
			if (lastCard[0].substring(lastCard[0].length()-2,lastCard[0].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length())))  {  //Checks last 2 index 
				if (floorCardsNumber == 1) {
					setUserPisti(getUserPisti() + 1) ;
					System.out.println("You made a pisti. Bravo!");
					floorCardsNumber = 0;
					LastFloorCard = "    ";
					floor[0] = "  ";
					setLastWin(0);
				}
				else {
					for (int i = 0 ; i <floorCardsNumber  ; i++) {
						collectedUserCards[i+collectedUserCardsNumber] = floor[i];
						floor[i] = "  ";
					}
					collectedUserCardsNumber += floorCardsNumber;
					floorCardsNumber = 0;
					LastFloorCard = "    ";
					System.out.println("You collected all cards.");
					setLastWin(0);
				}
				
			} 
			else if (lastCard[0].substring(lastCard[0].length()-4,lastCard[0].length()).equals("Jack")) {	//Checks last 4 index 
				if (floorCardsNumber == 1) {
					setUserPisti(getUserPisti() + 1) ;
					System.out.println("You made a pisti. Bravo!");
					floorCardsNumber = 0;
					LastFloorCard = "    ";
					setLastWin(0);
				}
				else {
					for (int i = 0 ; i < floorCardsNumber; i++) {
						collectedUserCards[i+collectedUserCardsNumber] = floor[i];
						floor[i] = "  ";
					}
					System.out.println("You collected all cards.");
					collectedUserCardsNumber += floorCardsNumber;
					floorCardsNumber = 0;
					LastFloorCard = "    ";
					setLastWin(0);
				}
			}

			else {
				LastFloorCard = lastCard[0];
				floor[floorCardsNumber] = lastCard[0];
				floorCardsNumber++;
			}
		}
		else {
			LastFloorCard = lastCard[0];
			floor[floorCardsNumber] = lastCard[0];
			floorCardsNumber++;
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
								setComputerPisti(getComputerPisti() + 1);
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								setLastWin(1);
								organizeComputerCards(computerCards,i);
							
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
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								setLastWin(1);
								
								organizeComputerCards(computerCards,i);
								computerTurn = false;
								break;
							}
						}	
						
					}	
					
				} 
			}
			if (computerTurn && floorCardsNumber > 0) {				//Checks Jack's
					for (int i = 0; i< computerCards.length-insideCounter3 ; i++) {
						
						if (computerCards[i].substring(computerCards[i].length()-4, computerCards[i].length()).equals("Jack") ) {
							if (floorCardsNumber == 1 && LastFloorCard.substring(LastFloorCard.length()-4, LastFloorCard.length()).equals("Jack")) {
								setComputerPisti(getComputerPisti() + 1);
								
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								collectedComputerCardsNumber += floorCardsNumber;
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								setLastWin(1);
								
								organizeComputerCards(computerCards,i);
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
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								setLastWin(1);
								
								organizeComputerCards(computerCards,i);
								computerTurn = false;
								break;
								
							}
							
						}
						
						
						
					
						
						
						/*if (computerCards[i].equals("Clubs Jack")) {
							if (floorCardsNumber == 1 && LastFloorCard.substring(LastFloorCard.length()-4, LastFloorCard.length()).equals("Jack")) {
								setComputerPisti(getComputerPisti() + 1);	
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								collectedComputerCardsNumber += floorCardsNumber;
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								
								organizeComputerCards(computerCards,i);
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
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								
								organizeComputerCards(computerCards,i);
								computerTurn = false;
								break;
							}
							
						}
						if (computerCards[i].equals("Spades Jack")) {
							if (floorCardsNumber == 1 && LastFloorCard.substring(LastFloorCard.length()-4, LastFloorCard.length()).equals("Jack")) {
								setComputerPisti(getComputerPisti() + 1);							
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								collectedComputerCardsNumber += floorCardsNumber;
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								organizeComputerCards(computerCards,i);
								
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
								LastFloorCard = "    ";
								lastWin = 1;
								organizeComputerCards(computerCards,i);
								
								computerTurn = false;
								break;
							}
							
						}
						if (computerCards[i].equals("Diamonds Jack")) {
							if (floorCardsNumber == 1 && LastFloorCard.substring(LastFloorCard.length()-4, LastFloorCard.length()).equals("Jack")) {
								setComputerPisti(getComputerPisti() + 1);
								
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								collectedComputerCardsNumber += floorCardsNumber;
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								organizeComputerCards(computerCards,i);
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
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								
								organizeComputerCards(computerCards,i);
								
								computerTurn = false;
								break;
							}
							
						}
						if (computerCards[i].equals("Hearts Jack")) {		computerCards[i].substring(computerCards[i].length()-4, computerCards[i].length()).equals("Jack")
							if (floorCardsNumber == 1 && LastFloorCard.substring(LastFloorCard.length()-4, LastFloorCard.length()).equals("Jack")) {
								setComputerPisti(getComputerPisti() + 1);
								
								System.out.println("The computer made pisti!!");
								
								floor[0] = "  ";
								collectedComputerCardsNumber += floorCardsNumber;
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								
								organizeComputerCards(computerCards,i);
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
								
								floorCardsNumber = 0;
								LastFloorCard = "    ";
								lastWin = 1;
								organizeComputerCards(computerCards,i);
								computerTurn = false;
								break;
							}
							
						}*/
						
						
						
					}
							
				
			}
			
			if (computerTurn) {
				System.out.println("Computer played.");
				LastFloorCard = computerCards[computerRandomPlay];
				floor[floorCardsNumber] = computerCards[computerRandomPlay];
				floorCardsNumber ++;
				computerTurn = false;
				
		
				organizeComputerCards(computerCards,computerRandomPlay);
				
				
			}
			
			//Computer's new hand
			
			/*for (int i = 0; i < computerCards.length; i++) {						
				System.out.println("The new computer cards: "+ computerCards[i]); 
				}*/
				
	
			String temp = "  ";				//Organising User Cards
			temp = userCards[lastIndex];
			userCards[userChoice-1] = temp;
			userCards[lastIndex] = "  ";
			insideCounter++;
			
			
			lastIndex--;
			
			
	
	
}
public int getUserPisti() {
	return userPisti;
}
public void setUserPisti(int userPisti) {
	Deck.userPisti = userPisti;
}
public int getComputerPisti() {
	return computerPisti;
}
public void setComputerPisti(int computerPisti) {
	Deck.computerPisti = computerPisti;
}
public int getLastWin() {
	return lastWin;
}
public static void setLastWin(int lastWin) {
	Deck.lastWin = lastWin;
}
public void collectLastCards(int lastwin) {
	if (lastwin == 0) {
		for (int i = 0 ; i <floorCardsNumber  ; i++) {
			collectedUserCards[i+collectedUserCardsNumber] = floor[i];
			floor[i] = "  ";
		}
		collectedUserCardsNumber += floorCardsNumber;
		floorCardsNumber = 0;
		LastFloorCard = "    ";
		System.out.println("You collected all last cards.");
		
	}
	if (lastwin == 1) {
		for (int i = 0 ; i <floorCardsNumber  ; i++) {
			collectedComputerCards[i+collectedComputerCardsNumber] = floor[i];
			floor[i] = "  ";
		}
		collectedComputerCardsNumber += floorCardsNumber;
		floorCardsNumber = 0;
		LastFloorCard = "    ";
		System.out.println("Computer collected all last cards.");
		
	}
}
	
	
}
