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
	 protected ObservableList<String> displayOrderList = 
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
     Action Event Handler for the button that removes an item from the order.
     @param event
     */
    void removeItem(ActionEvent event) {
		order.remove(displayListView.getSelectionModel().getSelectedItems());
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





import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class YourOrderController implements Initializable{
	//OrderClass orderList = new OrderClass(newList);
	//CoffeeClass addInsList = new CoffeeClass();
	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	@FXML
	private TextField subTotalField, salesTaxField, totalAmountField;
	
	@FXML
	private Button priceButton;
	
	@FXML
	private ListView<String> orderListView = new ListView<String>();
	
	mainMenuController mainController = new mainMenuController();
	private ObservableList<String> listOfItem = FXCollections.observableArrayList();
	


    /*private void setText(){
        double subtotal = mainController.getOrder().getTotal();
        System.out.println("The price is "+ subtotal);
        double tax = subtotal * 0.06625;
        double totalPrice = subtotal + tax;
        DecimalFormat decimalFormat = new DecimalFormat("###, ###, ##0.00");
        salesTaxField.setText(decimalFormat.format(tax));
        subTotalField.setText(decimalFormat.format(subtotal));
        totalAmountField.setText(decimalFormat.format(totalPrice));
 
    }*/
	
	 @FXML
	    /** 
	     Action Event Handler for the button that removes a 
	     donut flavor order to the list.
	     @param event
	     */
	    void seePriceAction(ActionEvent event) {
		    double subtotal = mainController.getOrder().getTotal();
	        System.out.println("The price is "+ subtotal);
	        double tax = subtotal * 0.06625;
	        double totalPrice = subtotal + tax;
	        DecimalFormat decimalFormat = new DecimalFormat("###, ###, ##0.00");
	        salesTaxField.setText(decimalFormat.format(tax));
	        subTotalField.setText(decimalFormat.format(subtotal));
	        totalAmountField.setText(decimalFormat.format(totalPrice));
		 
	    }
	 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}