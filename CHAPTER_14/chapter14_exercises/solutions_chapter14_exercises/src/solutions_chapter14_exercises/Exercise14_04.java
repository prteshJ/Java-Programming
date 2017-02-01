package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_04 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Text[] textContainer = new Text[5]; // Stores Node Text

		HBox pane = new HBox(); // Pane for storing nodes horizontally
		pane.setPadding(new Insets(30, 0, 30, 0)); // Set top & bottom pane spacing

		// Set desired node properties & add it to pane
		int counter = 0;
		while (counter < 5) {
			textContainer[counter] = new Text("Java");
			textContainer[counter].setFont(Font.font("TimesNewRoman", FontWeight.BOLD, FontPosture.ITALIC, 22));
			textContainer[counter].setStroke(new Color(Math.random(), Math.random(), Math.random(), Math.random()).brighter());
			textContainer[counter].setRotate(90);
			pane.getChildren().add(textContainer[counter]);
			counter++;
		}

		// Add Pane to Scene
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_04");
		primaryStage.setScene(scene); // Add Scene to Stage
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
