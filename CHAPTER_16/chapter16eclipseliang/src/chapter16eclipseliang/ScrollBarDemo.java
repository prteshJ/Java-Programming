package chapter16eclipseliang;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Text text = new Text(20, 20, "JavaFX Programming");

		ScrollBar sbHorizontal = new ScrollBar();
		ScrollBar sbVertical   = new ScrollBar();
		sbVertical.setOrientation(Orientation.VERTICAL);

		// Create a text in a pane
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);

		// Create a border pane to hold text and scroll bars
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(sbHorizontal);
		pane.setRight(sbVertical);

		// Listener for horizontal scroll bar value change
		sbHorizontal.valueProperty().addListener(ov -> 
		text.setX(sbHorizontal.getValue() * paneForText.getWidth() / 
				sbHorizontal.getMax()));

		// Listener for vertical scroll bar value change
		sbVertical.valueProperty().addListener(ov -> 
		text.setY(sbVertical.getValue() * paneForText.getHeight() /
				sbVertical.getMax()));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("ScrollBarDemo"); // Set the stage title
		primaryStage.setScene(scene);
		primaryStage.show(); // Display the stage
	}

	/**
	 * Main method
	 * Only needed if IDE has poor JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}