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
 *  Product.java houses the serializable abstract, superclass Product as well as the methods
 *  and fields for navigating the menu.
 */
package Assign2;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Scanner;

public abstract class Product implements Comparable<Product>, Serializable  {
		

		private int SKU = 0;
		private int quantity =0;
		private double price =0;
		private String title =" ";
	 
		

		
	/**
	 * 	This method is a helping getter method
	 * @return SKU
	 */
	public int getSku(){
		return SKU;
	}
	
	/**
	 * 	This method is a helping getter method
	 * @return quantity
	 */
	public int getQuan (){
		return quantity;
	}
	
	/**
	 * 	This method is a helping getter method
	 * @return price
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * 	This method is a helping getter method
	 * @return title
	 */
	public String getTitle (){
		return title;
	}

/*
	 public String toString(){
		 DecimalFormat dfMoney = new DecimalFormat("$0.00");
		 return String.format("%5s,  %5d, %8s, %-20s", SKU, quantity, 
				 dfMoney.format(price), title);
	 }
	 
	 public String labeledString (){
		 DecimalFormat dfMoney = new DecimalFormat("$0.00");
		 return "SKU: " + this.getSku() + ",\nquantity: " + this.getQuan() +
				 ",\nprice: " + dfMoney.format(price) + ",\ntitle: " + title;
	 }
	 
	// public void displayInfo(int index){
	//	 System.out.println("not implemented yet");
	// }
*/
	
	/**
	 * This method adds a product subclass object to the passed inventory
	 * @param newInv
	 */

	 public void addProduct(Inventory newInv){	
		 Scanner in = new Scanner(System.in);
		 System.out.println("Please enter the SKU of the "
 					+ "product you would like to add: ");
		 int s = in.nextInt();
		 System.out.println("Please enter the quantity: ");
		 int q = in.nextInt();				 
		 System.out.println("Please enter the price: ");
		 double p = in.nextDouble();				 
		 System.out.println("Please enter the title: ");
		 in.nextLine();
		 String t = in.nextLine();	

	
		 this.SKU = s;
		 this.quantity = q;
		 this.price = p; 
		 this.title = t;
		 newInv.addToInventory(this);
			

}
			 
/**
 * this method returns a m, b, or t (non case-sensitive).  It is
 * used to help get user input to specify which type of product
 * to add
 * @return char indicating type to be added
 */
public char getProductType(){
	 Scanner in = new Scanner(System.in);
	 System.out.println("Please enter M for Movie, B for book, or "
				+ "T for Toy ");
	 char type = in.next().charAt(0);
	 while (type != 'm' && type != 'M' && type != 'b' && type != 'B' && 
			 type != 't' && type != 'T'){
		 System.out.println("Error!  Please enter M for Movie, B for book, or "
					+ "T for Toy ");
		 type = in.next().charAt(0);
		 }
	 return type;
}

/**
 * this method decreases the quantity of a product by q
 * @param q
 */
public void decreaseByQ (int q){
	
	this.quantity = this.quantity - q;
	
}


 
public double getCredit(){
	return -1.1;
}
public double getCommission(double price){
	return -1.1;
}
public void displayInfo(){
	System.out.println("wrong spot");
	}


	public int compareTo(Product rhs){
		
		return (this.SKU - rhs.SKU);
	}


}
