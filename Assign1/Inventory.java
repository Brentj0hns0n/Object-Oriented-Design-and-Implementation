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
 *  Inventory.java is the class of inventory implemented as an arrayList
 *  of movies.  Most methods in this class rely on the private members
 *  of the Movie class, so this file is closely associated with Movie.java
 */

import java.util.ArrayList;
import java.io.*;

class Inventory implements Serializable{
	
	private ArrayList<Movie> list;
	private Movie a;
	
	public Inventory(){
		list = new ArrayList<Movie>();
		a = new Movie();				
		//assuming there is at least one movie.  
		//Even if movie is never added, "a" will point to null.
		}
	
	 /*
	  *  This method creates movie a, modifies movie a (with Movie.java)
	  *  then sends the movie to the addToInventory method to add it to 
	  *  the inventory.
	  *  @param s=sku, q= quantity, p = price, t = title
	  */
	public void addMovie(int s, int q, double p, String t) {
		Movie a = new Movie();
		a.addMovie(s, q, p, t);
		 
		this.addToInventory(a);
	 }
	
	 /*
	  *  This method helps addMovie by adding the movie x to the 
	  *  inventory.
	  *  @param Movie x = movie to be added
	  */
	public void addToInventory(Movie x) {
		 
		list.add(x);
	 }

	 /*
	  *  This method helps removeMovie (in Movie.java) by sending it the 
	  *  invoking inventory list (to be searced in Movie class)
	  *  @param  x = index of Movie to be removed
	  */
	public void removeMovie(int x) { 
		
		a.removeMovie(list, x);

	 }
	
	 /*
	  *  This method sends the list and the target sku (x) to 
	  *  Movie.java to be displayed
	  *  @param  x = movie to be displayed
	  */
	public void displayInfo(int x) { 
												
		a.displayInfo(list, x);
		
	}
	
	 /*
	  *  This method sends the list to Movie.java for the entire thing to be displayed
	  *  
	  */
	public void displayAll() {		
		a.displayAll(list);
	}
}
