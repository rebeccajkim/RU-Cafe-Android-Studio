package project4;

/**
The DonutClass is a subclass of the MenuItem class so it holds the same attributes as the 
MenuItem class. There is an additional instance variable for type of donut. 
@author mayeesha, rebecca
*/
public class DonutClass extends MenuItem {
	private String donutType;
	
	/**
	This constructor takes the type of donut and sets the donutType as that type.
	@param donut type
	*/
	public DonutClass(String donutType) {
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
		if (donutType.equals("Yeast")) {
			setPrice(1.39);
		}
		else if (donutType.equals("Cake")) {
			setPrice(1.59);
		}
		else if (donutType.equals("Hole")) {
			setPrice(0.33);
		}
		setPrice(getPrice() * getQuantity());
	}
}
