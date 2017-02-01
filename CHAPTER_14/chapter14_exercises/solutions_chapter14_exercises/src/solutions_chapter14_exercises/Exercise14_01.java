package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_01 extends Application {

	@Override // Overriding start method in abstract Application class
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane(); // creates a Grid Pane
		pane.setHgap(5); // set horizontal spacing amongst Nodes

		// Adding images to the pane
		ImageView image1 = new ImageView(new Image("/image/uk.gif"));
		pane.add(image1, 0, 0);
		ImageView image2 = new ImageView(new Image("/image/ca.gif"));
		pane.add(image2, 1, 0);
		ImageView image3 = new ImageView(new Image("/image/china.gif"));
		pane.add(image3, 0, 1);
		ImageView image4 = new ImageView(new Image("/image/us.gif"));
		pane.add(image4, 1, 1);

		// Creating a Scene
		Scene scene = new Scene(pane); // Placing pane in a Scene
		primaryStage.setTitle("Exercise14_01");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
