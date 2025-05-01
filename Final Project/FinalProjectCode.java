import java.util.Random;

import javafx.util.*;
import java.io.*;
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

public class FinalProjectCode extends Application {
	
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


class MonthController extends Pane{


	public double size;
	public double centerX;
	public double centerY;
	public double changeX;
	public double changeY;
	public boolean first = true;
	public MonthController() {
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


class SaveManager {
	
	public String saveName = "";
	public File saveFile;
	public MonthController[] months;
	
		public SaveManager() throws IOException {
			
			saveFile = new File(saveName+".dat");
			DataOutputStream output;
			if (saveFile.exists()) {
				output = new DataOutputStream(new FileOutputStream(saveName+".dat",true));
			}
			else {
				output = new DataOutputStream(new FileOutputStream(saveName+".dat",false));
			}
			
			FileInputStream inputStream = new FileInputStream(saveName+".dat");
		
			
			
			byte[] buffer = new byte[(int) Math.ceil(new File(saveName+".dat").length())];
			int bytesRead;
			
			
			
			while ((bytesRead = inputStream.read(buffer)) != -1) {
	            // Process the read bytes in 'buffer'
	            for (int i = 0; i < bytesRead; i++) {
	            	
	            	byte tempData = buffer[i];
	            	System.out.println((char) tempData);
	    			tempData=(byte)(tempData+5);
	    			System.out.println((char) tempData);
	    			
	    			output.write(tempData);
	            }
			
		}
	
		}
}
class NewDay extends Button{
	public int day;
	public boolean ABDay;
	public double centerY;
	public double changeX;
	public double changeY;

	NewDay(){
		
	
	}
}
