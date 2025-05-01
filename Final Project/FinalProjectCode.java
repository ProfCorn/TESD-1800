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
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		
		double BUTTON_PADDING = 5;
		
		int BUTTONS_PER_LINE = 7;
		
		int TotalDays = 31;
		
		int DayOn = 0;
		
		GridPane grid = new GridPane();
	    grid.setPadding(new Insets(BUTTON_PADDING));
	    grid.setHgap(BUTTON_PADDING);
	    grid.setVgap(BUTTON_PADDING);

	    while (TotalDays > 0) {
	        for (int c = 0; c < BUTTONS_PER_LINE; c++) {
	            DayOn = DayOn+1;
	            TotalDays = TotalDays-1;
	            NewDay Day = new NewDay(DayOn);
	            grid.add(Day, c, Math.floorDiv(DayOn-1, 7));
	            if(TotalDays == 0) {
	            	
	            	c = BUTTONS_PER_LINE;
	            	
	            }
	        }
	    }
		

		StackPane WeekOne = new StackPane();
		for(int i = 0; i<7; i++) {
			NewDay FirstTest = new NewDay(21+i);
			Random rand = new Random();
			WeekOne.getChildren().add(FirstTest);
			FirstTest.setTranslateX(0);
			FirstTest.setTranslateY(0);
		}
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.TOP_LEFT);
		BorderPane bp = new BorderPane();
		bp.setTop(grid);
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

	NewDay(String string){
		
		this.setText(string);
		

		this.setMinSize(350/7, 350/7);
		this.setMaxSize(350/7, 350/7);
	
	}
	
	NewDay(int DayInt){
		
		day = DayInt;
		
		this.setText(""+day);


		this.setMinSize(350/7, 350/7);
		this.setMaxSize(350/7, 350/7);
		
	}
}
