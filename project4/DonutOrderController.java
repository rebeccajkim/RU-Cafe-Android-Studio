package project4;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
This class is the controller than implements the Donut Menu GUI. The Donut 
Menu has options of adding different types of donuts, choosing unique flavors, 
choosing a quantity, and adding it all to the customers order. The total price 
is displayed depending on the changes made as soon as a customer starts their
order. There is also an option to add and remove the donut order as the customer
may please.
@author mayeesha, rebecca
*/
public class DonutOrderController implements Initializable{
	
	private boolean alrSelected;
	private String donutType;
	private int donQuantity;
	String quanString = String.valueOf(donQuantity);
	private double finalPrice;
	int count = 1;
	DecimalFormat decimal = new DecimalFormat("0.00");

		
	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();
    
    @FXML
	private TextField donutTotalField;
	
    @FXML
	private Button addDonutButton, removeDonutButton;
    
	 @FXML
	 private ListView<String> selectListView;
	 protected ObservableList<String> typeDonList = 
	    		FXCollections.observableArrayList("jelly","chocolate frosted","strawberry frosted", "sugar", "lemon filled");
	 @FXML
	 private ListView<String> displayListView;
	 
	 ObservableList<String> selectedFlavor = 
			 FXCollections.observableArrayList();
	 
	 @FXML
	 private ComboBox <String> selectDonutType;
	 protected ObservableList<String> typeDonItems = 
	    		FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
	 
	 @FXML
	 protected ComboBox <Integer> numberOfDonut;
	 protected ObservableList<Integer> numDonItems = 
	    		FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	 
	 /** 
     This method initializes the combo boxes and list views with
     items. 
     @param location, resources
     */
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 numberOfDonut.setItems(numDonItems);
		 selectDonutType.setItems(typeDonItems);
		 selectListView.setItems(typeDonList);
		//selectListView.setItems(displayDonList);
	 }
	
	 @FXML
	    /** 
	     Action Event Handler when selecting donut type
	     @param event
	     */
	    void selectDonType(ActionEvent event) {
		 if(!alrSelected) {
			 String donutType = selectDonutType.getValue().toString();
			 this.donutType = donutType;	
			 DonutClass donClass = new DonutClass(donutType);
			 donClass.itemPrice();
			 double finPrice = donClass.getPrice() + finalPrice;
			 donutTotalField.setText(decimal.format(finPrice));
			 this.finalPrice = finPrice; 
			 boolean isSelected = true;
			 this.alrSelected = isSelected;
			 } else {
				double finalPrice = 0.0; 
				this.finalPrice = finalPrice;
				String donutType = selectDonutType.getValue().toString();
				this.donutType = donutType;	
				DonutClass donClass = new DonutClass(donutType);
				donClass.itemPrice();
				double finPrice = donClass.getPrice() * donQuantity;
				donutTotalField.setText(decimal.format(finPrice));
				this.finalPrice = finPrice; 
			 }

	    }
	 
	 @FXML
	    /** 
	     Action Event Handler when selecting donut quantity
	     @param event
	     */
	    void donutAmountAction(ActionEvent event) {
		 int donQuantity = numberOfDonut.getValue();
		 this.donQuantity = donQuantity; 
		 double newDPrice = donQuantity * finalPrice;
		 donutTotalField.setText(decimal.format(newDPrice));
		 this.finalPrice = newDPrice;

	    }
	 
	 @FXML
	    /** 
	     Action Event Handler for the button that adds a 
	     donut flavor order to the list.
	     @param event
	     */
	    void addDonutButtonAction(ActionEvent event) {
			
		 selectedFlavor.add(selectListView.getSelectionModel().getSelectedItem());
		 displayListView.setItems(selectedFlavor);

	    }
	 
	 @FXML
	    /** 
	     Action Event Handler for the button that removes a 
	     donut flavor order to the list.
	     @param event
	     */
	    void removeDonutButtonMouse(MouseEvent event) {
		 selectedFlavor.remove(selectListView.getSelectionModel().getSelectedItem());
		 displayListView.setItems(selectedFlavor);

	    }
	 
	 
	 @FXML
	    /** 
	     Action Event Handler for the button that removes a 
	     donut flavor order to the list.
	     @param event
	     */
	    void addToOrderClick(MouseEvent event) {
		 

	    }
	 
	 
	 
	 
	 
	  
	
	 
	 
}