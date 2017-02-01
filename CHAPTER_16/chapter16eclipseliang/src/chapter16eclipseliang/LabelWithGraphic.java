package chapter16eclipseliang;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LabelWithGraphic extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		ImageView us = new ImageView(new Image("image/us.gif"));
		Label lbl = new Label("US\n50 States", us);
		lbl.setStyle("-fx-border-color: green; -fx-border-width: 2");
		lbl.setContentDisplay(ContentDisplay.BOTTOM);
		lbl.setTextFill(Color.RED);

		Label lbl2 = new Label("Circle", new Circle(50, 50, 25));
		lbl2.setContentDisplay(ContentDisplay.TOP);
		lbl2.setTextFill(Color.ORANGE);

		Label lbl3 = new Label("Rectangle", new Rectangle(10, 10, 50, 25));
		lbl3.setContentDisplay(ContentDisplay.RIGHT);
		lbl3.setWrapText(true);

		Label lbl4 = new Label("Ellipse", new Ellipse(50, 50, 50, 25));
		lbl4.setContentDisplay(ContentDisplay.LEFT);
		lbl4.setWrapText(true);

		Ellipse ellipse = new Ellipse(50, 50, 50, 25);
		ellipse.setStroke(Color.GREEN);
		ellipse.setFill(Color.WHITE);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(ellipse, new Label("JavaFX"));
		Label lbl5 = new Label("A pane inside a label", stackPane);
		lbl5.setContentDisplay(ContentDisplay.BOTTOM);
		lbl5.setWrapText(true);

		HBox pane = new HBox(20);
		pane.getChildren().addAll(lbl, lbl2, lbl3, lbl4, lbl5);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 700, 150);
		primaryStage.setTitle("LabelWithGraphic"); // Set the stage title
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
