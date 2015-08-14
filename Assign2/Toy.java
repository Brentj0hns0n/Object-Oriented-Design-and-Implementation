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
 *  Toy.java houses the serializable Toy class as well as the methods
 *  and fields for navigating the menu.
 */
package Assign2;
import java.io.*;
import java.util.Scanner;

public class Toy extends Product implements Serializable {

	private double weight;
	
	public Toy(){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the weight of the toy (in ounces):  ");
		weight = in.nextDouble();
		

	}
	/**
	 * THis method returns the shipping credit of a Toy object
	 * @return
	 */
	public double getCredit(){
		double pounds = (weight/16);
		return (4.49 + (.5*pounds));
	}
	
	/**
	 * This method return the commission of a Toy object
	 * @param price
	 * @return
	 */
	public double getCommission(double price){
		return (price * .15);
	}
	
	/**
	 * This method displays the info for a toy object.
	 */
	public void displayInfo() { 
		
		System.out.println("SKU: " + this.getSku());
		System.out.println("quantity: " + this.getQuan());
		System.out.println("price: " + this.getPrice());
		System.out.println("SKu: " + this.getSku());
		System.out.println("weight: " + weight + "ounces");
		
	}

}