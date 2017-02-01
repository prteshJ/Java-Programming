package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise14_14 extends Application {

	/*
	 * private static double START_X = 40; private static double START_Y = 20;
	 * private static double WIDTH = 110; private static double HEIGHT = 90;
	 * private static double OFFSET = 28;
	 */
	@Override
	public void start(Stage primaryStage) {
		Pane rectanguloidContainer = new Pane();

		ArrayList<Shape> rectanguloidComponents = new ArrayList<>();

		// Rectangle outerRectangle = new Rectangle(START_X, START_Y, WIDTH,
		// HEIGHT);
		Rectangle outerRectangle = new Rectangle(0, 0);
		outerRectangle.setFill(Color.TRANSPARENT);
		outerRectangle.setStroke(Color.BLACK);
		outerRectangle.xProperty().bind(rectanguloidContainer.widthProperty().divide(4).subtract(25));
		outerRectangle.yProperty().bind(rectanguloidContainer.heightProperty().divide(4).add(25));
		outerRectangle.widthProperty().bind(rectanguloidContainer.widthProperty().divide(2).add(15));
		outerRectangle.heightProperty().bind(rectanguloidContainer.heightProperty().divide(2));
		rectanguloidComponents.add(outerRectangle);

		// Rectangle innerRectangle = new Rectangle(START_X - OFFSET, START_Y +
		// OFFSET, WIDTH, HEIGHT);
		Rectangle innerRectangle = new Rectangle(0, 0);
		innerRectangle.setFill(Color.TRANSPARENT);
		innerRectangle.setStroke(Color.BLACK);
		innerRectangle.xProperty().bind(rectanguloidContainer.widthProperty().divide(4).add(25));
		innerRectangle.yProperty().bind(rectanguloidContainer.heightProperty().divide(4).subtract(25));
		innerRectangle.widthProperty().bind(rectanguloidContainer.widthProperty().divide(2).add(15));
		innerRectangle.heightProperty().bind(rectanguloidContainer.heightProperty().divide(2));
		rectanguloidComponents.add(innerRectangle);

		// Line outerTopLeftEdge = new Line(START_X, START_Y, START_X - OFFSET,
		// START_Y + OFFSET);
		Line outerTopLeftEdge = new Line();
		outerTopLeftEdge.startXProperty().bind(outerRectangle.xProperty());
		outerTopLeftEdge.startYProperty().bind(outerRectangle.yProperty());
		outerTopLeftEdge.endXProperty().bind(innerRectangle.xProperty());
		outerTopLeftEdge.endYProperty().bind(innerRectangle.yProperty());
		outerTopLeftEdge.setFill(Color.TRANSPARENT);
		outerTopLeftEdge.setStroke(Color.BLACK);
		rectanguloidComponents.add(outerTopLeftEdge);

		// Line outerBottomLeftEdge = new Line(START_X, START_Y + HEIGHT,
		// START_X - OFFSET, START_Y + HEIGHT + OFFSET);
		Line outerBottomLeftEdge = new Line();
		outerBottomLeftEdge.startXProperty().bind(outerRectangle.xProperty());
		outerBottomLeftEdge.startYProperty().bind(outerRectangle.yProperty().add(outerRectangle.heightProperty()));
		outerBottomLeftEdge.endXProperty().bind(innerRectangle.xProperty());
		outerBottomLeftEdge.endYProperty().bind(innerRectangle.yProperty().add(innerRectangle.heightProperty()));
		outerBottomLeftEdge.setFill(Color.TRANSPARENT);
		outerBottomLeftEdge.setStroke(Color.BLACK);
		rectanguloidComponents.add(outerBottomLeftEdge);

		// Line outerTopRightEdge = new Line(START_X + WIDTH, START_Y, START_X +
		// WIDTH - OFFSET, START_Y + OFFSET);
		Line outerTopRightEdge = new Line();
		outerTopRightEdge.startXProperty().bind(outerRectangle.xProperty().add(outerRectangle.widthProperty()));
		outerTopRightEdge.startYProperty().bind(outerRectangle.yProperty());
		outerTopRightEdge.endXProperty().bind(innerRectangle.xProperty().add(innerRectangle.widthProperty()));
		outerTopRightEdge.endYProperty().bind(innerRectangle.yProperty());
		outerTopRightEdge.setFill(Color.TRANSPARENT);
		outerTopRightEdge.setStroke(Color.BLACK);
		rectanguloidComponents.add(outerTopRightEdge);

		// Line outerBottomRightEdge = new Line(START_X + WIDTH, START_Y +
		// HEIGHT, START_X + WIDTH - OFFSET, START_Y + HEIGHT + OFFSET);
		Line outerBottomRightEdge = new Line();
		outerBottomRightEdge.startXProperty().bind(outerRectangle.xProperty().add(outerRectangle.widthProperty()));
		outerBottomRightEdge.startYProperty().bind(outerRectangle.yProperty().add(outerRectangle.heightProperty()));
		outerBottomRightEdge.endXProperty().bind(innerRectangle.xProperty().add(innerRectangle.widthProperty()));
		outerBottomRightEdge.endYProperty().bind(innerRectangle.yProperty().add(innerRectangle.heightProperty()));
		outerBottomRightEdge.setFill(Color.TRANSPARENT);
		outerBottomRightEdge.setStroke(Color.BLACK);
		rectanguloidComponents.add(outerBottomRightEdge);

		rectanguloidContainer.getChildren().addAll(rectanguloidComponents);

		/**
		 * Setting up rectanguloid on Canvas
		 */
		Scene rectanguloid = new Scene(rectanguloidContainer, 250, 250);
		primaryStage.setTitle("Exercise14_14");
		primaryStage.setScene(rectanguloid);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
