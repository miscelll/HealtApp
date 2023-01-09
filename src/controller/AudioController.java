package controller;

import java.io.File;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//controller of Audio.fxml page
//in the AudioController.java file we have: anchorPane, conversion and back Buttons, three functions
public class AudioController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button conversion;

    @FXML
    private Button back;

    private Parent fxml;
    
  //this function is called when the back button is clicked; the user is redirected to Home page
    @FXML
    void Back() {
	AnchorPane.getScene().getWindow().hide();
		Stage conversion= new Stage();
	
		try {
		fxml= FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
		Scene scene = new Scene(fxml);
		conversion.setScene(scene);
		conversion.show();
		
    }catch(IOException e){		
		}
    }
   
  //this function is called when the conversion button is clicked; the user will choose the file to be converted
    @FXML
    void Open() {
    
    	FileChooser fileChooser = new FileChooser();
     	//Filter is used to specify the type of file the user must select
    	FileChooser.ExtensionFilter extentionFilter = new FileChooser.ExtensionFilter("wav file", "*.wav");
    	fileChooser.getExtensionFilters().add(extentionFilter);

    	//the folder "audio" is shown to the user
    	 File userDirectory = new File("audio");
    	//}
    	fileChooser.setInitialDirectory(userDirectory);
    	File chosenFile = fileChooser.showOpenDialog(null);
    	
    	//Make sure a file was selected, if not return default
    	String path;
    	if(chosenFile != null) {
    	    path = chosenFile.getPath();
    	    System.out.println(path);
    	 
    	    //PROCESSING FILE: calling the python script to elaborate the signal
    	    String anyCommand="cd python";
    	    String command2 =" python Green.py";

    	    ProcessBuilder builder = new ProcessBuilder("python","python\\Green.py", path).inheritIO();
    	    
    	    try {
				Process p=builder.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
	
    }
    
  //Called to initialize a controller after its root element has been completely processed.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
