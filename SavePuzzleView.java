import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SavePuzzleView {
	
	private static final String PROMPT = "Enter file name";
	private static final int SPACING = 10;
	private HBox hbox;
	
	public SavePuzzleView(NonogramCreatorModel model) {
		hbox = new HBox(SPACING);
		hbox.setAlignment(Pos.CENTER);
		Button savePuzzle = new Button("Save Puzzle");
		TextField fileName = new TextField();
		fileName.setPromptText(PROMPT);
		hbox.getChildren().add(fileName);
		savePuzzle.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String s = fileName.getText();
				try {
					model.savePuzzle(s);
				}
				catch (IOException e) {
					Alert alert1 = new Alert(AlertType.ERROR, "File could not be created.");
					alert1.showAndWait();
				}
			}
		
		});
		hbox.getChildren().add(savePuzzle);
		
		
		
		
	}
	
	public Pane getPane() {
		
		return hbox;
		
	}

}
