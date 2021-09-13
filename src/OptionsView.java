import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class OptionsView  {
	
	private static final int MIN_ROWS = 5;
	private static final String BUTTON_LABEL = "Start";
	private static final int SPACING = 10;
	private GridPane gridPane;
	
	private static final int HORIZONTAL_GAP = 10;
	private static final int VERTICAL_GAP = 10;
	
	public OptionsView (Main main) {
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(HORIZONTAL_GAP);
		gridPane.setVgap(VERTICAL_GAP);
		gridPane.setPadding(new Insets (10, 10, 10, 10));
		
		Label rowNum = new Label ("Number of rows: ");
		gridPane.add(rowNum, 0, 0);
		
		Spinner<Integer> rowSlider = new Spinner<>(5, 25, 10);
		gridPane.add(rowSlider, 1, 0);
		
		Label colNum = new Label ("Number of columns: ");
		gridPane.add(colNum, 0, 1);
		
		Spinner<Integer> columnSlider = new Spinner<>(5, 25, 10);
		gridPane.add(columnSlider, 1, 1);
		
		Label Cell = new Label ("Cell side length (pixels): ");
		gridPane.add(Cell, 0, 2);
		
		Spinner<Integer> cellLength = new Spinner<>(20, 30, 50);
		gridPane.add(cellLength, 1, 2);
		
		Button stBtn = new Button(BUTTON_LABEL);
		gridPane.add(stBtn, 1, 3);
		
		stBtn.setOnAction(new EventHandler<ActionEvent>() {
		
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer rowInput;
				rowInput = rowSlider.getValue();
				
				Integer colInput;
				colInput = columnSlider.getValue();
				
				Integer cellInput;
				cellInput = cellLength.getValue();
				
				main.startNonogramCreator(rowInput, colInput, cellInput);
				
				
				
				
				
			}
			
		

		});
		
		
	}
	
	public Pane getPane() {
		return gridPane;
	}



}
