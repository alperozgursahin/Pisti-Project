package main;

public class Calculator {
	private static int userScore;
	private static int computerScore;
	private static int userPisti;
	private static int computerPisti;
	private  String[] collectedUserCards;
	private String[] collectedComputerCards;
	public Calculator(String[] collectedUserCards, String[] collectedComputerCards) {
		this.collectedUserCards = collectedUserCards;
		this.collectedComputerCards = collectedComputerCards;
	}
	public int getUserScore() {
		return userScore;
	}
	public int getComputerScore() {
		return computerScore;
	}

	public void calculator(String[] collectedUserCards, String[] collectedComputerCards) {

		int userDiamonds10 = 0;
		int computerDiamonds10 = 0;
		int userClubs2 = 0;
		int computerClubs2 = 0;
		int userAce = 0;
		int computerAce = 0;
		int userJack = 0;
		int computerJack = 0;
		
		for (int i = 0; i < collectedUserCards.length; i++) {
			if (collectedUserCards[i] == (null)) {
				collectedUserCards[i] = "  ";
			}
			
		}
		
		for (int i = 0; i < collectedComputerCards.length; i++) {
			if (collectedComputerCards[i]== null) {
				collectedComputerCards[i] = "  ";
			}
			
		}
		
		if (collectedUserCards.length > collectedComputerCards.length) {
			userScore +=3;
		}
		else if (collectedComputerCards.length > collectedUserCards.length) {
			computerScore +=3;
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
		if (userDiamonds10 > 0 ) {
			userScore += 10;
		}
		if (computerDiamonds10 > 0 ) {
			computerScore += 10;
		}
		if (userClubs2 > 0) {
			userScore += 2;
		}
		if (computerClubs2 > 0) {
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
	}
}


