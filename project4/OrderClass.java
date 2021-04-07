package project4;

import java.io.BufferedWriter;
import java.util.ArrayList; //**says quantity so is it like 2 of the exact same coffee?? then have to equal and add to quantity

/**
The OrderClass implements the Customizable interface so there's methods to add and
remove add-ins. There are instance variables such as an arraylist for menu items
so donuts and coffee can be added and price can be calculated and variables for order number
and various totals. 
@author mayeesha, rebecca
*/
public class OrderClass implements Customizable { //**order number and specific type of coffee etc and export to txt stuff in "kiosk/payrollprocessing" thing so maybe in some controller class idk)
	private ArrayList<MenuItem> itemList; //idk if need numItems
	private int orderNumber;
	private double subtotal;
	private double salestax;
	private double total;
	
	/**
	The constructor sets default values for the instance variables.
	 */
	public OrderClass() {
		itemList = new ArrayList<MenuItem>();
		orderNumber = 0;
		subtotal = 0;
		salestax = 0;
		total = 0;
	}
	
	/**
	This constructor takes the order number and creates an arraylist of menu items and sets the totals
	to 0.
	@param order number
	*/
	public OrderClass(int orderNumber) {
		itemList = new ArrayList<MenuItem>();
		this.orderNumber = orderNumber;
		subtotal = 0;
		salestax = 0;
		total = 0;
	}
	
	/**
	This constructor takes the arraylist of items and creates and sets the totals and order number to 0.
	@param list of items
	*/
	public OrderClass(ArrayList<MenuItem> itemList) {
		this.itemList = itemList;
		orderNumber = 0;
		subtotal = 0;
		salestax = 0;
		total = 0;
	}
	
	/**
	This method adds menu items to the arraylist for the order.
	@param menu item
	*/
	public boolean add(Object obj) {
		if (obj instanceof MenuItem) {
			MenuItem item = (MenuItem) obj;
			itemList.add(item);
			return true;
		}
		return false;
	}
	
	/**
	This method removes menu items from the arraylist for the order.
	@param menu item
	*/
	public boolean remove(Object obj) {
		if (obj instanceof MenuItem) {
			MenuItem item = (MenuItem) obj;
			itemList.remove(item);
			return true;
		}
		return false;
	}
	
	/**
	This method returns the arraylist of menu items so menu items can be added, removed, and
	retrieved from the arraylist.
	@return arraylist of menu items for the order
	*/
	public ArrayList<MenuItem> getItems() {
		return itemList;
	}
	
	/**
	Getter method for the order number so the value can be used in other classes.
	@return order number
	*/
	public int getOrderNumber() { 
		return orderNumber;
	}
	
	/**
	Setter method for the order number so the value can be set from other classes.
	@return order number
	*/
	public void setOrderNumber(int orderNumber) { 
		this.orderNumber = orderNumber;
	}
	
	/**
	Getter method for the subtotal of an order so the value can be used in other classes.
	@return subtotal of order
	*/
	public double getSubtotal() { 
		return subtotal;
	}
	
	/**
	Getter method for the sales tax on an order so the value can be used in other classes.
	@return tax on order
	*/
	public double getSalestax() { 
		return salestax;
	}
	
	/**
	Getter method for the total of an order so the value can be used in other classes.
	@return total of order
	*/
	public double getTotal() { 
		return total;
	}
	
	/**
	Setter method for the total of an order so the value can be set from other classes.
	*/
	public void setTotal(double total) {
		this.total = total;
	}
	
	/*
	This method calculates the subtotal, sales tax, and total for an order.
	*/
	public void calculateTotal() { //might have to round to two decimal places somehow
		for (int i = 0; i < itemList.size(); i++) {
			subtotal += itemList.get(i).getPrice();
		}
		salestax = subtotal * 0.06625;
		total = subtotal + salestax;
	}
	
	/**
	The method exports the order to a path of a file to help it be saved/exported to that file.
	@param path of the file
	*/
	public void exportOrder(String path) {
		try {
			FileWriter write = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(write);
			for (int i = 0; i < itemList.size(); i++) {
				 if (itemList.get(i) instanceof DonutClass) {
					 DonutClass don = (DonutClass) itemList.get(i);
					 writer.append(don.toString());
				 }
				 else if (itemList.get(i) instanceof CoffeeClass) {
					 CoffeeClass cof = (CoffeeClass) itemList.get(i);
					 writer.append(cof.toString());
				 }
			 }
			writer.close();
		}
		catch (IOException e) {
		}
	}
	
}
