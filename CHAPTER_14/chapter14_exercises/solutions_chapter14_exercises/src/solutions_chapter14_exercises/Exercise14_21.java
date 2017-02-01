package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_21 extends Application {

	private static double PANE_WIDTH = 400;
	private static double PANE_HEIGHT = 400;
	private static double OFFSET = 80;

	@Override
	public void start(Stage primaryStage) {
		Pane randomCircleContainer = new Pane();

		ArrayList<Shape> randomCircleComponents = new ArrayList<>();

		Circle circle1 = new Circle(15);
		circle1.setCenterX(Math.random() * (PANE_WIDTH - OFFSET));
		circle1.setCenterY(Math.random() * (PANE_HEIGHT - OFFSET) + OFFSET / 4);
		randomCircleComponents.add(circle1);

		Circle circle2 = new Circle(15);
		circle2.setCenterX(Math.random() * (circle1.getCenterX() * 5 + OFFSET / 2) + OFFSET / 10);
		circle2.setCenterY(Math.random() * (circle1.getCenterY() + OFFSET));
		randomCircleComponents.add(circle2);

		Line connectingTwoCircles = new Line();
		connectingTwoCircles.setStartX(circle1.getCenterX());
		connectingTwoCircles.setStartY(circle1.getCenterY());
		connectingTwoCircles.setEndX(circle2.getCenterX());
		connectingTwoCircles.setEndY(circle2.getCenterY());
		randomCircleComponents.add(connectingTwoCircles);

		double distance = Math.sqrt(
				(((circle1.getCenterX()) - (circle2.getCenterX())) * ((circle1.getCenterX()) - (circle2.getCenterX())))
						+ (((circle1.getCenterY()) - (circle2.getCenterY()))
								* ((circle1.getCenterY()) - (circle2.getCenterY()))));

		System.out.println("DISTANCE " + distance);

		Text putDistance = new Text(Double.toString(distance));
		double centerX = circle1.getCenterX() / 2 + circle2.getCenterX() / 2 + 10;
		double centerY = circle1.getCenterY() / 2 + circle2.getCenterY() / 2 + 5;

		putDistance.setX(centerX);
		putDistance.setY(centerY);

		randomCircleComponents.add(putDistance);

		randomCircleContainer.getChildren().addAll(randomCircleComponents);

		Scene randomConnectedCircles = new Scene(randomCircleContainer);
		primaryStage.setTitle("Exercise14_21");
		primaryStage.setScene(randomConnectedCircles);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
