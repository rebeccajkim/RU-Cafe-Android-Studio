package project4;

import java.util.ArrayList; 

public class StoreOrders implements Customizable { //**order number and specific type of coffee and export to txt etc stuff in "kiosk/payrollprocessing" thing so maybe in some controller class idk)
	private ArrayList<OrderClass> orderList; //idk if need numItems
	
	public StoreOrders() {
		orderList = new ArrayList<OrderClass>(); //getters and setters??
	}
	
	public boolean add(Object obj) {
		if (obj instanceof OrderClass) {
			OrderClass order = (OrderClass) obj;
			orderList.add(order);
			return true;
		}
		return false;
	}
	
	public boolean remove(Object obj) {
		if (obj instanceof OrderClass) {
			OrderClass order = (OrderClass) obj;
			orderList.remove(order);
			return true;
		}
		return false;
	}
}
