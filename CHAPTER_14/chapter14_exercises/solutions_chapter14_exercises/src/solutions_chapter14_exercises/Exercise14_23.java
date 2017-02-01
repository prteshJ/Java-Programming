package solutions_chapter14_exercises;

import java.util.ArrayList;
import java.util.Scanner;

import MyToolKit.MyRectangle2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_23 extends Application {

	private static final double PANE_WIDTH = 400;
	private static final double PANE_HEIGHT = 400;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();

		ArrayList<Rectangle> rectangles = new ArrayList<>();

		Scanner rectangleCoordinates = new Scanner(System.in);

		for (int rec = 1; rec <= 2; rec++) {
			System.out.println("Enter x, y, width & height of rectangle: ");
			Rectangle rectangle = new Rectangle(rectangleCoordinates.nextDouble(), rectangleCoordinates.nextDouble(),
					rectangleCoordinates.nextDouble(), rectangleCoordinates.nextDouble());

			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setStroke(Color.BLACK);

			rectangles.add(rectangle);
		}

		MyRectangle2D rectangle1 = new MyRectangle2D(rectangles.get(0));
		MyRectangle2D rectangle2 = new MyRectangle2D(rectangles.get(1));
		String rectangleResult = "";

		if (rectangle1.contains(rectangle2) || rectangle2.contains(rectangle1)) {
			rectangleResult = "One rectangle is contained in another";
		} else if (rectangle1.overlaps(rectangle2) || rectangle2.overlaps(rectangle1)) {
			rectangleResult = "The rectangles overlap";
		} else {
			rectangleResult = "The rectangles do not overlap";
		}

		Text resultText = new Text(PANE_WIDTH * 0.1, PANE_HEIGHT * 0.9, rectangleResult);
		pane.getChildren().add(resultText);

		pane.getChildren().addAll(rectangles);

		Scene rectangleScene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_23");
		primaryStage.setScene(rectangleScene);
		primaryStage.show();
		rectangleCoordinates.close();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}