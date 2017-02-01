package chapter16eclipseliang;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TextAreaDemo extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Declare and create a description pane
		DescriptionPane descriptionPane = new DescriptionPane();

		// Set title, text, and image in the description pane
		descriptionPane.setTitle("Canada");
		String description = "The Canadian national flag ...";
		descriptionPane.setImageView(new ImageView("image/ca.gif"));
		descriptionPane.setDescription(description);

		// Create a scene and place it in the stage
		Scene scene = new Scene(descriptionPane, 450, 125);
		primaryStage.setTitle("TextAreaDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
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