



import javafx.util.*;
import java.io.*;
import java.util.Random;



public class Excercise17_01 {
	
	
	
	public static void main(String[] args) throws IOException {
		try(RandomAccessFile raf = new RandomAccessFile("Exercise17_01.txt", "rw");){
			raf.setLength(0);
			Random random = new Random();
			for(int i = 0; i<100; i++) {
				raf.writeInt(random.nextInt(10));
			}
		}
		
	}
	
}

