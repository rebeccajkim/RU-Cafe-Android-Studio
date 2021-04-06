package project4;

import java.util.ArrayList; 

/**
The StoreOrders class implements the Customizable interface so there's methods to add and
remove add-ins. There are instance variables such as an arraylist for orders
so orders can be added and price can be calculated.
@author mayeesha, rebecca
*/
public class StoreOrders implements Customizable { //**order number and specific type of coffee and export to txt etc stuff in "kiosk/payrollprocessing" thing so maybe in some controller class idk)
	private ArrayList<OrderClass> orderList; //idk if need numItems
	
	/**
	This constructor makes the arraylist of orders.
	*/
	public StoreOrders() {
		orderList = new ArrayList<OrderClass>(); //getters and setters??
	}
	
	/**
	This method adds an order to the list of orders.
	@param order
	*/
	public boolean add(Object obj) {
		if (obj instanceof OrderClass) {
			OrderClass order = (OrderClass) obj;
			orderList.add(order);
			return true;
		}
		return false;
	}
	
	/**
	This method removes an order from the list of orders.
	@param order
	*/
	public boolean remove(Object obj) {
		if (obj instanceof OrderClass) {
			OrderClass order = (OrderClass) obj;
			orderList.remove(order);
			return true;
		}
		return false;
	}
	
	/**
	This method returns the arraylist of orders so it can be used in other classes.
	@return arraylist of orders
	*/
	public ArrayList<OrderClass> getOrderList() {
		return orderList;
	}
}
