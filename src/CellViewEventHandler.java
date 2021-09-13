import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class CellViewEventHandler implements EventHandler<ActionEvent> {
	
	private ToggleButton cellView;
	private NonogramCreatorModel model;
	private int rowIdx;
	private int colIdx;
	
	public CellViewEventHandler(ToggleButton cellView, NonogramCreatorModel model, int rowIdx, int colIdx) {
		this.cellView = cellView;
		this.model = model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
		
	}
	
	

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		model.setCell(rowIdx, colIdx, cellView.isSelected());
		
	}

}
