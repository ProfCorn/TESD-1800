



import javafx.util.*;
import java.io.*;
import java.util.Random;



public class Excercise17_01 {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		File UsedFile = new File("Exercise17_01.txt");
		FileOutputStream output;
		if (UsedFile.exists()) {
			 output = new FileOutputStream(UsedFile, true);
		}
		else {
			 output = new FileOutputStream(UsedFile, false);	
		}
		Random random = new Random();
		for(int i = 0; i<100; i++) {
			int inttemp = random.nextInt(10);
			output.write((inttemp+" ").getBytes());
		}
		
		
	}
	
}
