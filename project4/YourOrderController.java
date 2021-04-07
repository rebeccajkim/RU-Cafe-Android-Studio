package project4;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class YourOrderController {
	private OrderClass order;
	private StoreOrders orders;
	private int orderNumber;
	private double subtotal;
	private double salestax;
	private double total;
	DecimalFormat decimal = new DecimalFormat("0.00");
	private ArrayList<String> dispList;

	@FXML
	private TextField subtotalField, salestaxField, totalField;
	
	@FXML
	private Button removeItemButton;
	
	@FXML
	private Button placeOrderButton;
	
	@FXML
	 private ListView<String> displayListView;
	 protected ObservableList<String> displayOrdersList = 
	    		FXCollections.observableArrayList(dispList);
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 displayListView.setItems(displayOrdersList);
	 }
	
	@FXML
	void displayOrder() { //**idk arguments and have to add private stuff
		try {
		 for (int i = 0; i < order.getItems().size(); i++) {
			 if (order.getItems().get(j) instanceof DonutClass) {
				 DonutClass don = (DonutClass) order.getItems().get(i);
				 dispList.add(don.toString());
			 }
			 else if (order.getItems().get(j) instanceof CoffeeClass) {
				 CoffeeClass cof = (CoffeeClass) order.getItems().get(i);
				 dispList.add(cof.toString());
			 }
		}
		order.calculateTotal();
		subtotal = order.getSubtotal();
		subtotalField.setText(decimal.format(subtotal));
		salestax = order.getSalestax();
		salestaxField.setText(decimal.format(salestax));
		total = order.getTotal();
		totalField.setText(decimal.format(total));
		}
		catch (Exception e) {
			//idk
		}
	}
	
	@FXML
    /** 
     Action Event Handler for the button that adds a 
     donut order to the list.
     @param event
     */
    void removeItem(ActionEvent event) {
		
    }

	@FXML
	/**
	Action Event Handler for the button that places the order (and creates a new order).
	@param event 
	 */
	void placeOrder(ActionEvent event) {
		try {
			orders.add(order);
			orderNumber = order.getOrderNumber() + 1;
			this.order = new OrderClass(new ArrayList<MenuItem>());
			order.setOrderNumber(orderNumber);
		}
		catch (Exception e) {
			//idk
		}
		
	}
	
	
}