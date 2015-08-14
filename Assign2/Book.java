
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
 *  Book.java houses the serializable Book class as well as the methods
 *  and fields for navigating the menu.
 */
package Assign2;
import java.io.Serializable;
import java.util.Scanner;

/**
 * User enters book information based on initial user input
 *
 */

public class Book extends Product implements Serializable{

	private int isbn;
	private String author;
	public Book (){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an isbn for the book:  ");
		isbn = in.nextInt();
		System.out.println("Please enter the Author's name:  ");
		in.nextLine();
		author = in.nextLine();
	}
	
	/**
	 * This method returns the shipping credit for a book object
	 */
	public double getCredit(){
		return 3.99;
	}
	
	/**
	 * This method returns the commission for a book object
	 */
	public double getCommission(double price){
		return (price * .15);
	}
	
	/**
	 * This method displays the field of the calling book object
	 */
	public void displayInfo() { 
		
		System.out.println("SKU: " + this.getSku());
		System.out.println("quantity: " + this.getQuan());
		System.out.println("price: " + this.getPrice());
		System.out.println("SKu: " + this.getSku());
		System.out.println("ISBN: " + isbn);
		System.out.println("Author: " + author);				
	}
}
	
	