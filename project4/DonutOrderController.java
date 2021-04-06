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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DonutOrderController implements Initializable{
		
	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();

	 @FXML
	 private ListView<String> selectListView;
	 protected ObservableList<String> typeDonList = 
	    		FXCollections.observableArrayList("jelly", "chocolate frosted", "strawberry frosted", "sugar", "lemon filled");
	 
	 @FXML
	 private ComboBox <String> selectDonutType;
	 protected ObservableList<String> typeDonItems = 
	    		FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
	 
	 @FXML
	 protected ComboBox <Integer> numberOfDonut;
	 protected ObservableList<Integer> numDonItems = 
	    		FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 numberOfDonut.setItems(numDonItems);
		 selectDonutType.setItems(typeDonItems);
		 selectListView.setItems(typeDonList);
	 }
	
	 
	 
	  
	
	 
	 
}