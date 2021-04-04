package project4;

import java.util.ArrayList; //**says quantity so is it like 2 of the exact same coffee?? then have to equal and add to quantity

public class OrderClass implements Customizable { //**order number and specific type of coffee etc and export to txt stuff in "kiosk/payrollprocessing" thing so maybe in some controller class idk)
	private ArrayList<MenuItem> itemList; //idk if need numItems
	private int orderNumber;
	private double subtotal;
	private double salestax;
	private double total;
	
	public OrderClass(int orderNumber) {
		itemList = new ArrayList<MenuItem>();
		this.orderNumber = orderNumber;
		subtotal = 0;
		salestax = 0;
		total = 0;
	}
	
	public boolean add(Object obj) {
		if (obj instanceof MenuItem) {
			MenuItem item = (MenuItem) obj;
			itemList.add(item);
			return true;
		}
		return false;
	}
	
	public boolean remove(Object obj) {
		if (obj instanceof MenuItem) {
			MenuItem item = (MenuItem) obj;
			itemList.remove(item);
			return true;
		}
		return false;
	}
	
	public void calculateTotal() { //might have to round to two decimal places somehow
		for (int i = 0; i < itemList.size(); i++) {
			subtotal += itemList.get(i).getPrice();
		}
		salestax = subtotal * 0.06625;
		total = subtotal + salestax;
	}
	
}
