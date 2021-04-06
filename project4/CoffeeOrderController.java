package project4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CoffeeOrderController implements Initializable{
	
	private String coffeeSize; 
	private int coffQuantity;
	private String strPrice;
	
	
	@FXML
	private CheckBox creamBox, syrupBox, milkBox, caramelBox, whipCreamBox;
	
	@FXML
	private TextField coffeeTotalField;
	
	 @FXML
	 private ComboBox <String> selectCoffeeType;
	 protected ObservableList<String> typeCoffItems = 
	    		FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
	 
	 
	 @FXML
	 protected ComboBox <Integer> numberOfCoffee;
	 protected ObservableList<Integer> numCoffItems = 
	    		FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 numberOfCoffee.setItems(numCoffItems);
		 selectCoffeeType.setItems(typeCoffItems);
	 }
	 
	 @FXML
	    /** 
	     Action Event Handler when getting the coffee quantity
	     @param event
	     */
	    void coffeeTypeAction(ActionEvent event) {
		 String coffeeSize = selectCoffeeType.getValue().toString();
		 this.coffeeSize = coffeeSize;	
		 CoffeeClass coffClass = new CoffeeClass(coffeeSize);
		 coffClass.itemPrice();
		 String strPrice = String.valueOf(coffClass.getPrice());
		 coffeeTotalField.setText(strPrice);
		 this.strPrice = strPrice; 
		 

	    }

	 
	 @FXML
	    /** 
	     Action Event Handler when getting the coffee quantity
	     @param event
	     */
	    void coffeeAmountAction(ActionEvent event) {
		 int coffQuantity = numberOfCoffee.getValue();
		 this.coffQuantity = coffQuantity; 
		 double dprice = Double.parseDouble(strPrice);
		 double newDPrice = coffQuantity * dprice;
		 String newStrPrice = String.valueOf(newDPrice);
		 coffeeTotalField.setText(newStrPrice);

	    }
	 
	 @FXML
	    /** 
	     Mouse Event Handler when getting the coffee quantity
	     @param event
	     */
	    void creamCheckClick (MouseEvent event) {
		 double dprice = Double.parseDouble(strPrice);
		 double newDoublePrice = dprice + 0.50; 
		 String newStrPrice = String.valueOf(newDoublePrice);
		 coffeeTotalField.setText(newStrPrice);

	    }
	 
	 
	 
	 
	 	

}