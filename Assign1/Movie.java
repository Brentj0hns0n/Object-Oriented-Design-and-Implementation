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
 *  Movie.java houses the serializable Movie class as well as the methods
 *  for navigating the menu.
 */

import java.util.ArrayList;
import java.text.*;
import java.io.*;

public class Movie implements Serializable {

	 private int SKU;
	 private int quantity;
	 private double price;
	 private String title;
	 
	 /**
	  *  This method displays the movie info of sku x if it
	  *  is contained in the list.
	  * @param ArrayList of Movies to be searched
	  * @param x is the target sku to search for
	  */
	 public void displayInfo(ArrayList<Movie> list, int x) {
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i).SKU == x)
				{
					System.out.println("SKU : "+list.get(i).SKU);
					System.out.println("quantity : "+list.get(i).quantity);
					System.out.println("price : $"+list.get(i).price);
					System.out.println("title : "+list.get(i).title);
				}
			}
		 }

	 /*
	  *  This method sets the fields of the calling movie object to the 
	  *  corresponding arguments passed in (usually from main).
	  *  @param s = sku, q = quantity, p= price, t = title
	  */
	 public void addMovie(int s, int q, double p, String t) {
		 
		 this.SKU = s;
		 this.quantity = q;
		 this.price = p;
		 this.title = t;	
	 }
	 
	 /*
	  *  This method removes the movie from the list if it is found in 
	  *  the list.
	  *  @param list = inventory to be modified, x = target sku
	  */
	 public void removeMovie(ArrayList<Movie> list, int x) { 
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i).SKU == x)
				{
					list.remove(i);
				}
			}
		 }
	 
	 /*
	  *  This method displays all of the movies in the list under a table
	  *  with headers and all fields displayed.
	  *  @param list = inventory to be displayed
	  */
	 public void displayAll(ArrayList<Movie> list) {	
		
		DecimalFormat SKUi = new DecimalFormat("0000000000");
		DecimalFormat quantityi = new DecimalFormat("#00000");
		DecimalFormat priced = new DecimalFormat("$#0.00");
		
		//Table
		System.out.println("------SKU--------Quantity---"
							+ "--Price---------Title-------------------");
		
		 for (int i = 0; i < list.size(); i++)
			{
				System.out.println(i + 1 + ".  " + 
				SKUi.format(list.get(i).SKU) + "   " +
				quantityi.format(list.get(i).quantity) + "        " +
				priced.format(list.get(i).price) + "         " +
				list.get(i).title );
			}
		}
	

}