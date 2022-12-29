package main;


public class Main {
	
	private static int round = 1;
	
	public static void main(String[] args) {

		Deck deck = new Deck();
		String[] deck1 = deck.DeckOfCard();
		
		Calculator calculator = new Calculator();
		GameBegin gameBegin = new GameBegin();
		GameEnd gameEnd = new GameEnd();
		ScoreBoard scoreBoard = new ScoreBoard();
			
		gameBegin.getUserName();
		deck.ShuffleCards(deck1);
		deck.cutDeck(deck1);
		deck.floorPlacement(deck1);
		
		while (round < 7) {
			
			gameBegin.begin(round);
			deck.dealCards(deck1, round);

			while (deck.getRunning() < 5) {

				deck.gameRun();

			}
			round++;
			deck.setRunning(1);
			
		}
		deck.collectLastCards(deck.getLastWin());
		calculator.calculator(deck.getCollectedUserCards(), deck.getCollectedComputerCards());
		gameEnd.scoreBoard(calculator.getUserScore(),calculator.getComputerScore());
		
		scoreBoard.scoreWriter(calculator.userScore(), gameBegin.getUsername());
		scoreBoard.getUserScores();

	}

}
