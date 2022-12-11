package main;

public class GameEnd {
	private int userScore;
	private int computerScore;
	
	public GameEnd(int userScore, int computerScore) {
		this.setUserScore(userScore);
		this.setComputerScore(computerScore);
		
	}
	
	
	
	public void scoreBoard(int userScore, int computerScore) {
		System.out.println("          U̲S̲E̲R̲ ̲S̲C̲O̲R̲E̲          C̲O̲M̲P̲U̲T̲E̲R̲ S̲C̲O̲R̲E̲");
		System.out.println("              "+userScore+"                      "+computerScore
				);
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
