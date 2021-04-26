import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class NonogramCreatorView {
	
	private BorderPane borderPane;
	
	public NonogramCreatorView(NonogramCreatorModel model, int cellLength) {
		SavePuzzleView puzzle = new SavePuzzleView(model);
		CellGridView cells = new CellGridView(model, cellLength);
		
		borderPane = new BorderPane();
		BorderPane.setAlignment(cells.getPane(), Pos.CENTER);
		borderPane.setCenter(cells.getPane());
		BorderPane.setAlignment(puzzle.getPane(), Pos.BOTTOM_LEFT);
		borderPane.setBottom(puzzle.getPane());
	}
	
	public Pane getPane() {
		return borderPane;
	}

}
