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

public class Exercise14_28 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane stackPane = new StackPane();
		Random rand = new Random();
		stackPane.getChildren().add(new MyClock(rand.nextInt(12),rand.nextInt(60),rand.nextInt(60)));
		Scene scene = new Scene(stackPane, 400, 400);
		primaryStage.setTitle("Excercise 14-28"); // Set the stage title
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
	public MyClock() {
		Random rand = new Random();
		this.hour = rand.nextInt(12);
		this.minute = rand.nextInt(2);
		this.second = rand.nextInt(60);
		paint();
	}
	private void paint() {
		if (this.minute%2!=1) {
			this.minute = 30;
		}
		hourHandVisable = true;
		minuteHandVisable = true;
		// Create a circle
		double centerXC = getWidth() / 2, centerYC = getHeight() / 2;
		double radiusC = Math.min(getWidth(), getHeight()) * 0.4;
		Circle circle = new Circle(centerXC, centerYC, radiusC);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		//create Hour Hand
		Line hourHand = new Line(centerXC, centerYC, centerXC + radiusC *0.4* Math.cos(2 * this.hour * Math.PI / 12), centerYC - radiusC * 0.4 * Math.sin(2 * this.hour * Math.PI / 12));
		Line minuteHand = new Line(centerXC, centerYC, centerXC + radiusC *0.7* Math.cos((this.minute+0.5) * Math.PI), centerYC - radiusC * 0.7 * Math.sin( (this.minute+0.5) * Math.PI));		
		
		getChildren().clear();
		getChildren().add(circle); 
		if (hourHandVisable)
			getChildren().add(hourHand);
		if (minuteHandVisable)
			getChildren().add(minuteHand);
//		getChildren().add(secondHand);
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
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
