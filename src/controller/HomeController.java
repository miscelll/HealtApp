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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;




public class HomeController implements Initializable{

    private Parent fxml;

   // @FXML
    //private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button contacts;

    @FXML
    private Button conversion;

    @FXML
    private Button profile;

    @FXML
    private Button logOut;
    
    

    @FXML
    void LogOut() {

    	
		
		anchorPane.getScene().getWindow().hide();
		Stage conversion= new Stage();
		
			
		try {
		
		fxml= FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
		
	
		Scene scene = new Scene(fxml);
		
		scene.setFill(Color.TRANSPARENT);
		conversion.setScene(scene);
	
		conversion.initStyle(StageStyle.TRANSPARENT);
		
		conversion.show();
		
		
	
		}
		catch(IOException e){
			
		}
		catch( IllegalStateException p) {
			
		}
    }

    
    
    @FXML
    void DoConversion() {

    	System.out.println("Conversione");
    	
		
		anchorPane.getScene().getWindow().hide();
		Stage conversion= new Stage();
		
			
		try {
		
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
    void OpenContacts() {
	
    	
		
		anchorPane.getScene().getWindow().hide();
		Stage conversion= new Stage();
		
			
	
	
		try {
			fxml= FXMLLoader.load(getClass().getResource("/interfaces/Contact.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(fxml);
		
		conversion.setScene(scene);
		conversion.show();
		
	
	

    }

    @FXML
    void OpenProfile() {
	System.out.println("Profile");
    	
		
		anchorPane.getScene().getWindow().hide();
		Stage conversion= new Stage();
		
			
		try {
		
		fxml= FXMLLoader.load(getClass().getResource("/interfaces/Profile.fxml"));
		
		Scene scene = new Scene(fxml);
		
		conversion.setScene(scene);
		conversion.show();
		
    }catch(IOException e){
		
	}
	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
