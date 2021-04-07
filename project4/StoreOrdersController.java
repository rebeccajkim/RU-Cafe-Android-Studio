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

/**
This class is the controller for the StoreOrders window where a user can choose an order out of all the
orders and see the total, cancel it, or export it.
@author mayeesha, rebecca
*/
public class StoreOrdersController implements Initializable { 
	
	public mainMenuController mMenuController;
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
	 
	 Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	    Stage stage = new Stage();
	 
	 /**
	 This method sets the main menu controller as the one in the argument.
	 @param controller
	 */
	 public void setMainMenu(mainMenuController controller){
		 mMenuController = controller;
	}
	 
	 /**
     This method initializes the combo boxes and list views with
     items. 
     @param location, resources
     */
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 orderNum.setItems(ordNum);
		 displayListView.setItems(displayOrdersList);
	 }
	 
	 /**
	 This method sets the combo box to have the different order numbers in the list of all orders
	 so the user can later select one order to look at.
	 */
	 @FXML
	 void orderNumberList() {
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
	     Action Event Handler when choosing an order number to look at and see the total.
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
				 displayList.add(don.toString());
			 }
			 else if (order.getItems().get(j) instanceof CoffeeClass) {
				 CoffeeClass cof = (CoffeeClass) order.getItems().get(j);
				 displayList.add(cof.toString());
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