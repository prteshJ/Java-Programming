package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_07 extends Application {

	private static int paneWidth = 250;
	private static int paneHeight = 250;

	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				TextField text = new TextField(Integer.toString((int) (Math.random() * 2)));

				/*
				 * Make width & height of textfield same so that it is a square
				 */
				text.setAlignment(Pos.CENTER); // each string is centered in
												// textfield
				text.setMinWidth(paneWidth / 10.0);
				text.setMinHeight(paneHeight / 10.0);

				// add node to pane at respective (row, column)
				pane.add(text, col, row);
			}
		}

		// Put Pane on Scene
		Scene scene = new Scene(pane, paneWidth, paneHeight);
		primaryStage.setTitle("Exercise14_07");
		primaryStage.setScene(scene); // Put Scene on Stage
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
