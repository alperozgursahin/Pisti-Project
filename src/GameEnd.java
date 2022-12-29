package main;

public class GameEnd {
	private int userScore;
	private int computerScore;

	public void scoreBoard(int userScore, int computerScore) {
		System.out.println();
		System.out.println("USER SCORE  ||  COMPUTER SCORE");
		System.out.println("    "+userScore+"                 "+computerScore
				);
		System.out.println();
	}
	public int getUserScore() {
		return userScore;
	}
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}
	public int getComputerScore() {
		return computerScore;
	}
	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
	}
	

}
