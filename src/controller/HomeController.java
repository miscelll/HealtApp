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

//controller of Home.fxml page
//in the HomeController.java file we have: conversion,contacts,profile,logout Buttons, AnchorPane and five functions.

public class HomeController implements Initializable{

    private Parent fxml;

  
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
    
    
    //this function is called when the LogOut Button is clicked; the user is redirected to Main page
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

    
    //this function is called when the Conversation Button is clicked.
    @FXML
    void DoConversion() {
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

    //this function is called when the Contacts Button is clicked.
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

    //this function is called when the Profile Button is clicked.
    @FXML
    void OpenProfile() {
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

  //Called to initialize a controller after its root element has been completely processed.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
