package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import application.ConnectionMySql;
public class SignUpController implements Initializable{

	//controller of SignUp.fxml page
	//in the SignUpController.java file we have: iscription, btn_pass Buttons, VBox, password,email and username fields and two function.
	Connection cnx;

	public PreparedStatement st;
	public ResultSet result;
	

    @FXML
    private Button inscription;

    
    @FXML
    private TextField password;

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
   	private Parent fxml;
 	@FXML
	private VBox VBox;

    
    
 	 // this function is called when a user try to create an account by clicking the button inscription
    @FXML
    void click()throws IOException {
    	
    	String nome= username.getText();
    	String pass = password.getText();
    	String mail = email.getText();
    	String sql="select username, pass, email from admin";
    	
    	
    	try {
    		boolean val=false;
    		boolean nomeCheck=false;
    		boolean mailCheck=false;
    		st= (PreparedStatement) cnx.prepareStatement(sql);
    		result= st.executeQuery();
    		if(nome.equals("")) val=true;
    		if(mail.equals("")) val=true;
    		while(result.next()) {
    			if((nome.equals(result.getString("username")))){
    	    			nomeCheck=true;
    			
    			} else if(mail.equals(result.getString("email"))) {
    					mailCheck=true;
    	    		
    			}
    		
    			//if the account is not already existing, then the account is created and the information is saved into database
    			if(result.isLast() && !nomeCheck && !mailCheck &&!val) {
    			 try {
    				        PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(
    				            "INSERT INTO admin(username, pass, email) VALUES (?,?,?)");
    				   
    				    ps.setString(1, nome);
    				    ps.setString(2, pass);
    				    ps.setString(3, mail);
    				    Alert alert = new Alert(AlertType.INFORMATION," account create successfully", javafx.scene.control.ButtonType.OK);
	    	    		alert.showAndWait();

	    	    		VBox.getScene().getWindow().hide();
	    				Stage home= new Stage();
	  
	    				try {
	    				//after the succesful creation of account, then the SignIn page is shown
	    				fxml= FXMLLoader.load(getClass().getResource("/interfaces/SignIn.fxml"));
	    				Scene scene = new Scene(fxml);
	    				home.setScene(scene);
	    				home.show();
	    		
	    		
	    					}catch(IOException e){
    			
	    					}
	    	    		
	    				if( ps.execute()) {
	    					System.out.println("Insert OK"); }
    				} catch(SQLException e) {
    				  
    				}
    		
    		//if the provided username and password are already used, an alert is shown
    		 }else if(result.isLast() && nomeCheck && mailCheck && !val){
    			 Alert alert = new Alert(AlertType.ERROR," Username and email already used", javafx.scene.control.ButtonType.OK);
 	    		alert.showAndWait();
    		 } 
    			//if the provided username is already used, an alert is shown
    		 else if(result.isLast() && nomeCheck && !mailCheck &&!val){
     			
     			 Alert alert = new Alert(AlertType.ERROR," Username  already used", javafx.scene.control.ButtonType.OK);
  	    		alert.showAndWait();
     		 }  
    		//if the provided password is already used, an alert is shown
    			else if(result.isLast() && !nomeCheck && mailCheck &&!val){
     			
     			 Alert alert = new Alert(AlertType.ERROR," Email already used", javafx.scene.control.ButtonType.OK);
  	    		alert.showAndWait();
    		} 
    			//if some fields are empties, an alert is shown
    			else if( result.isLast() &&val) {
    			 Alert alert = new Alert(AlertType.ERROR," Empty fields!", javafx.scene.control.ButtonType.OK);
   	    		alert.showAndWait();
    			
    		}
    		
    		}
    	}catch (SQLException e) {
	
			e.printStackTrace();
		}	    			
    }
    	
   

	 //Called to initialize a controller after its root element has been completely processed.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cnx= (Connection) ConnectionMySql.connexionDB();
		
		
	}

	

}
