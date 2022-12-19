package main;


public class Main {
	
	public static int round = 1;
	public static int running = 1;
	
	public static int lastIndex;
	public static int insideCounter;
	public static int computerRandomPlayCounter;
	public static int insideCounter3;
	
	public static void main(String[] args) {
		
		
		Deck deck = new Deck();
		String[] deck1 = deck.DeckOfCard();
		
		Calculator calculator = new Calculator();
		GameEnd gameEnd = new GameEnd();
		GameBegin gameBegin = new GameBegin();
		ScoreBoard scoreBoard = new ScoreBoard();
		
		
		gameBegin.getUserName();
		deck.ShuffleCards(deck1);
		deck.cutDeck(deck1);
		deck.floorPlacement(deck1);
		
		
		while (round < 7) {
			
			gameBegin.begin(round);
			deck.dealCards(deck1, round);

			while (running < 5) {

				deck.gameRun();
				running++;

			}
			round++;
			running = 1;
			
		}
		deck.collectLastCards(deck.getLastWin());
		calculator.calculator(deck.getCollectedUserCards(), deck.getCollectedComputerCards());
		gameEnd.scoreBoard(calculator.getUserScore(),calculator.getComputerScore());
		
		if (calculator.getUserScore() > calculator.getComputerScore()) {
			scoreBoard.scoreWriter(calculator.winnerScore(), gameBegin.getUsername());
		}
		
		
		

	}
	
	
	

}
