import java.util.Random;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.*;

public class Exercise14_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane stackPane = new StackPane();
		// Remember to make MyClock() Random
		//stackPane.getChildren().add(new MyClock());
		Text thisText = new Text(20,20,"STOP");
		thisText.setFill(Color.WHITE);
		thisText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 80));
		stackPane.getChildren().add(thisText);
		Scene scene = new Scene(stackPane, 400, 400);
		primaryStage.setTitle("Excercise 14-15"); // Set the stage title
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

class MyClock extends Pane {
	public int hour;
	public int minute;
	public int second;
	public boolean hourHandVisable;
	public boolean minuteHandVisable;
	public boolean secondHandVisable;
	public MyClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paint();
	}
	private void paint() {
		// Create a circle
		Random rand = new Random();
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;
		Circle circle = new Circle(centerX, centerY, radius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		
		
		
		
		getChildren().clear();
		getChildren().add(circle); 
//		getChidlren().add(hourHand);
//		getChidlren().add(minuteHand);
//		getChidlren().add(secondHand);
		}
	
	
	public void setHour(int hour) {
		
		paint();
	}
	
	
	public void setMinute(int minute) {
		
		paint();
	}
	public void setSecond(int second) {
		
		paint();
	}
}
