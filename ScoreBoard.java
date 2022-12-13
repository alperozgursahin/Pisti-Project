package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreBoard {
	
	
	 public void scoreWriter(int score, String name) {
		  

		 /* int min = 1000;
		  int[] scores = new int[9];
		  for (int i = 0 ; i<scores.length; i++) {
			  if (scores[i] < min) {
				  min = scores[i];
			  }
		  }*/
		 
		  File file = new File("C:\\Users\\alper\\Desktop\\PistiProject\\SE-115-Project\\Scores.txt");
		  try {
			FileWriter writer = new FileWriter(file);
			writer.append(name+"'s score is: "+score);
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  }



