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

public class AudioController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button conversion;

    @FXML
    private Button back;

    private Parent fxml;
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
   
  
    @FXML
    void Open() {
    
    	FileChooser fileChooser = new FileChooser();
     	
    	//Extention filter
    	FileChooser.ExtensionFilter extentionFilter = new FileChooser.ExtensionFilter("wav file", "*.wav");
    	fileChooser.getExtensionFilters().add(extentionFilter);

    	//Set to user directory or go to default if cannot access
    	//String userDirectoryString = System.getProperty("user.home");
    	//File userDirectory = new File(userDirectoryString);
    	//if(!userDirectory.canRead()) {
    	 //  File userDirectory = new File("C:\\Users\\Michelle\\eclipse-workspace\\HEALT_APP\\python\\notesMusiques");
    	 File userDirectory = new File("audio");
    	//}
    	fileChooser.setInitialDirectory(userDirectory);
   

    	//Choose the file
    	File chosenFile = fileChooser.showOpenDialog(null);
    	//Make sure a file was selected, if not return default
    	String path;
    	if(chosenFile != null) {
    	    path = chosenFile.getPath();
    	    System.out.println(path);
    	    
    	    //PROCESSING FILE
    	    String anyCommand="cd python";
    	    String command2 =" python Green.py";
    	    //Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + anyCommand  );
			//ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "cd python", "python Green.py");
    	    




    	  //  ProcessBuilder builder = new ProcessBuilder("python","C:\\Users\\Michelle\\eclipse-workspace\\HEALT_APP\\python\\Green.py", path).inheritIO();
    	    ProcessBuilder builder = new ProcessBuilder("python","python\\Green.py", path).inheritIO();
    	    
    	    try {
				Process p=builder.start();
				/*p.waitFor();
				BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = "";
				while ((line = bfr.readLine()) != null) {
				System.out.println(line);
				if(p.waitFor()==1) System.out.println("elaboration is completed");
				} */
			
				//Thread.sleep(3000);
				//p.destroy();
				
			} catch (IOException e) /*|InterruptedException */ {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
    	   /* try {
    	    	 ProcessBuilder Process_Builder = new
                         ProcessBuilder("python","HEALT_APP/src/Green.py")
                         .inheritIO();

    	    	 Process Demo_Process = Process_Builder.start();
    	    	 Demo_Process.waitFor();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
