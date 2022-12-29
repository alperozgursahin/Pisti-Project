package main;

import java.util.Scanner;

public class GameBegin {
	
	private String username;
	private int lastIndex;
	private int insideCounter;
	private int cpPlayedCardNumber;
	private int computerRandomPlayCounter;
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	public GameBegin() {
		// TODO Auto-generated constructor stub
	}

	public void getUserName() {
		
		System.out.println("What is your name?: ");
		username = scanner.next();
		
	}

	public void begin(int round) {
		System.out.println("Round "+round);
		System.out.println("✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤✤");
		setLastIndex(3);
		setInsideCounter(0);
		setCpPlayedCardNumber(0);
		setComputerRandomPlayCounter(4);
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getInsideCounter() {
		return insideCounter;
	}

	public void setInsideCounter(int insideCounter) {
		this.insideCounter = insideCounter;
	}

	public int getCpPlayedCardNumber() {
		return cpPlayedCardNumber;
	}

	public void setCpPlayedCardNumber(int cpPlayedCardNumber) {
		this.cpPlayedCardNumber = cpPlayedCardNumber;
	}

	public int getComputerRandomPlayCounter() {
		return computerRandomPlayCounter;
	}

	public void setComputerRandomPlayCounter(int computerRandomPlayCounter) {
		this.computerRandomPlayCounter = computerRandomPlayCounter;
	}
	
	
}
