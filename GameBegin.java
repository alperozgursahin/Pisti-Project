package main;

public class GameBegin {
	
	
	
	private int round;
	
	public GameBegin(int round) {
		this.round = round;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	public void begin() {
		System.out.println("Round "+getRound());
		System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
	}
	
	
}
