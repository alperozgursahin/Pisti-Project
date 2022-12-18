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
		Calculator calculator = new Calculator();
		String[] deck1 = deck.DeckOfCard();
		GameEnd gameEnd = new GameEnd();
		GameBegin gameBegin = new GameBegin();
		ScoreBoard scoreBoard = new ScoreBoard();
		//GameProgress gameProgress = new GameProgress();
		//GameBegin gameBegin = new GameBegin(round);
		
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
		
		scoreBoard.scoreWriter(calculator.winnerScore(), gameBegin.getUsername());
		
		
		
		

	}
	
	
	

}
