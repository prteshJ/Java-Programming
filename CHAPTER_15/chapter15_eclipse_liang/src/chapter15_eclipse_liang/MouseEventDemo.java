package chapter15_eclipse_liang;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Programming is fun");
		pane.getChildren().addAll(text);

		text.setOnMouseDragged(e -> {
			text.setX(e.getX());
			text.setY(e.getY());
		});

		/******* USING ANONYMOUS CLASSES *********************
		text.setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				text.setX(event.getX());
				text.setY(event.getY());
			}
		});
		 *********************************************************/

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("MouseEventDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * Main class only needed if IDE has poor JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
