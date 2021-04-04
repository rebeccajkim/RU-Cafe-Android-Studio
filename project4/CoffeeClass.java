package project4;

import java.util.ArrayList;

public class CoffeeClass extends MenuItem implements Customizable {

	private String size;
	private ArrayList<String> addins; //figure out addins/customizable
	
	public CoffeeClass(String size) {
		this.size = size;
		addins = new ArrayList<String>(0);
	}
	
	public boolean add(Object obj) { 
		if (obj instanceof String) {
			String addin = (String) obj;
			addins.add(addin);
			return true;
		}
		return false;
	}
	
	public boolean remove(Object obj) {
		if (obj instanceof String) {
			String addin = (String) obj;
			addins.remove(addin);
			return true;
		}
		return false;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public ArrayList<String> getAddins() { //arraylist of it and then further get an addin in arraylist. also can set an addin in arraylist
		return addins;
	}
	
	@Override
	public void itemPrice() {
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
	}
}
