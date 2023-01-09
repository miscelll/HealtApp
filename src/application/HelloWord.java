package application;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


//The main class for a JavaFX application extends the javafx.application.Application class. 
public class HelloWord extends Application{

	@Override
	//The start() method is the main entry point for all JavaFX applications.
	public void start(Stage primaryStage) throws Exception {
	
		try {
			
			//JavaFX application defines the user interface container by means of a stage and a scene. 
			//The JavaFX Stage class is the top-level JavaFX container. 
			//The JavaFX Scene class is the container for all content.
			
			//FXMLLoader to load the Main.fxml file
			//"Parent":A simple Node that can hold other Nodes as children.Every Scene needs exactly one Parent as the root.
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
			
			// Stage and Scene will be filled by the fxml file, specifying the style of the Stage
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.setScene(scene);
			System.out.println("App is running");
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show(); 
			
			
		}catch(Exception e){
			
			
		}
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
		
	}
}
