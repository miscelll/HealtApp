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

public class HelloWord extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
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
