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

    
    
   
    @FXML
    void click()throws IOException {
    	
    	String nome= username.getText();
    	String pass = password.getText();
    	String mail = email.getText();
    	String sql="select username, pass, email from admin";
    	
    	
    	try {
    		boolean val=false;
    		st= (PreparedStatement) cnx.prepareStatement(sql);
    		result= st.executeQuery();

    		while(result.next()) {
    			if((nome.equals(result.getString("username")))){
    	    		//Alert alert = new Alert(AlertType.ERROR," Username already used", javafx.scene.control.ButtonType.OK);
    	    		//alert.showAndWait();
    	    		val=true;
    				//VBox.getScene().getWindow().hide();
    				//Stage home= new Stage();
    			/*try {
    		
    				fxml= FXMLLoader.load(getClass().getResource("/interfaces/Home3.fxml"));
    				Scene scene = new Scene(fxml);
    				home.setScene(scene);
    				home.show();
    		
    			}	catch(IOException e){
			
    			}*/
    			} else if(mail.equals(result.getString("email"))) {
    				//Alert alert = new Alert(AlertType.ERROR," email already used", javafx.scene.control.ButtonType.OK);
    	    		//alert.showAndWait();
    	    		val=true;
    	    		fxml = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
    			}
    		


    		 if(result.isLast() && !val) {
    			 try {
    				        PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(
    				            "INSERT INTO admin(username, pass, email) VALUES (?,?,?)");
    				    /*
    				     * The question marks are placeholders for the values you will insert.
    				     */
    				    ps.setString(1, nome);
    				    ps.setString(2, pass);
    				    ps.setString(3, mail);
    				    Alert alert = new Alert(AlertType.INFORMATION," account create successfully", javafx.scene.control.ButtonType.OK);
	    	    		alert.showAndWait();
	    	    		
	    	    		
	    	    		VBox.getScene().getWindow().hide();
	    				Stage home= new Stage();
	  
	    			try {
	    		
	    				fxml= FXMLLoader.load(getClass().getResource("/interfaces/SignIn.fxml"));
	    				Scene scene = new Scene(fxml);
	    				home.setScene(scene);
	    				home.show();
	    		
	    		
	    			}	catch(IOException e){
    			
	    			}
	    	    		
    				   if( ps.execute()) {
    					   System.out.println("Insert OK");
    					   
    					   
    				   }; // The insert is executed here
    				} catch(SQLException e) {
    				    // Your exception handling code
    				}
    		
    		 }else if(result.isLast() && val){
    			Alert alert = new Alert(AlertType.ERROR," Username and/or email already used", javafx.scene.control.ButtonType.OK);
 	    		alert.showAndWait();
    		 }
    		}
    		
    		
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    			
    }
    	
   
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cnx= (Connection) ConnectionMySql.connexionDB();
		
		
	}

	

}
