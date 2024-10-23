package a;




import javafx.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.*;

public class Exercise15_12ish extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane stackPane = new StackPane();
		Rectangle rectangle = new Rectangle(0,0,25,50);
		Polygon polygon = new Polygon();
		polygon.setStroke(Color.BLACK);
		polygon.setFill(null);
		Text thisText = new Text(20,20,"STOP");
		thisText.setFill(Color.BLACK);
		thisText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 80));
		stackPane.getChildren().add(thisText);
		ObservableList<Double> list = polygon.getPoints();
		list.clear();
		double centerX = stackPane.getWidth() / 2, centerY = stackPane.getWidth() / 2;
		polygon.setRotate(-162);
		rectangle.setFill(Color.BLACK);
		stackPane.getChildren().add(polygon);
		stackPane.getChildren().add(rectangle);
		HBox hbox= new HBox(20);
		Scene scene = new Scene(stackPane, 400, 400);
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

class MyPolygon extends Pane {
	Polygon polygon = new Polygon();
	private void paint() {
		// Create a polygon and place polygon to pane
		
		//polygon.setStroke(Color.BLACK);
		//polygon.setFill(null);
		ObservableList<Double> list = polygon.getPoints();
		list.clear();
		double centerX = getWidth() / 2-30, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		polygon.setRotate(-162);
		getChildren().clear();
		getChildren().add(polygon); 
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
	public Shape getPolygon() {
		return polygon;
	}
}
