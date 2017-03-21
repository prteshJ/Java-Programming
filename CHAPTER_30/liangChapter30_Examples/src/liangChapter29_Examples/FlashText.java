package liangChapter29_Examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application{
	private String text = "";

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Label lblText = new Label("Programming is fun");
		pane.getChildren().add(lblText);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						if (lblText.getText().trim().length() == 0)
							text = "Welcome";
						else 
							text = "";

						Platform.runLater(new Runnable() { // Run from JavaFX GUI

							@Override
							public void run() {		
								lblText.setText(text);
							}
						});
						Thread.sleep(200);
					}
				}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}						
		}).start();

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setTitle("FlashText"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
