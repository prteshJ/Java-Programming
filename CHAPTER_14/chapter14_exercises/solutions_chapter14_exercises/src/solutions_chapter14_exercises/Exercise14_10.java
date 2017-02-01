package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

// creating a cylinder 

public class Exercise14_10 extends Application {
	private final static int CENTER_X = 100;
	private final static int CENTER_Y = 45;
	private final static int RADIUS_X = 60;
	private final static int RADIUS_Y = 30;
	private final static int CYLINDER_HEIGHT = 130;

	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 30, 0, 10));

		// create a ellipse // needs startX,startY,radiusX,radiusY
		Ellipse topEllipse = new Ellipse(CENTER_X, CENTER_Y, RADIUS_X, RADIUS_Y);
		topEllipse.setFill(Color.WHITE);
		topEllipse.setStroke(Color.BLACK);

		pane.getChildren().add(topEllipse); // add topEllipse to Pane

		Arc dashedArc = new Arc(CENTER_X, CENTER_Y + CYLINDER_HEIGHT, RADIUS_X, RADIUS_Y, 0, 180);
		dashedArc.setFill(Color.WHITE);
		dashedArc.setStroke(Color.BLACK);
		dashedArc.getStrokeDashArray().addAll(6.0, 21.0);

		pane.getChildren().add(dashedArc); // add dashedArc to Pane

		Arc solidArc = new Arc(CENTER_X, CENTER_Y + CYLINDER_HEIGHT, RADIUS_X, RADIUS_Y, 180, 180);
		solidArc.setFill(Color.WHITE);
		solidArc.setStroke(Color.BLACK);
		pane.getChildren().add(solidArc); // add solidArc to Pane

		Line cylinderStartLine = new Line(CENTER_X - RADIUS_X, CENTER_Y, CENTER_X - RADIUS_X,
				CENTER_Y + CYLINDER_HEIGHT);
		pane.getChildren().add(cylinderStartLine); // add cylinderStartLine to
													// Pane

		Line cylinderLastLine = new Line(CENTER_X + RADIUS_X, CENTER_Y, CENTER_X + RADIUS_X,
				CENTER_Y + CYLINDER_HEIGHT);
		pane.getChildren().add(cylinderLastLine); // add cylinderLastLine to
													// Pane

		Scene scene = new Scene(pane); // Drop Pane onto Scene
		primaryStage.setTitle("Exercise14_10");
		primaryStage.setScene(scene); // Drop Scene onto Stage
		primaryStage.show(); // Display Stage
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}