package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

//import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import javafx.util.Duration;


//Controller of Main.fxml page
//in the MainController.java file we have: SignIn and SignUp Bottons, a VBox, e three fuction.
public class MainController implements Initializable{
	
	
//@FXML is annotation on a member, you declare that the FXML uploader can access the member even if it is private

	
    @FXML
    private Button SignIn;
    @FXML
    private Button SignUp;
    @FXML
    private javafx.scene.layout.VBox VBox;
    
 
    //function that is called when the SignUp Button is pressed
    @FXML
    void OpenSignUp() { 
    	//this class is used to create a move/translate animation
    	TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(5);
		t.play();
		
		t.setOnFinished( e -> {
			try {
				//after the animation, the SignUp.fxml file is loaded in the unique VBox of the Scene
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
				VBox.getChildren().removeAll();
				VBox.getChildren().setAll(fxml);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});

    }
    
    //The base class for all nodes that have children in the scene graph. 
    private Parent fxml;
    
    //function that is called when the SignIn Button is pressed
    @FXML
    void OpenSignIn() {
    	//this class is used to create a move/translate animation
    	TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(VBox.getLayoutX() * 40);
		t.play();
		
		t.setOnFinished( e -> {
			try {
				//after the animation, the SignIn.fxml file is loaded in the unique VBox of the Scene
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignIn.fxml"));
				VBox.getChildren().removeAll();
				VBox.getChildren().setAll(fxml);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});

    }

    //Called to initialize a controller after its root element has been completely processed.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(( VBox).getLayoutX() * 5);
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
			VBox.getChildren().removeAll();
			VBox.getChildren().setAll(fxml);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		t.play();
	}

	


}
