package project4;

import java.util.ArrayList;

/**
The CoffeeClass is a subclass of the MenuItem class so it holds the same attributes as the 
MenuItem class. It also implements the Customizable interface so there's methods to add and
remove add-ins. There are additional instance variables such as size and an arraylist for add-ins
so as many add-ins can be added and price can be calculated. 
@author mayeesha, rebecca
*/
public class CoffeeClass extends MenuItem implements Customizable {

	private String size;
	private ArrayList<String> addins; //figure out addins/customizable
	
	/**
	This constructor takes the size of the coffee and makes a CoffeeClass object
	with that size and initializes the arraylist for add-ins (the add-ins can be added later
	instead of taking a set number of arguments for a set number of add-ins).
	@param size of coffee
	*/
	public CoffeeClass(String size) {
		this.size = size;
		addins = new ArrayList<String>();
	}
	
	/**
	This constructor takes the size of the coffee, quantity, arraylist of add-ins, and price to make a coffee object.
	@param coffeeSize
	@param quantity
	@param addins
	@param price
	*/
	public CoffeeClass(String coffeeSize, int quantity, ArrayList<String> addins, double price) {
		super(quantity, price);
		this.size = coffeeSize;
		this.addins = addins;
	}
	
	/**
	This method adds an add-in to the add-ins arraylist.
	@param add-in
	@return true if obj was a String add-in, false if not
	*/
	public boolean add(Object obj) { 
		if (obj instanceof String) {
			String addin = (String) obj;
			addins.add(addin);
			return true;
		}
		return false;
	}
	
	/**
	This method removes an add-in from the add-ins arraylist.
	@param add-in
	@return true if obj was a String add-in, false if not
	*/
	public boolean remove(Object obj) {
		if (obj instanceof String) {
			String addin = (String) obj;
			addins.remove(addin);
			return true;
		}
		return false;
	}
	
	/**
	This method returns the size of the coffee.
	@return size
	*/
	public String getSize() {
		return size;
	}
	
	/*
	This method sets the size of the coffee.
	@param size
	*/
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	This method returns the arraylist of add-ins so add-ins can be added, removed, and retrieved
	from the arraylist.
	@return arraylist of add-ins
	*/
	public ArrayList<String> getAddins() { //arraylist of it and then further get an addin in arraylist. also can set an addin in arraylist
		return addins;
	}
	
	/**
	This method calculates the price of the coffee based on the size and number of add-ins.
	*/
	@Override
	public void itemPrice() {
		setPrice(0);
		if (size.equals("Short")) {
			setPrice(getPrice() + 1.99);
		}
		else if (size.equals("Tall")) {
			setPrice(getPrice() + 2.49);
		}
		else if (size.equals("Grande")) {
			setPrice(getPrice() + 2.99);
		}
		else if (size.equals("Venti")) {
			setPrice(getPrice() + 3.49);
		}
		setPrice(getPrice() + addins.size() * 0.20);
		if (getQuantity() >= 1) {
			setPrice(getPrice() * getQuantity());
		}
	}
	
	/**
	The method creates a string description of a coffee object.
	*/
	@Override
	public String toString() { 
		String addinDisp = "";
		for (int k = 0; k < addins.size()-1; k++) {
			addinDisp = addinDisp + addins.get(k) + ",";
		}
		return "Coffee" + String.valueOf(getQuantity()) + ") " + size + " [" + addinDisp + addins.get(addins.size()-1) + "]";
	}
}
