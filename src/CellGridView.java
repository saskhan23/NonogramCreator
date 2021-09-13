import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CellGridView {
	private GridPane gridPane;
	
	public static void main (String [] args) {
		for (int i = 0; i <= 7; ++i) {
			System.out.println(i);
		}
	}
	
	public CellGridView(NonogramCreatorModel model, int cellLength) {
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
//		ToggleButton btn = new ToggleButton();
//		btn.setMaxHeight(cellLength);
//		btn.setMinHeight(cellLength);
//		btn.setPrefHeight(cellLength);
//		btn.setMaxWidth(cellLength);
//		btn.setMinHeight(cellLength);
//		btn.setPrefWidth(cellLength);
		
		for (int i = 0; i <= model.getNumRows(); ++i) {
			for (int j = 0; j <= model.getNumRows(); ++j) {
				ToggleButton btn = new ToggleButton();
				btn.setMaxHeight(cellLength);
				btn.setMinHeight(cellLength);
				btn.setPrefHeight(cellLength);
				btn.setMaxWidth(cellLength);
				btn.setMinHeight(cellLength);
				btn.setPrefWidth(cellLength);
			gridPane.add(btn, j, i);
			CellViewEventHandler g = new CellViewEventHandler(btn, model, j, i);
			btn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle (ActionEvent Event) {
					g.handle(Event);
					
				}
				
			});
			}
			
		}
		

		
		//numRows
	}
	
	public Pane getPane() {
		return gridPane;
	}
	
	

}
