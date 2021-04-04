package project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainMenuController { //****should work on controllers at least even if cant figure out fxml/gui

    @FXML
    private Button donutButton, coffeeButton, yourOrderButton, storeOrdersButton;
    @FXML
    private Text orderDonut, orderCoffee;
    
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();
    
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
    	}
    	
    }
    
    
	
}