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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SignInController implements Initializable {

	
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
	    private TextField password;

	    @FXML
	    private TextField username;
	    
	    @FXML
	    private Parent fxml;
	    
	    
	    

	    @FXML
	    void OpenHome() throws IOException {
	    	String nome= username.getText();
	    	String pass = password.getText();
	    	String sql="select username, pass from admin";
	    	
	    	try {
	    		st= (PreparedStatement) cnx.prepareStatement(sql);
	    		result= st.executeQuery();

	    		if(result.next()) {
	    			if((nome.equals(result.getString("username")))&&(pass.equals(result.getString("pass")))){
	    			
	    				System.out.println("ACCESS OK");
	    				VBox.getScene().getWindow().hide();
	    				Stage home= new Stage();
	  
	    			try {
	    		
	    				fxml= FXMLLoader.load(getClass().getResource("/interfaces/Home3.fxml"));
	    				Scene scene = new Scene(fxml);
	    				home.setScene(scene);
	    				home.show();
	    			}catch(IOException e){
    			
	    			}
	    		 }else  {
	    				Alert alert = new Alert(AlertType.ERROR," Username or password uncorrect", javafx.scene.control.ButtonType.OK);
	    	    		System.out.println(result.getString("username"));
	    				System.out.println(result.getString("pass"));
	    	    		alert.showAndWait();
	    	    		
	    		 }
	    		}
	    	
	    		
	    		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    			
	    }

	    @FXML
	    void setPass() {

	    }

	
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cnx= (Connection) ConnectionMySql.connexionDB();
		
		
	}

	

}
