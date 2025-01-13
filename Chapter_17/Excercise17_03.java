



import javafx.util.*;
import java.io.*;
import java.util.Random;



public class Excercise17_03 {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		File UsedFile = new File("Exercise17_03.txt");
		DataOutputStream output;
		if (UsedFile.exists()) {
			output = new DataOutputStream(new FileOutputStream("Exercise17_03.txt",true));
		}
		else {
			output = new DataOutputStream(new FileOutputStream("Exercise17_03.txt",false));
		}
		Random random = new Random();
		for(int i = 0; i<100; i++) {
			int inttemp = random.nextInt(10);
			output.writeInt((inttemp));
			output.writeChars(" ");
		}
		
		FileInputStream input = new FileInputStream("Exercise17_03.txt");
	
		
		
		int value;
		int wait = 0;
		int totalValue = 0;
		value = input.read();
		value = input.read();
		value = input.read();
		while ((value = input.read()) != -1) {
			if(value==32) {
				System.out.print(" ");
				value = input.read();
				value = input.read();
				wait=1;
			}
			else if (wait !=1){
				System.out.print(value);
				totalValue = totalValue + value;
				value = input.read();
				
			}
			else {
				wait = 0;
			}
		}
		System.out.println();
		System.out.print("The sum of the integers is : "+ totalValue);
		
	}
	
}
