package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise14_22 extends Application {

	private static final double PANE_WIDTH = 400;
	private static final double PANE_HEIGHT = 400;
	private static final double OFFSET = 80;

	@Override
	public void start(Stage primaryStage) {
		Pane randomCircleContainer = new Pane();

		ArrayList<Shape> randomCircleComponents = new ArrayList<>();

		Circle circle1 = new Circle(15);
		circle1.setFill(Color.TRANSPARENT);
		circle1.setStroke(Color.BLACK);
		circle1.setCenterX(Math.random() * (PANE_WIDTH - OFFSET));
		circle1.setCenterY(Math.random() * (PANE_HEIGHT - OFFSET) + OFFSET / 4);
		circle1.setFill(Color.TRANSPARENT);
		randomCircleComponents.add(circle1);

		Circle circle2 = new Circle(15);
		circle2.setFill(Color.TRANSPARENT);
		circle2.setStroke(Color.BLACK);
		circle2.setCenterX(Math.random() * (circle1.getCenterX() * 5 + OFFSET / 2) + OFFSET / 10);
		circle2.setCenterY(Math.random() * (circle1.getCenterY() + OFFSET));
		randomCircleComponents.add(circle2);

		Line connectingTwoCircles = new Line();
		connectingTwoCircles.setStartX(circle1.getCenterX() + circle1.getRadius());
		connectingTwoCircles.setStartY(circle1.getCenterY());
		connectingTwoCircles.setEndX(circle2.getCenterX() - circle2.getRadius());
		connectingTwoCircles.setEndY(circle2.getCenterY());
		randomCircleComponents.add(connectingTwoCircles);

		randomCircleContainer.getChildren().addAll(randomCircleComponents);

		Scene connectingCircles = new Scene(randomCircleContainer);
		primaryStage.setTitle("Exercise14_22");
		primaryStage.setScene(connectingCircles);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}