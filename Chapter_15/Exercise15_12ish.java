package a;



import javafx.animation.*;
import javafx.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
		ObservableList<Double> list = polygon.getPoints();
		list.clear();
		double centerX = stackPane.getWidth() / 2, centerY = stackPane.getWidth() / 2;
		double radius = Math.min(400, 400) * 0.4;
		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		polygon.setRotate(-162);
		rectangle.setFill(Color.BLACK);
		stackPane.getChildren().add(polygon);
		stackPane.getChildren().add(rectangle);
		FadeTransition ft = new FadeTransition(Duration.seconds(2), rectangle);
		ft.setFromValue(1);
		ft.setToValue(0.01);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		PathTransition pt = new PathTransition();
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setDuration(Duration.seconds(4));
		pt.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		double x = 0;
		pt.play();
		Scene scene = new Scene(stackPane, 400, 400);
		primaryStage.setTitle("Excercise 15-12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		stackPane.setOnMouseClicked(e->{
			if (e.getButton() == MouseButton.PRIMARY) {
				pt.play();
			}
			else {
				pt.pause();
			}
		});
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
