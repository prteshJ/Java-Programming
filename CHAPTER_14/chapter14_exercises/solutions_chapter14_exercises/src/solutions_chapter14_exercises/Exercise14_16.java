package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise14_16 extends Application {

	private static final double PANE_WIDTH = 300;
	private static final double PANE_HEIGHT = 300;

	@Override
	public void start(Stage primaryStage) {
		Pane gridContainer = new Pane();

		Line verticalFirstLine = new Line();
		verticalFirstLine.setFill(Color.TRANSPARENT);
		verticalFirstLine.setStroke(Color.RED);
		verticalFirstLine.startXProperty().bind(gridContainer.widthProperty().divide(3));
		verticalFirstLine.startYProperty().bind(gridContainer.heightProperty().multiply(0));
		verticalFirstLine.endXProperty().bind(gridContainer.widthProperty().divide(3));
		verticalFirstLine.endYProperty().bind(gridContainer.heightProperty());
		gridContainer.getChildren().add(verticalFirstLine);

		Line verticalSecondLine = new Line();
		verticalSecondLine.setFill(Color.TRANSPARENT);
		verticalSecondLine.setStroke(Color.RED);
		verticalSecondLine.startXProperty().bind(gridContainer.widthProperty().divide(3).multiply(2));
		verticalSecondLine.startYProperty().bind(gridContainer.heightProperty().multiply(0));
		verticalSecondLine.endXProperty().bind(gridContainer.widthProperty().divide(3).multiply(2));
		verticalSecondLine.endYProperty().bind(gridContainer.heightProperty());
		gridContainer.getChildren().add(verticalSecondLine);

		Line horizontalFirstLine = new Line();
		horizontalFirstLine.setFill(Color.TRANSPARENT);
		horizontalFirstLine.setStroke(Color.BLUE);
		horizontalFirstLine.startXProperty().bind(gridContainer.widthProperty().multiply(0));
		horizontalFirstLine.startYProperty().bind(gridContainer.heightProperty().divide(3));
		horizontalFirstLine.endXProperty().bind(gridContainer.widthProperty());
		horizontalFirstLine.endYProperty().bind(gridContainer.heightProperty().divide(3));
		gridContainer.getChildren().add(horizontalFirstLine);

		Line horizontalSecondLine = new Line();
		horizontalSecondLine.setFill(Color.TRANSPARENT);
		horizontalSecondLine.setStroke(Color.BLUE);
		horizontalSecondLine.startXProperty().bind(gridContainer.widthProperty().multiply(0));
		horizontalSecondLine.startYProperty().bind(gridContainer.heightProperty().divide(3).multiply(2));
		horizontalSecondLine.endXProperty().bind(gridContainer.widthProperty());
		horizontalSecondLine.endYProperty().bind(gridContainer.heightProperty().divide(3).multiply(2));
		gridContainer.getChildren().add(horizontalSecondLine);

		Scene grid3X3 = new Scene(gridContainer, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_16");
		primaryStage.setScene(grid3X3);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
