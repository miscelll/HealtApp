package controller;
import application.ConnectionMySql;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javafx.scene.layout.VBox;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SignInController2 implements Initializable {
	//controller of SignIn.fxml page
	//in the SignInController2.java file we have: btn_connect, btn_pass Buttons, VBox, password and username fields and two function.
	
		Connection cnx;

		public PreparedStatement st;
		public ResultSet result;
    	@FXML
    	private VBox VBox;

	    @FXML
	    private Button btn_connect;

	    @FXML
	    private Button btn_pass;

	    @FXML
	    //private TextField password;
	    private PasswordField password;

	    @FXML
	    private TextField username;
	    
	    @FXML
	    private Parent fxml;
	    
	    
	    
	    // this function is called when a user try to login  by clicking the button connect
	    @FXML
	    void OpenHome() throws IOException {
	    	String nome= username.getText();
	    	String pass = password.getText();
	    	String sql="select username, pass from admin";
	    	
	    	try {
	    		//here there is the construction of the query to make some controls on the account
	    		st= (PreparedStatement) cnx.prepareStatement(sql);
	    		result= st.executeQuery();
	    		boolean val=false;
	    		while(result.next()) {
	    			
	    			if((nome.equals(result.getString("username")))&&(pass.equals(result.getString("pass")))){
	    				
	    				//System.out.println("ACCESS OK");
	    				VBox.getScene().getWindow().hide();
	    				Stage home= new Stage();
	    				val=true;
	  
	    			try {
	    		
	    				fxml= FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
	    				Scene scene = new Scene(fxml);
	    				home.setScene(scene);
	    				home.show();
	    			}catch(IOException e){
    			
	    			}
	    			
	    		 
	    		}
	    			//if the account is not registered then an alert will be shown
	    			if(result.isLast() && !val) {
	    			Alert alert = new Alert(AlertType.ERROR," Username or password uncorrect", javafx.scene.control.ButtonType.OK);
		    		System.out.println(result.getString("username"));
					System.out.println(result.getString("pass"));
		    		alert.showAndWait();
		    		}
	    		}
    			

	    		
	    		} catch (SQLException e) {
			
				e.printStackTrace();
			}	    			
	    }

	    @FXML
	    void setPass() {

	    }

	
	    

	 //Called to initialize a controller after its root element has been completely processed.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cnx= (Connection) ConnectionMySql.connexionDB();
		
		
	}

	

}
