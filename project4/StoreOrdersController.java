package project4;

import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField; //*******just copied imports from coffeeorder so fix later
import javafx.scene.input.MouseEvent;
import project3.ExtensionFilter;
import project3.FileChooser;
import project3.Stage;

public class StoreOrdersController implements Initializable { 
	
	private int orderNumber;
	private StoreOrders orders;
	private OrderClass order;
	private double total;
	DecimalFormat decimal = new DecimalFormat("0.00");
	private ArrayList<Integer> ordNumList;
	private ArrayList<String> displayList;
	
	@FXML
	private Button cancelOrderButton;
	
	@FXML
	private Button exportOrdersButton;
	
	@FXML
	private TextField orderTotalField;
	
	@FXML
	 protected ComboBox <Integer> orderNum;
	 protected ObservableList<Integer> ordNum = 
	    		FXCollections.observableArrayList(ordNumList); //**if cancel order idk how to remove ordernum from this list
	 
	@FXML
	 private ListView<String> displayListView;
	 protected ObservableList<String> displayOrdersList = 
	    		FXCollections.observableArrayList(displayList);
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 orderNum.setItems(ordNum);
		 displayListView.setItems(displayOrdersList);
	 }
	 
	 @FXML
	 void orderNumberList(ActionEvent event) {
		 try {
			 for (int i = 0; i < orders.getOrderList().size(); i++) {
				 ordNumList.add(orders.getOrderList().get(i).getOrderNumber());
			 }
		 }
		 catch (Exception e) {
			 //idk
		 }
	 }
	 
	 @FXML
	    /** 
	     Action Event Handler when choosing an order number to look at.
	     @param event
	     */
	    void orderNumChosen(ActionEvent event) {
		 try {
		 int orderNumber = orderNum.getValue();
		 this.orderNumber = orderNumber; 
		 for (int i = 0; i < orders.getOrderList().size(); i++) {
			 if (orders.getOrderList().get(i).getOrderNumber() == orderNumber) {
				 order = orders.getOrderList().get(i);
			 }
		 }
		total = order.getTotal();
		orderTotalField.setText(decimal.format(total));
		 for (int j = 0; j < order.getItems().size(); j++) {
			 if (order.getItems().get(j) instanceof DonutClass) {
				 DonutClass don = (DonutClass) order.getItems().get(j);
				 displayList.add(don.getDonutType() + "(" + String.valueOf(don.getQuantity()) + ")");
			 }
			 else if (order.getItems().get(j) instanceof CoffeeClass) {
				 CoffeeClass cof = (CoffeeClass) order.getItems().get(j);
				 String addinDisp = "";
				 for (int k = 0; k < cof.getAddins().size()-1; k++) {
					 addinDisp = addinDisp + cof.getAddins().get(k) + ",";
				 }
				 displayList.add("Coffee" + String.valueOf(cof.getQuantity()) + ") " + cof.getSize() 
					 	+ " [" + addinDisp + cof.getAddins().get(cof.getAddins().size()-1) + "]");
			 }
		}
		 }
		 catch (Exception e) {
			 //idk
		 }

	    } 
	 
	 @FXML
	 /**
	 Action Event Handler when cancelling an order.
	 */
	 void cancelOrder(ActionEvent event) {
		 try {
			 orders.remove(order);
		 }
		 catch (Exception e) {
			 //idk
		 }
	 }
	 
	 @FXML
	    /**
	    The method exports the order to the file chosen for the data to be saved to after the Export button is pressed.
	    @param event of button pressed
	    */
	    void exportFile(ActionEvent event) {
	    	try {
	    		FileChooser chooser = new FileChooser();
	    		chooser.setTitle("Export File");
	    		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
	    				new ExtensionFilter("All Files", "*.*"));
	    		Stage stage = new Stage();
	    		File file = chooser.showSaveDialog(stage);
	    		String filePath = file.getAbsolutePath();
	    		String fileName = file.getName();
	    		order.exportOrder(filePath);
	    	}
	    	catch (Exception e) {
	    		//messageArea2.append("Error. \n");
	    	}
	    }
}