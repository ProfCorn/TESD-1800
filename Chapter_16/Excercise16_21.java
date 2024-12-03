



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
	public BorderPane StartTextPane = new BorderPane();
	public int TextInt = 0;
	public Timeline timeline;
    String file = ("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
    MediaPlayer mediaPlayer = new MediaPlayer(new Media(file));
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		tf.setEditable(true);
		tf.setStyle("-fx-test-fill: red");
		
		TimerHandler sth = new TimerHandler();
        timeline = new Timeline(
        new KeyFrame(Duration.millis(1000), sth));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.stop();
        tf.setOnAction(new StartTextHandler());
		startText.setFill(Color.BLACK);
		startText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 20));
		StartTextPane.setStyle("-fx-border-color: black");
		StartTextPane.setLeft(startText);
		StartTextPane.setRight(tf);
		Scene scene = new Scene(StartTextPane, 300, 200);
		primaryStage.setTitle("Excercise 16-21"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		

		
	}
	
	class StartTextHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			
			if (isInteger(tf.getText())) {
				startText.setText(tf.getText());
				tf = new TextField();
				timeline.playFromStart();
				StartTextPane.setRight(null);
				startText.setFont(Font.font("Times new Roman", FontWeight.NORMAL, 60));
				
			}
		
		}
	}
	
	class TimerHandler implements EventHandler<ActionEvent>{
		@Override 
		public void handle(ActionEvent e) {
			
			if (Integer.parseInt(startText.getText())>0){
				startText.setText((Integer.parseInt(startText.getText()) - 1) + "");
			}
			else {
				timeline.pause();
				mediaPlayer.play();
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
