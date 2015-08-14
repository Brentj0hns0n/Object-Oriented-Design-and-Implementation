/** 
 *  @author BrentJohnson
 *  @author MichaelPeel
 *  @since Date: 7/9/15
 *  @version Assignment 1
 *  Instructor: Jill Seaman
 *  
 *  This program is intended to simulate a DVD rental store by adding,
 *  deleting, searching, and displaying a list of movies. This program
 *  was written to gain experience with java programming.
 *  
*/

import java.util.Scanner;
import java.io.*;

/**
*  Menu.java houses the main driver class that drives the program and 
*  takes input/delivers output to the user. 
*/

public class Menu implements Serializable{
 
	public static void main(String[] args){
		
		int option; // for the users input
		
		Inventory myInv = new Inventory(); // reference to Inventory class
		
		try{
			// the file will be made if it doesn't exist, 
			// catch is empty because there is no error
			// catch block only prevents runtime error on first run.
			FileInputStream fis = new FileInputStream("myInventory"); 
			
			ObjectInputStream ois = new ObjectInputStream(fis);			

			myInv = (Inventory)ois.readObject();
			ois.close();
			// catch is empty
			} catch (IOException ioe){}
		
		catch (ClassNotFoundException e){
			System.out.println("Class not found error on file load.");
		}

		// Output menu for user input
		do {
			System.out.println("Please choose from one of the "
								+ "following menu options: ");
			System.out.println("1 - Add a movie");
			System.out.println("2 - Remove a movie by SKU (completly "
								+ "remove from inventory)");   
			System.out.println("3 - Display the information for "
								+ "a movie (given the SKU)");
			System.out.println("4 - Display the inventory in a table");
			System.out.println("5 - Quit");
			
			// User input
			Scanner in = new Scanner(System.in);
			option = in.nextInt();
			
			// Error check for valid input
			while (option > 5 || option <1)		
			{
				System.out.println("Please input a number between 1 and 5: ");
				option = in.nextInt();
			}
			
			//add a movie
			if (option == 1){
				
				 System.out.println("Please enter the SKU of the "
				 					+ "movie you would like to add: ");
				 int s = in.nextInt();
				 System.out.println("Please enter the quantity: ");
				 int q = in.nextInt();				 
				 System.out.println("Please enter the price: ");
				 double p = in.nextDouble();				 
				 System.out.println("Please enter the title: ");
				 in.nextLine();
				 String t = in.nextLine();	
				 myInv.addMovie(s, q, p, t);
			}
			
			// remove a movie based on SKU
			if (option == 2){
				System.out.println("Please enter the SKU of the movie "
									+ "you would like to remove: ");
				int target = in.nextInt();
				myInv.removeMovie(target);
			}
			
			// search for a movie based on it's SKU
			if (option == 3){
				System.out.println("Please enter the SKU of the movie "
									+ "you want to know about: ");
				int target = in.nextInt();
				myInv.displayInfo(target);
			}
			
			// display all movies in a table
			if (option == 4){
				myInv.displayAll();
			}
			
			}
		
		//Quit and write the contents of the table to a file named myInventory
		while (option != 5);
		
		try{
	         FileOutputStream fos= new FileOutputStream("myInventory");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(myInv);
	         
	         // Close output streams
	         oos.close();
	         fos.close();
	         
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	    	   System.out.println("io exception at the bottom, dummy");
	        }
		System.out.println("bye bye");
				
		
	}
}