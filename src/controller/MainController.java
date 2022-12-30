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



public class MainController implements Initializable{


    @FXML
    private Button SignIn;

    @FXML
    private Button SignUp;
    @FXML
    private javafx.scene.layout.VBox VBox;

    @FXML
    void OpenSignUp() { //registrazione
    	TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(5);
		t.play();
		
		t.setOnFinished( e -> {
			try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
				VBox.getChildren().removeAll();
				VBox.getChildren().setAll(fxml);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

    }
    private Parent fxml;
    @FXML
    void OpenSignIn() {
    	TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(VBox.getLayoutX() * 40);
		t.play();
		
		t.setOnFinished( e -> {
			try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignIn.fxml"));
				VBox.getChildren().removeAll();
				VBox.getChildren().setAll(fxml);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
		t.setToX(( VBox).getLayoutX() * 5);
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
			VBox.getChildren().removeAll();
			VBox.getChildren().setAll(fxml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.play();
	}

	


}
