package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;


public class ScoreBoard {
	
	private String name;
	private int score;
	
	

	 public void scoreWriter(int score, String name) {
		 this.setName(name);
		 this.setScore(score);

		 
		 Formatter f = null;
		 FileWriter fw = null;
		 try {
			 
			 fw = new FileWriter ("C:\\Users\\alper\\Desktop\\PistiProject\\SE-115-Project\\Scores.txt" , true);
			 f = new Formatter (fw);
		
			 f. format("\n" + "Name: "+ getName() +"| Score: "+ getScore() );
			 fw. close();
		 } catch (Exception e) {
		 System.err.println("Something went wrong." );
		 } finally {
		 if (f != null) {
		 f. close();
		 }
	 }
	 
	

}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
