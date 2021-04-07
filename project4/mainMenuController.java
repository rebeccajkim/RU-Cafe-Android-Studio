package project4;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
This class is the main connection to the RU Cafe Menu. There are four options to click
and see pop up windows containing information for different windows such as the donut 
menu, the coffee menu, your orders, and store orders.
@author mayeesha, rebecca
*/
public class mainMenuController {
	
	
	private OrderClass order;
	private StoreOrders totalOrders;
	protected double finalPrice = 0; 
	protected int orderNumber = 0;
	
	 @FXML
	    private Button donutButton, coffeeButton, yourOrderButton, storeOrdersButton;
	    @FXML
	    private Text orderDonut, orderCoffee;
	
	 Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	    Stage stage = new Stage();
	    
	    
	    
	public mainMenuController() {
	  this.order = new OrderClass(new ArrayList<>());
	}

    
    public void addToOrder(OrderClass menuItems){
        for(MenuItem item: menuItems.getItems()){
            System.out.println("The item in add mainorder method is "+ item);
            order.add(item);
           if(item instanceof CoffeeClass){
              finalPrice = finalPrice +  ((CoffeeClass) item).getPrice();
            }
           if(item instanceof DonutClass){
               finalPrice = finalPrice + ((DonutClass) item).getPrice();
           }
            order.setTotalPrice(finalPrice);
        }
    }
    
    public OrderClass getOrder(){
        return order;
    }
    
    public void placeOrder(){
        totalOrders.add(order);
        order.setIncrement();
        this.order = new OrderClass(new ArrayList<>());
    }
    
    
    @FXML
    /** 
     * Mouse Event Handler when clicking Coffee Button 
     @param event
     */
    void coffeeMouseClick(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("CoffeeOrder.fxml"));
    		stage.setTitle("Coffee Order Menu");
    		stage.setScene(new Scene(root, 500, 500));
    		stage.show();
    	} catch (Exception e) {
    		errorAlert.setHeaderText("Error");
    		errorAlert.setContentText("Your coffee menu cannot be loaded. Please try again.");
    		errorAlert.show();
    	}
    	
    }
    
    @FXML
    /** 
     * Mouse Event Handler when clicking Donut Button 
     @param event
     */
    void donutMouseClick(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("DonutOrder.fxml"));
    		stage.setTitle("Donut Order Menu");
    		stage.setScene(new Scene(root, 500, 500));
    		stage.show();
    	} catch (Exception e) {
    		errorAlert.setHeaderText("Error");
    		errorAlert.setContentText("Your donut menu cannot be loaded. Please try again.");
    		errorAlert.show();
    		System.out.println("your exception:" + e);
    	}
    	
    }
    
    @FXML
    /** 
     * Mouse Event Handler when clicking Your Order Button 
     @param event
     */
    void yourOrderClick(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("YourOrder.fxml"));
    		stage.setTitle("Your Order Menu");
    		stage.setScene(new Scene(root, 500, 500));
    		stage.show();
    	} catch (Exception e) {
    		errorAlert.setHeaderText("Error");
    		errorAlert.setContentText("Your order menu cannot be loaded. Please try again.");
    		errorAlert.show();
    		System.out.println("your exception:" + e);
    	}
    	
    }
    
    @FXML
    /** 
    Mouse Event Handler when clicking Your Order Button 
    @param event
    */
    void storeOrdersClick(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("StoreOrders.fxml"));
    		stage.setTitle("Your Store Orders");
    		stage.setScene(new Scene(root, 500, 500));
    		stage.show();
    	} catch (Exception e) {
    		errorAlert.setHeaderText("Error");
    		errorAlert.setContentText("Your store orders cannot be loaded. Please try again.");
    		errorAlert.show();
    	}
    }
    
    
	
}