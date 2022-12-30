package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;




public class HomeController implements Initializable{

    private Parent fxml;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Button blog;

    @FXML
    private Button conversion;

    @FXML
    private Button profile;

   
    
    @FXML
    void DoConversion() {

    	System.out.println("Conversione");
    	
		
		anchorPane2.getScene().getWindow().hide();
		Stage conversion= new Stage();
		
			
		try {
		System.out.println("Conversione2");
		fxml= FXMLLoader.load(getClass().getResource("/interfaces/Conversion.fxml"));
		
		Scene scene = new Scene(fxml);
		
		conversion.setScene(scene);
		conversion.show();
		
		
	
		}
		catch(IOException e){
			
		}
		catch( IllegalStateException p) {
			
		}
    }

    @FXML
    void OpenBlog(MouseEvent event) {

    }

    @FXML
    void OpenProfile(MouseEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
