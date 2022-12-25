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
	
	
	public String[] DeckOfCard() {					//Creates a new deck.
		
		System.out.println("The cards are dealing..");
		for (int i = 0; i<suits.length ; i++) {
			for (int j = 0; j<ranks.length ; j++) {
				deck[counter++] = suits[i] +" " +ranks[j];	
			}
		}
		return deck;
}
	
			
	public void ShuffleCards(String[] deck) {			//Shuffling Cards
		
		System.out.println("The cards are shuffling..");
		String temp = "";
		for (int i = 0; i < deck.length ; i++) {
			temp = deck[i];
			int randomNumber = random.nextInt(52);
			deck[i] = deck[randomNumber];
			deck[randomNumber] = temp;
		}
	}
	
	public void cutDeck(String[] deck) {			//Asks user where to cut the deck.
		
	    
	    boolean flag = true;
	    int cutPoint = 0;
	    while (flag) {
	    	 System.out.println("Cut please. 'Choose between 1-" + (deck.length - 1) + "'");
	    	 String OtherCutPoint = scanner.next();
	    	try {
	    		cutPoint = Integer.parseInt(OtherCutPoint);
	    	}
	    	catch(Exception e) {
	    		System.out.println("Please enter a valid value; ");
	    		continue;
	    	}
	    	// Check that the cut point is within the valid range for the deck size
	    	if (cutPoint < 1 || cutPoint >= deck.length) {
		        System.out.println("Invalid cut point. Please try again.");
		        continue;
		    }
	    	else {
	    		flag = false;
	    	}
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
	
	public void floorPlacement(String[] deck) {   //Setting 4 card to the floor.
		for (int i = 0; i < 4; i++) {
			floor[i] = deck[deck.length-1-i];
			//System.out.println("Cards on the floor are: "+ floor[i]);
		}
		floorCardsNumber = 4;
		LastFloorCard = floor[3];
		//System.out.println("The Last card on the floor is: "+ LastFloorCard);
		
	}
	
	
	public void dealCards(String[] deck, int round) {	//Deal Cards to user and computer row by row.
		
		int count = 2;
		int UserIndex = 0;
		int ComputerIndex = 0;
		
		for (int i = 1 ; i<= 8 ; i++) {
			if (count % 2 == 0) {
				userCards[UserIndex] = deck[deck.length-4-i-(round-1)*8];
				count++;
				UserIndex++;
			}
			else {
				computerCards[ComputerIndex] = deck[deck.length-4-i-(round-1)*8];
				count++;
				ComputerIndex++;
			}
		}
		
		//By the way this is the second way of deal cards not 1-1 this one is deals 4-4
		
		/*int k = 4*(round-1);							
		for (int i = 4*round; i<(8*round)-k; i++)  {
			userCards[i-4*round] = deck[deck.length-1-i-k];
			computerCards[i-4*round] = deck[deck.length-1-i-4-k];
		}*/
		

		lastIndex = 3;
		insideCounter = 0;
		insideCounter3 = 0;
		computerRandomPlayCounter = 4;
		
	}
	public void organizeComputerCards(String[] computerCards, int i) {		//Organising Computer Cards
		String temp2 = "  ";
		temp2 = computerCards[lastIndex];			
		computerCards[i] = temp2;
		computerCards[lastIndex] = "    ";
		computerRandomPlayCounter --;
		insideCounter3++;
	}
	
public void gameRun() {						
		
	System.out.println("Computer Hand: ");
	for (int i = 0; i < computerCards.length; i++) {
		System.out.println(i+". Card: "+ computerCards[i]);
	}
	System.out.println();
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
		
		System.out.println("Your Cards: ");		//Shows our cards
		for (int i = 0; i < 4-insideCounter ; i++) {
			System.out.println((i+1)+")"+userCards[i]);
		}
		System.out.println();
		
		lastCard[0] = "  ";
		int userChoice = 0;
		boolean flag = true;

		System.out.println("Which one do you want to throw to floor ? Type a number please!");
		while (flag) {
			String OtherUserChoice = scanner.next();
			
			try {
				userChoice = Integer.parseInt(OtherUserChoice);
				
			}
			catch (Exception e) {
				System.out.println(("Please type a valid value!"));
				continue;
				
			}
		
			flag = false;
		}
		if (userChoice > 4-insideCounter || userChoice < 1) {
			System.out.println("Please enter a valid value! ");
			System.out.println();
			return;
		}
		

		lastCard[0] = userCards[userChoice-1];
		
		

		
		if (floorCardsNumber > 0 ) {
			if (lastCard[0].substring(lastCard[0].length()-2,lastCard[0].length()).equals(LastFloorCard.substring(LastFloorCard.length()-2, LastFloorCard.length())))  {  //Checks last 2 index 
				if (floorCardsNumber == 1) {
					//Make a pisti
					setUserPisti(getUserPisti() + 1) ;
					System.out.println("You made a pisti. Bravo!");
					floorCardsNumber = 0;
					LastFloorCard = "    ";
					floor[0] = "  ";
					setLastWin(0);			//Sets last win to user.
				}
				else {
					//Collect all cards from floor.
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
	

				if (floorCardsNumber > 0 && computerTurn) {
					//Checks if computer have a sensible card to play.
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
								floor[floorCardsNumber] = computerCards[i];
								floorCardsNumber ++;
								
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
			
			//Checks Jack's
				
			if (computerTurn && floorCardsNumber > 0) {
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
								floor[floorCardsNumber] = computerCards[i];
								floorCardsNumber ++;
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
						//Check jack's but this is long version.
						
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
			
			//If the computer has not sensible card play randoms.
			if (computerTurn) {
				System.out.println("Computer played.");
				LastFloorCard = computerCards[computerRandomPlay];
				floor[floorCardsNumber] = computerCards[computerRandomPlay];
				floorCardsNumber ++;
				computerTurn = false;
				
				organizeComputerCards(computerCards,computerRandomPlay);
				
			}
			
			//That gives collected user cards
			System.out.println("Collected User Cards: ");
			for (int i = 0 ; i<collectedUserCards.length; i++) {
				if (collectedUserCards[i] == null) {
					continue;
				}else {
					System.out.println(collectedUserCards[i]);
				}
			}
			
			//That gives collected computer cards
			System.out.println("Collected Computer Cards: ");
			for (int i = 0 ; i<collectedComputerCards.length; i++) {
				if (collectedComputerCards[i] == null) {
					continue;
				}else {
					System.out.println(collectedComputerCards[i]);
				}
				
			}
			//Organising User Cards
			
			String temp = "  ";
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


public void collectLastCards(int lastwin) {			//Collecting the last cards by looking at who took the last cards from on the floor.
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
