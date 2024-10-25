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

public class Exercise16_1 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		BorderPane pane = new BorderPane();
		Rectangle rectangle = new Rectangle(0,0,25,50);
		Text thisText = new Text(20,20,"programming is fun");
		thisText.setFill(Color.BLACK);
		thisText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		rectangle.setFill(Color.BLACK);
		HBox hBoxForBottom= new HBox(20);
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		hBoxForBottom.getChildren().addAll(btLeft, btRight);
		pane.setBottom(hBoxForBottom);
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Excercise 15-12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

