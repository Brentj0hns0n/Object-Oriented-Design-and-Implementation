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
 *  Inventory.java is the class of inventory implemented as an arrayList
 *  of Products. 
 */
package Assign2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;
import java.text.DecimalFormat;

public class Inventory extends Product implements Serializable {
	
	private ArrayList<Product> list;
//	private Movie a;
	
	public Inventory(){
		list = new ArrayList<Product>();

		}
	
	/**
	 * This method removes inventory with SKU x from the calling 
	 * inventory.	
	 * @param x
	 */
	public void removeProduct( int x){
		
		int index = findProduct(x);
		if (index == -1)
		{
			System.out.println("That SKU was not found in the inventory");
		}
		else {
			list.remove(index);
			System.out.println("Removed product with SKU: " + x);
		}

	}
	
	/**
	 * This method processes the sale and calculations associated with the sale
	 * of an inventory product.
	 * @param target sku to be removed
	 * @param price  cost to ship
	 * @param quantity number to be shipped
	 */
	public void sellItem(int target, double price, int quantity){
		int index = findProduct(target);
		if (index == -1){
			System.out.println("SKU not found in inventory, try again.");
			return;
		}
		if (quantity > list.get(index).getQuan())
		{
			System.out.println("There are not that many in the inventory, try again");
			return;
		}
		//error check ok, decrease by quantity
		else
			list.get(index).decreaseByQ(quantity);
		double credit = list.get(index).getCredit();
		double commission = list.get(index).getCommission(price);
		System.out.println("Total price: "+ (price-commission));
		System.out.println("Total Shipping Credit: "+ credit);
		System.out.println("Total Commission: "+ commission);
		System.out.println("Total Profit: " + ((price + credit) - (commission + price)));
	}


/**
 * This method displays all the items in the inventory list.
 * @param myList
 */
	public void displayAll(){
		Collections.sort(list);
		DecimalFormat SKUi = new DecimalFormat("0000000000");
		DecimalFormat quantityi = new DecimalFormat("#00000");
		DecimalFormat priced = new DecimalFormat("$#0.00");
		
		//Table
		System.out.println("------SKU--------Quantity---"
							+ "--Price---------Title-------------------");

		 for (int i = 0; i < list.size(); i++)
			{
				System.out.println(i + 1 + ".  " + 
				SKUi.format(list.get(i).getSku()) + "   " +
				quantityi.format(list.get(i).getQuan()) + "        " +
				priced.format(list.get(i).getPrice()) + "         " +
				list.get(i).getTitle() );
			}
		}
	
	/**
	 * This method adds a product to the inventory
	 */
public void addProduct(Inventory newInv){	
	char type = newInv.getProductType();
	//	Product newProduct = new Product();
	//	super.addProduct(newInv);
		if (type == 'm' || type == 'M'){
			Movie newMovie = new Movie();
			newMovie.addProduct(newInv);
			
		}	

		if (type == 'b' || type == 'B'){
			Book newBook = new Book();
			newBook.addProduct(newInv);
		}	
		if (type == 'T' || type == 't'){
			Toy newToy = new Toy();
			newToy.addProduct(newInv);
		}	
		
}
/**
 * this is a helper function that actually appends the new object
 * to the list
 * @param x
 */
	public void addToInventory(Product x) {
		 
		list.add(x);
	 }
	


/**
 * This method returns -1 if the target sku is not found in the list
 * and the index of the item if it is found.
 * @param target  sku to be found
 * @return index of found item or -1
 */
	public int findProduct ( int target){
		for(int i=0; i < list.size(); i++)
		{
			if (list.get(i).getSku()  == target)
			{
				return i;
			}
			
		}
		return -1;
			
	}
	
	/**
	 * this is a helper function that relays the correct object
	 * to the correct class for its displayInfo method
	 * @param x index of product to be displayed.
	 */
	public void displayInfo(int x) { 
		
		Product newProd = list.get(x);
		newProd.displayInfo();		
		
	}
	
}
	