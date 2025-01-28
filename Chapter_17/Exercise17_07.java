/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            outputData();
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
    
    public static void outputData() {
    	double totalLoanAmount = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"))) {

            while (true) {

                Loan data = (Loan)inputStream.readObject(); // May throw EOFException

                totalLoanAmount = totalLoanAmount + data.getLoanAmount();
                
                
                System.out.print("Added "+data.getLoanAmount()+" to total loan amount");
                

                // Process read data

            }

        } catch (EOFException e) {

            System.out.println("Reached end of file"); // Handle the exception gracefully

        } catch (IOException ex) {
            System.out.println("File could not be opened");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
}
