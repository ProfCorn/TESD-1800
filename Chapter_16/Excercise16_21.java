
package a;


import javafx.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.geometry.Pos;
import javafx.event.*;


public class Exercise16_21 extends Application {
	
	public Text timerText = new Text(20,20,"programming is fun");
	public Text startText = new Text(20,20,"programming is fun");

	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		startText.setFill(Color.BLACK);
		startText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		Pane StartTextPane = new Pane();
		StartTextPane.setStyle("-fx-border-color: black");
		StartTextPane.getChildren().add(startText);
		TextField tf = new TextField();
		
		
		 
		

		Scene scene = new Scene(StartTextPane, 400, 400);
		primaryStage.setTitle("Excercise 16-21"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	class RightHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			
			}
		
	}
	
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */

	public static void main(String[] args) {
		launch(args);
	}
}
