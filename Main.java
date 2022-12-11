package main;

public class Main {
	
	public static int round = 1;
	public static int running = 1;
	public static boolean computerTurn;
	public static int lastIndex;
	public static int insideCounter;
	public static int computerRandomPlayCounter;
	public static int insideCounter3;
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Calculator calculator = new Calculator(deck.getCollectedUserCards(), deck.getCollectedComputerCards());
		String[] deck1 = deck.DeckOfCard();
		GameEnd gameEnd = new GameEnd(calculator.getUserScore(),calculator.getComputerScore());
		//GameProgress gameProgress = new GameProgress();
		//GameBegin gameBegin = new GameBegin(round);
		
		deck.ShuffleCards(deck1);
		deck.cutDeck(deck1);
		deck.floorPlacement(deck1);
		
		
		while (round < 7) {
			
			GameBegin gameBegin = new GameBegin(round);
			gameBegin.begin();
			deck.dealCards(deck1, round);
			computerTurn = false;
			lastIndex = 3;
			insideCounter = 0;
			insideCounter3 = 0;
			computerRandomPlayCounter = 4;
			
			
			while (running < 5) {
				
				deck.gameRun();
				running++;

			}
			round++;
			running = 1;
			
		}
		calculator.calculator(deck.getCollectedUserCards(), deck.getCollectedComputerCards());
		gameEnd.scoreBoard(calculator.getUserScore(),calculator.getComputerScore());
		
		
		

	}
	
	
	

}
