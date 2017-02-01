package chapter15_eclipse_liang;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimation extends Application{

	@Override// Override the start method in the Application class
	public void start(Stage primaryStage) {	
		ClockPane clock = new ClockPane(); // Create a clock

		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime(); // Set a new clock time
		};

		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation

		// Create a scene and place it in the stage
		Scene scene = new Scene(clock, 250, 250);
		primaryStage.setScene(scene); // Set the stage title
		primaryStage.setTitle("ClockAnimation"); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * Main class only needed if IDE has poor JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
