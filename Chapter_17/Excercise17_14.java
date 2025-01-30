



import javafx.util.*;
import java.io.*;
import java.util.Random;



public class Excercise17_14 {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		File UsedFile = new File("Exercise17_14.dat");
		DataOutputStream output;
		if (UsedFile.exists()) {
			output = new DataOutputStream(new FileOutputStream("Exercise17_14.dat",true));
		}
		else {
			output = new DataOutputStream(new FileOutputStream("Exercise17_14.dat",false));
		}
		Random random = new Random();
		for(int i = 0; i<100; i++) {
			int inttemp = random.nextInt(10);
			byte[] tempByte = ((inttemp+"").getBytes());
			for(int j = 0; j<tempByte.length; j++) {
				tempByte[j]=(byte) (tempByte[j]+5);
			}
			output.write(tempByte);
		}
		
		FileInputStream input = new FileInputStream("Exercise17_14.dat");
	
		byte[] buffer = new byte[1024];
		int bytesRead;
		
		
		while ((bytesRead = input.read(buffer)) != -1) {
            // Process the read bytes in 'buffer'
            for (int i = 0; i < bytesRead; i++) {
                System.out.print((char) (buffer[i]-5));
            }
        }
		System.out.println();
		System.out.print("The sum of the integers is : ");
		
	}
	
}
