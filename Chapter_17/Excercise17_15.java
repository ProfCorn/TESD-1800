



import javafx.util.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;



public class Excercise17_15 {
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Input file name for file you would like to encrypt: ");
		String OldFileName = input.next();
		System.out.println("Input what you would like to name the encrypted file: ");
		String NewFileName = input.next();
		
		FileInputStream inputStream = new FileInputStream(OldFileName);
		
		File UsedFile = new File(NewFileName);
		
		FileOutputStream output;
		if (UsedFile.exists()) {
			output = new FileOutputStream(NewFileName,true);
		}
		else {
			output = new FileOutputStream(NewFileName,false);
		}
		
		byte[] buffer = new byte[1024];
		int bytesRead;
		
		
		while ((bytesRead = inputStream.read(buffer)) != -1) {
            // Process the read bytes in 'buffer'
            for (int i = 0; i < bytesRead; i++) {
            	
            	byte tempData = buffer[i];
    			byte[] tempByte = ((tempData+"").getBytes());
    			for(int j = 0; j<tempByte.length; j++) {
    				tempByte[j]=(byte) (tempByte[j]);
    				System.out.println((char) tempByte[j]);
    			}
    			output.write(tempByte);
    			
            }
        }
		
		
		
		
		
		
		/*
		 * Decryption prosses
		 *
		FileInputStream inputStream = new FileInputStream("Exercise17_14.dat");
	
		byte[] buffer = new byte[1024];
		int bytesRead;
		
		
		while ((bytesRead = inputStream.read(buffer)) != -1) {
            // Process the read bytes in 'buffer'
            for (int i = 0; i < bytesRead; i++) {
                System.out.print((char) (buffer[i]-5));
            }
        }
		 */	
	}
	
}
