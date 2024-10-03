import java.util.Random;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class Exercise15_3 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane stackPane = new StackPane();
		Random rand = new Random();
		stackPane.getChildren().add(new MyCircle());
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		hBox.getChildren().add(btLeft);
		hBox.getChildren().add(btRight);
		hBox.getChildren().add(btUp);
		hBox.getChildren().add(btDown);
		stackPane.getChildren().add(hBox);
		BorderPane bp = new BorderPane();
		bp.setCenter(stackPane);
		bp.setBottom(hBox);
		Scene scene = new Scene(bp, 400, 400);
		primaryStage.setTitle("Excercise 15_03"); // Set the stage title
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

class MyCircle extends Pane {
	public double radius;
	public double centerX;
	public double centerY;
	public MyCircle() {
		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		radius = Math.min(getWidth(), getHeight()) * 0.4;
		paint();
	}
	
	private void paint() {
		

		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		radius = Math.min(getWidth(), getHeight()) * 0.1;
		
		Circle circle = new Circle(centerX, centerY, radius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		getChildren().clear();
		getChildren().add(circle); 
		}
	
	
	public void setX(double newX) {
		centerX = newX;
		paint();
	}
	
	
	public void setY(double newY) {
		centerY = newY;
		paint();
	}
	public void moveX(double changeX) {
		
		paint();
	}
public void moveY(double changeY) {
		
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
