package project4;

/**
The MenuItem class is the superclass to DonutClass and CoffeeClass that has the instance variables
and methods that donuts and coffee would both need to have (like quantity and price).
@author mayeesha, rebecca
*/
public class MenuItem {
	private int quantity;
	private double price;

	/**
	This constructor is the default to make a menu item and the price depends on the type of item so it'll
	be set in the subclasses.
	*/
	public MenuItem() {
		quantity = 0;
		price = 0;
	}
	
	/**
	This constructor makes a menu item with the quantity and price desired.
	@param quantity, price
	*/
	public MenuItem(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	Getter method for the quantity of an item so the value can be used in other classes.
	@return quantity of item
	*/
	public int getQuantity() { 
		return quantity;
	}
	
	/**
	Setter method for the quantity of an item so the value can be set in other classes
	@param item quantity
	*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	Getter method for the price of an item so the value can be used in other classes.
	@return price of item
	*/
	public double getPrice() { 
		return price;
	}
	
	/**
	Setter method for the price of an item so the value can be set in other classes
	@param item price
	*/
	public void setPrice(double price) {
		this.price = price;
	}
		
	/**
	This method is the method that the other classes with the same method will override. It calculates
	the price of a menu item. 
	*/
	public void itemPrice() {
	}
	
	//****idk if need an equals or toString method??
	
	/**
	This method checks if employee objects are equal and already in the database by comparing 
	one employee's profile with another, and returns boolean values accordingly.
	@param obj of type employee to check with another employee object
	@return true if employees are equal, false if not
	*/
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee=(Employee) obj;
			return employee.profile.equals(this.profile);
		}
		return false;
	}
	*/
	
	/**
	The method creates a string description of a menu item.
	@return string description
	*/
	@Override
	public String toString() { 
		return "";
	}
	
}
