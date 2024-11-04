
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


public class Exercise16_1 extends Application {
	
	public Text thisText = new Text(20,20,"programming is fun");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		BorderPane pane = new BorderPane();
		Rectangle rectangle = new Rectangle(0,0,25,50);
				thisText.setFill(Color.BLACK);
		thisText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		Pane TextPane = new Pane();
		TextPane.setStyle("-fx-border-color: black");
		TextPane.getChildren().add(thisText);
		pane.setCenter(TextPane);
		HBox hBoxForBottom = new HBox(20);
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		hBoxForBottom.getChildren().addAll(btLeft, btRight);
		hBoxForBottom.setAlignment(Pos.CENTER);
		pane.setBottom(hBoxForBottom);
		btLeft.setOnAction(new LeftHandler());
		btRight.setOnAction(new RightHandler());
		
		HBox hBoxForTop = new HBox(21);
		RadioButton btRed = new RadioButton("Red");
		btRed.setOnAction(e ->thisText.setFill(Color.RED));
		Label lbRed = new Label("Red",btRed);
		RadioButton btYellow = new RadioButton("Yellow");
		btYellow.setOnAction(e ->thisText.setFill(Color.YELLOW));
		Label lbYellow = new Label("Yellow",btYellow);
		RadioButton btBlack = new RadioButton("Black");
		btBlack.setOnAction(e ->thisText.setFill(Color.BLACK));
		Label lbBlack = new Label("Black",btBlack);
		RadioButton btOrange = new RadioButton("Orange");
		btOrange.setOnAction(e ->thisText.setFill(Color.ORANGE));
		Label lbOrange = new Label("Orange",btOrange);
		RadioButton btGreen = new RadioButton("Green");
		btGreen.setOnAction(e ->thisText.setFill(Color.GREEN));
		Label lbGreen = new Label("Green",btGreen);
		hBoxForTop.getChildren().addAll(btRed, btYellow, btBlack, btOrange, btGreen);
		hBoxForBottom.setAlignment(Pos.CENTER);
		pane.setTop(hBoxForTop);
		 
		ToggleGroup groupForColors = new ToggleGroup();
		btRed.setToggleGroup(groupForColors);
		btYellow.setToggleGroup(groupForColors);
		btBlack.setToggleGroup(groupForColors);
		btOrange.setToggleGroup(groupForColors);
		btGreen.setToggleGroup(groupForColors);

		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Excercise 15-12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	class RightHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			if(thisText.getX()+10<400) {
				thisText.setX(thisText.getX()+ 10);
				}
			}
		
	}
	class LeftHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			if(thisText.getX()-10>0) {
				thisText.setX(thisText.getX() - 10);
			}		
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
