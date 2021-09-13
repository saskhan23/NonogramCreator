import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final String TITLE = "Nonogram Creator";
	private static final boolean RESIZEABLE = false;
	private static final String STYLE_SHEET = "crimson-cream.css";
	private Stage primaryStage;
	
	public static void main (String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OptionsView newView = new OptionsView(this);
		Scene scene = new Scene(newView.getPane());
		
		this.primaryStage = primaryStage;
		primaryStage.setScene(scene);
		primaryStage.setTitle(TITLE);
		primaryStage.setResizable(RESIZEABLE);
		primaryStage.show();
		

		
	}
	
	public void startNonogramCreator(int numRows, int numCols, int cellLength) {
		NonogramCreatorModel model = new NonogramCreatorModel(numRows, numCols);
		NonogramCreatorView view = new NonogramCreatorView(model, cellLength);
		
		Scene newScene = new Scene(view.getPane());
		primaryStage.setScene(newScene);
		newScene.getStylesheets().add(STYLE_SHEET);
		primaryStage.show();
		
	}

}
