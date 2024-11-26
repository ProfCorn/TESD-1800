


import javafx.util.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;



public class Excercise16_21 extends Application {
	
	public Text timerText = new Text(20,20,"programming is fun");
	public Text startText = new Text(20,20,"Enter Time: ");
	public TextField tf = new TextField();
	public int TextInt = 0;

	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		TextField startTime = new TextField("");
		startTime.setEditable(true);
		startTime.setStyle("-fx-test-fill: red");
		//startTime.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		
        File file = new File("/Users/luizsa/GitHub/java/intro-to-java-10th-edition/src/audio/us.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
        StartTextHandler sth = new StartTextHandler();
        Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(1000), sth));
        timeline.stop();
		startText.setFill(Color.BLACK);
		startText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		BorderPane StartTextPane = new BorderPane();
		StartTextPane.setStyle("-fx-border-color: black");
		StartTextPane.setLeft(startText);
		StartTextPane.setRight(startTime);
		Scene scene = new Scene(StartTextPane, 300, 200);
		primaryStage.setTitle("Excercise 16-21"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		

		
	}
	
	class StartTextHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			
			
			if (isInteger(tf.getText())) {
				TextInt = Integer.parseInt(tf.getText());
                //tfCountDown.setText((Integer.parseInt(tfCountDown.getText()) - 1) + "");

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
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
}


