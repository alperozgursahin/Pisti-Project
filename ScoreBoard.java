package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;


public class ScoreBoard {
	
	private String name;
	private String score;
	private String[] userScores = new String[10];
	

	 public void scoreWriter(String score, String name) {
		 this.setName(name);
		 this.setScore(score);
		 
		 int counter = 0;
		 
			 try {
					Scanner scanner = new Scanner(new File("C:\\Users\\alper\\Desktop\\PistiProject\\SE-115-Project\\Scores.txt"));

					while (scanner.hasNextLine()) {
						userScores[counter] = scanner.nextLine();
						counter++;
					}

					scanner.close();
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
			 
		String temp = null;
		//Sort User Scores
		for (int i = 0; i<userScores.length;i++ ) {
			if (userScores[i] == null) {
				break;
			}
			for (int j = i+1; j<userScores.length; j++) {
				if(userScores[j] == null) {
					break;
				}
				 if (Integer.parseInt(userScores[i].substring(userScores[i].length()-3, userScores[i].length())) < Integer.parseInt(userScores[j].substring(userScores[j].length()-3, userScores[j].length()))) {
					 temp = userScores[i];
					 userScores[i] = userScores[j];
					 userScores[j] = temp;
					 
				 }
			}
		}
			 
		 deleteWords();
		 
		 boolean isItFull = true;
		 
		 for (int i = 0; i<userScores.length; i++) {
			 if (userScores[i] == null) {
				 userScores[i] = "Name: "+ getName() +"| Score: "+ getScore() ;
				 isItFull = false;
				 if(i==10) {
					 isItFull = true;
				 }
				 break;
			 }
		 }
		 
		 for (int i = 0; i<userScores.length;i++ ) {
			 if(userScores[i] == null) {
				 break;
			 }
				for (int j = i+1; j<userScores.length; j++) {
					if(userScores[j] == null) {
						break;
					}
					 if (Integer.parseInt(userScores[i].substring(userScores[i].length()-3, userScores[i].length())) < Integer.parseInt(userScores[j].substring(userScores[j].length()-3, userScores[j].length()))) {
						 temp = userScores[i];
						 userScores[i] = userScores[j];
						 userScores[j] = temp;
						 
					 }
				}
			}
		 
		 if (isItFull) {
			 userScores[9] =  "Name: "+ getName() +"| Score: "+ getScore();
		 }
		 
		 for (int i = 0; i<userScores.length;i++ ) {
			 if (userScores[i] == null) {
				 break;
			 }
				for (int j = i+1; j<userScores.length; j++) {
					 if (userScores[j] == null) {
						 break;
					 }
					 if (Integer.parseInt(userScores[i].substring(userScores[i].length()-3, userScores[i].length())) < Integer.parseInt(userScores[j].substring(userScores[j].length()-3, userScores[j].length()))) {
						 temp = userScores[i];
						 userScores[i] = userScores[j];
						 userScores[j] = temp;
						 
					 }
				}
			}
		 
		 
		 /*for (int i = 0; i<userScores.length; i++) {
			 if (userScores[i] == null) {
				 isItFull = false;
				 userScores[i] = "Name: "+ getName() +"| Score: "+ getScore() ;
				 for (int j = i+1 ; j<= userScores.length; j++) {
					 if (userScores[j-1] == null) {
						 break;
					 }
					 else {
						 try {
							 if (Integer.parseInt(userScores[i].substring(userScores[i].length()-3, userScores[i].length())) < Integer.parseInt(userScores[j].substring(userScores[j].length()-3, userScores[j].length()))) {
								 temp = userScores[i];
								 userScores[i] = userScores[j];
								 userScores[j] = temp;
								 
							 }
							 
						 }
						 catch (Exception e) {
							 
						 }
					 }
					
				 }
				 
			 }
			 
			 
		 }
		 if (isItFull) {
			 for (int i = 0; i <userScores.length; i++) {
				 if (Integer.parseInt(userScores[i].substring(userScores[i].length()-3, userScores[i].length())) < Integer.parseInt(score)) {
					 userScores[i] = "Name: "+ getName() +"| Score: "+ getScore()+"\n";
					 for (int j = i+1; j<=userScores.length; j++) {
						 try {
							 temp = userScores[i];
							 userScores[i] = userScores[j];
							 userScores[j] = temp;
						 }
						 catch (Exception e ) {
							 continue;
						 }
						 
						 
					 }
	
				 }
			 }
		 }*/
		 
		 
		 Formatter f = null;
		 FileWriter fw = null;
		 try {
			 
			 fw = new FileWriter ("C:\\Users\\alper\\Desktop\\PistiProject\\SE-115-Project\\Scores.txt" , true);
			 f = new Formatter (fw);
			 for (int i = 0; i<userScores.length;i++) {
				 if (userScores[i] == null) {
					 break;
				 }else {
					 f.format(userScores[i]+"\n");
				 }
				 
			 }
			 
			 fw. close();
		 } catch (Exception e) {
		 System.err.println("Something went wrong." );
		 } finally {
		 if (f != null) {
		 f. close();
		 }
	 }
	 
	

}
	 
		  public static void deleteWords() {
			  
		    // Create a File object representing the text file you want to modify
		    File file = new File("C:\\Users\\alper\\Desktop\\PistiProject\\SE-115-Project\\Scores.txt");
		    
		    // Create a PrintWriter object to write to the text file
		    PrintWriter writer = null;
			try {
				writer = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    // Write an empty string to the text file, effectively deleting all the words
		    writer.print("");
		    
		    // Close the PrintWriter object
		    writer.close();
		  }
		
	
	public void getUserScores() {
		for (int i = 0; i<userScores.length; i++) {
			System.out.println(userScores[i]);
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}


}
