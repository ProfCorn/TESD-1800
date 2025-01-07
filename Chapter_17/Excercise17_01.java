



import javafx.util.*;
import java.io.*;
import java.util.Random;



public class Excercise17_1 {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		File UsedFile = new File("Exercise17_01.txt");
		if (UsedFile.exists()) {
			
		}
		FileOutputStream output = new FileOutputStream(UsedFile);
		Random random = new Random();
		for(int i = 0; i<100; i++) {
			output.write(random.nextInt(10));
		}
		
		FileInputStream input = new FileInputStream("Exercise17_01.txt");
	
		int value;
		
		while ((value = input.read()) != -1) {
			System.out.print(value + " ");
		}
	}
	
}

