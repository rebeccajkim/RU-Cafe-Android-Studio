package project4;

/**
The DonutClass is a subclass of the MenuItem class so it holds the same attributes as the 
MenuItem class. There is an additional instance variable for type of donut. 
@author mayeesha, rebecca
*/
public class DonutClass extends MenuItem {
	private String donutType;
	
	/**
	This constructor takes the quantity, price, and type of donut to make a donut object.
	@param quantity, price, donut type
	*/
	public DonutClass(int quantity, double price, String donutType) {
		super(quantity, price);
		this.donutType = donutType;
	}
	
	/**
	This method returns the type of donut.
	@return donut type
	*/
	public String getDonutType() {
		return donutType;
	}
	
	/**
	This method sets the type of donut.
	@param type of donut
	*/
	public void setDonutType(String donutType) {
		this.donutType = donutType;
	}
	
	/**
	This method calculates the price of the donut.
	*/
	@Override
	public void itemPrice() {
		if (donutType.equals("Yeast Donut")) {
			setPrice(1.39);
		}
		else if (donutType.equals("Cake Donut")) {
			setPrice(1.59);
		}
		else if (donutType.equals("Donut Hole")) {
			setPrice(0.33);
		}
		if (getQuantity() >= 1) {
			setPrice(getPrice() * getQuantity());
		}
	}
	
	/**
	The method creates a string description of a donut object.
	*/
	@Override
	public String toString() { 
		return donutType + "(" + String.valueOf(getQuantity()) + ")";
	}
}
