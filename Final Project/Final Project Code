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
import javafx.event.*;

public class Exercise15_3 extends Application {
	//When at home add this to virtual network
	//--module-path C:\Users\User\Desktop\Randy_School\Java\JavaFX\javafx-sdk-23\lib --add-modules javafx.controls,javafx.fxml
	//
	NewDay circle = new NewDay();
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane stackPane = new StackPane();
		Random rand = new Random();
		Button CIRCLEBUTTON = new Button ("test");
		CIRCLEBUTTON.setMinSize(350/7, 350/7);
		CIRCLEBUTTON.setMaxSize(350/7, 350/7);
		stackPane.getChildren().add(CIRCLEBUTTON);
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btLeft = new Button("Left");
		btLeft.setOnAction(new LeftHandler());
		Button btRight = new Button("Right");
		btRight.setOnAction(new RightHandler());
		Button btUp = new Button("Up");
		btUp.setOnAction(new UpHandler());
		Button btDown = new Button("Down");
		btDown.setOnAction(new DownHandler());
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
	class RightHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			circle.moveX(10.0);
		}
		
	}
	class LeftHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			circle.moveX(-10.0);
		}
		
	}
	class DownHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			circle.moveY(10.0);
		}
		
	}
	class UpHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			circle.moveY(-10.0);
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
//CASDFAsd

//Create a Month Manager Which Creates Week managers which creates days.

//asdfasdfas
class NewDay extends Pane {
	public double size;
	public double centerX;
	public double centerY;
	public double changeX;
	public double changeY;
	public boolean first = true;
	public NewDay() {
		paint();
	}
	
	private void paint() {
		
		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		first = false;
		
		Button NewButton = new Button("Day");
		NewButton.setMinSize(size, size);
		NewButton.setMaxSize(size+1, size+1);
		getChildren().clear();
		getChildren().add(NewButton); 
		}
	
	
	public void setX(double newX) {
		centerX = newX;
		paint();
	}
	
	
	public void setY(double newY) {
		centerY = newY;
		paint();
	}
	public void moveX(double ChangeX) {
		if(centerX+changeX + ChangeX<=getHeight()-size&&centerX+changeX + ChangeX>=0+size) {
		changeX = changeX + ChangeX;
		paint();
		}
	}
	public void moveY(double ChangeY) {
		if(centerY+changeY + ChangeY<=getWidth()-size&&centerY+changeY + ChangeY>=0+size) {
		changeY = changeY + ChangeY;
		paint();
		}
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
