package main;

import java.util.Scanner;

public class GameBegin {
	
	private String username;
	public int lastIndex;
	public int insideCounter;
	public int insideCounter3;
	public int computerRandomPlayCounter;
	
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
		lastIndex = 3;
		insideCounter = 0;
		insideCounter3 = 0;
		computerRandomPlayCounter = 4;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
