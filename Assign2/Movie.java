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
 *  Movie.java houses the serializable Movie class as well as the methods
 *  and fields for navigating the menu.
 */
package Assign2;
import java.util.Scanner;
import java.io.*;

public class Movie extends Product implements Serializable {
	
	private int UPC;
	public Movie (){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a UPC for the movie:  ");
		UPC = in.nextInt();
	}
	
	/**
	 * This method returns the credit for a Movie object
	 */		 
	public double getCredit(){
		return 2.98;
	}
	
	/**
	 * This method returns the commission for a Movie object
	 */	
	public double getCommission(double price){
		return (price * .12);
	}	
	
	/**
	 * This method displays the info for a Movie object
	 */	
	public void displayInfo() { 
		
		System.out.println("SKU: " + this.getSku());
		System.out.println("quantity: " + this.getQuan());
		System.out.println("price: " + this.getPrice());
		System.out.println("SKu: " + this.getSku());
		System.out.println("UPC: " + UPC);
		
	}
}