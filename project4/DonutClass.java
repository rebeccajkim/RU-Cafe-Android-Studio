package project4;

public class DonutClass extends MenuItem {
	private String donutType;
	
	public DonutClass(String donutType) {
		this.donutType = donutType;
	}
	
	public String getDonutType() {
		return donutType;
	}
	
	public void setDonutType(String donutType) {
		this.donutType = donutType;
	}
	
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
	}
}
