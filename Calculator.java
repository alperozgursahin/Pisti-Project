package main;

public class Calculator {
	private static int userScore;
	private static int computerScore;
	private static int userPisti;
	private static int computerPisti;
	private String[] collectedUserCards;
	private String[] collectedComputerCards;
	
	
	public int getUserScore() {
		return userScore;
	}
	public int getComputerScore() {
		return computerScore;
	}
	
	
	
	public void calculator(String[] collectedUserCards, String[] collectedComputerCards) {
		
		Deck deck = new Deck();
		userPisti = deck.getUserPisti();
		computerPisti = deck.getComputerPisti();
				
		
		int userDiamonds10 = 0;
		int computerDiamonds10 = 0;
		int userClubs2 = 0;
		int computerClubs2 = 0;
		int userAce = 0;
		int computerAce = 0;
		int userJack = 0;
		int computerJack = 0;
		
		for (int i = 0; i < collectedUserCards.length; i++) {			//Changes index null to empty String.
			if (collectedUserCards[i] == (null)) {
				collectedUserCards[i] = "  ";
			}
			
		}
		
		for (int i = 0; i < collectedComputerCards.length; i++) {		//Changes index null to empty String.
			if (collectedComputerCards[i]== null) {
				collectedComputerCards[i] = "  ";
			}
			
		}
		
		
		for (int i = 0; i<collectedUserCards.length; i++ ) {			
			if (collectedUserCards[i].equals("Diamonds 10")) {
				userDiamonds10 ++;
			}
			if (collectedUserCards[i].equals("Clubs 2")) {
				userClubs2 ++;
			}
			if (collectedUserCards[i].equals("Clubs Ace") || collectedUserCards[i].equals("Spades Ace") || collectedUserCards[i].equals("Diamonds Ace") || collectedUserCards[i].equals("Hearts Ace")) {
				userAce ++;
			}
			if (collectedUserCards[i].equals("Clubs Jack") || collectedUserCards[i].equals("Spades Jack") || collectedUserCards[i].equals("Diamonds Jack") || collectedUserCards[i].equals("Hearts Jack")) {
				userJack ++;
			}
			
		}
		for (int i = 0; i<collectedComputerCards.length; i++ ) {
			if (collectedComputerCards[i].equals("Diamonds 10")) {
				computerDiamonds10 ++;
			}
			if (collectedComputerCards[i].equals("Clubs 2")) {
				computerClubs2 ++;
			}
			if (collectedComputerCards[i].equals("Clubs Ace") || collectedComputerCards[i].equals("Spades Ace") || collectedComputerCards[i].equals("Diamonds Ace") || collectedComputerCards[i].equals("Hearts Ace")) {
				computerAce ++;
			}
			if (collectedComputerCards[i].equals("Clubs Jack") || collectedComputerCards[i].equals("Spades Jack") || collectedComputerCards[i].equals("Diamonds Jack") || collectedComputerCards[i].equals("Hearts Jack")) {
				computerJack ++;
			}
			
		}
		
		//SCORING
		
		if (collectedUserCards.length > collectedComputerCards.length) {
			userScore +=3;
		}
		if (collectedComputerCards.length > collectedUserCards.length) {
			computerScore +=3;
		}
		
		if (userPisti>0) {					//Checks User's Pisti Score
			userScore += userPisti*10;
		}
		if (computerPisti>0) {				//Checks Computer's Pisti Score
			computerScore += computerPisti*10;
		}
		
		
		
		
		if (userDiamonds10 > 0 ) {
			userScore += 3;
		}
		if (computerDiamonds10 > 0 ) {
			computerScore += 3;
		}
		if (userClubs2 > 0) {
			userScore += 2;
		}
		if (computerClubs2 > 0) {
			computerScore += 2;
		}
		
		int userCardsLength = 0;
		int computerCardsLength = 0;
		
		for (int i = 0; i < collectedUserCards.length ; i++) {
			if (collectedUserCards[i].equals("  ")) {
				break;
			}
				userCardsLength ++;
		}
		for (int i = 0; i < collectedComputerCards.length ; i++) {
			if (collectedComputerCards[i].equals("  ")) {
				break;
			}
			
				computerCardsLength ++;
			
		}
		
		
		for (int i = 0 ; i < userCardsLength - userDiamonds10 - userClubs2   ; i++) {		//Increase score 1 for every normal card
			userScore += 1;
		}
		for (int i = 0 ; i < computerCardsLength - computerDiamonds10 - computerClubs2 ; i++) {		//Increase score 1 for every normal card
			computerScore += 1;
			
		}
		
		/*if (userAce >0) {				//Other pisti scoring.
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
		}*/
		
		//System.out.println("User Score is: "+userScore+" Computer Score is: "+computerScore);
		if (userScore == computerScore) {
			System.out.println("DRAW!");
		}
		else if (userScore > computerScore) {
			System.out.println("User win!");
		}
		else {
			System.out.println("Computer win!");
			
		}
		
		
		System.out.println("User Cards: ");
		for (int i = 0; i<collectedUserCards.length; i++) {
			if (collectedUserCards[i].equals("  ")) {
				continue;
			}
			System.out.println(collectedUserCards[i]);
		}
		System.out.println("User's Pisti: "+userPisti);
		
		System.out.println("Computer Cards:");
		for (int i = 0; i<collectedComputerCards.length; i++) {
			if (collectedComputerCards[i].equals("  ")) {
				continue;
			}
			System.out.println(collectedComputerCards[i]);
		}
		System.out.println("Computer's Pisti: "+computerPisti);
	}
	public String[] getCollectedUserCards() {
		return collectedUserCards;
	}
	public void setCollectedUserCards(String[] collectedUserCards) {
		this.collectedUserCards = collectedUserCards;
	}
	public String[] getCollectedComputerCards() {
		return collectedComputerCards;
	}
	public void setCollectedComputerCards(String[] collectedComputerCards) {
		this.collectedComputerCards = collectedComputerCards;
	}
	public int winnerScore() {
		int score = 0;
		
		if (userScore > computerScore) {
			score = userScore;
		}
		if (computerScore > userScore ) {
			score = computerScore;
		}
		if (userScore == computerScore) {
			score = userScore;
		}
		return score;
		
	}
	
}


