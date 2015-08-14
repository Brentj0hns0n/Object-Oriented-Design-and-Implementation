/** 
 *  @author BrentJohnson
 *  @author MichaelPeel
 *  @since Date: 7/15/15
 *  @version Assignment 2
 *  Instructor: Jill Seaman
 *  
 *  This program is intended to simulate a DVD rental store by adding,
 *  deleting, searching, and displaying a list of movies. This program
 *  was written to gain experience with java programming.
 *  
 *  Menu.java houses the main class and is intended as a driver for the program.
 */

package Assign2;
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
			System.out.println("1 - Add a Product ");
			System.out.println("2 - Remove a product by SKU (completly "
								+ "remove from inventory)");   
			System.out.println("3 - Display the information for "
								+ "a product (given the SKU)");
			System.out.println("4 - Display the inventory in a table");
			System.out.println("5 - Process a sale of a product");
			System.out.println("6 - Quit");
			
			// User input
			Scanner in = new Scanner(System.in);
			option = in.nextInt();
			
			// Error check for valid input
			if (option > 6 || option <1)		
			{
				System.out.println("Please input a number between 1 and 5: ");
				option = in.nextInt();
			}
			
			//add a product
			if (option == 1){

				myInv.addProduct(myInv);
				
			}
			// remove a movie based on SKU
			if (option == 2){
				System.out.println("Please enter the SKU of the product "
									+ "you would like to remove: ");
				int target = in.nextInt();
				int index = myInv.findProduct(target);
				if (index >= 0)
					myInv.removeProduct(target);
				else
					System.out.println("SKU not found in inventory.");
				
			}
			
			// search for a movie based on it's SKU
			if (option == 3){
				System.out.println("Please enter the SKU of the product "
									+ "you want to know about: ");
				int target = in.nextInt();
				int index = myInv.findProduct(target);
				if (index < 0 ){
					System.out.println("That SKU not found in inventory, try again");
				//	break;
				}
				else{
					myInv.displayInfo(index);
				}
				
				
				//myInv.getProductType().displayInfo();
			}
			
			// display all movies in a table
			if (option == 4){
				myInv.displayAll();
			}
			if (option == 5)
			{
				System.out.println("Please enter the SKU of the item to be sold: ");
				int target = in.nextInt();
				System.out.println("Please enter the number of items you would like to remove.");
				int q = in.nextInt();
				System.out.println("Please enter the cost to ship the items.");
				double price = in.nextDouble();
				myInv.sellItem(target, price, q);
				

			}
		}while (option != 6);		
		 {
			
		//Quit and write the contents of the table to a file named myInventory
		
		try{
	         FileOutputStream fos= new FileOutputStream("myInventory");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(myInv);
	         
	         // Close output streams
	         oos.close();
	         fos.close();
	         
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	    	   System.out.println("io exception at the bottom");
	        }
		System.out.println("bye bye");
				
		
	}
	}
}

