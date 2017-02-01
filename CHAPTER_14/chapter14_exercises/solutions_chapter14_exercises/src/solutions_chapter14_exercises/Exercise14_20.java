package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise14_20 extends Application {

	private static final double PANE_WIDTH = 200;
	private static final double PANE_HEIGHT = 200;
	private static final double OFFSET = 10;

	@Override
	public void start(Stage primaryStage) {
		Pane arrowContainer = new Pane();

		Exercise14_20.drawArrowLine(Math.random() * ((PANE_WIDTH - OFFSET * 2) - (OFFSET * 4)),
				Math.random() * ((PANE_HEIGHT - OFFSET * 2) - (OFFSET * 4)),
				Math.random() * ((PANE_WIDTH - OFFSET * 2) - (OFFSET * 12)),
				Math.random() * ((PANE_HEIGHT - OFFSET * 2) - (OFFSET * 12)), arrowContainer);

		Scene arrowScene = new Scene(arrowContainer, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_20");
		primaryStage.setScene(arrowScene);
		primaryStage.show();
	}

	public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {

		Line arrow = new Line();
		ArrayList<Shape> arrowComponents = new ArrayList<>();
		double smallerX = startX < endX ? startX + 4 : endX + 4;
		double largerX = startX < endX ? endX + 5 : startX + 5;
		double smallerY = startY > endY ? endY + 4 : startY + 4;
		double largerY = startY > endY ? startY + 5 : endY + 5;

		arrow.setStartX(smallerX);
		arrow.setStartY(largerY);
		arrow.setEndX(largerX);
		arrow.setEndY(smallerY < 50 ? smallerY + 20 : smallerY);
		arrowComponents.add(arrow);

		if ((largerX - smallerX) < (largerY - smallerY)) {

			Line arrowLeftPart = new Line();
			arrowLeftPart.setStartX(arrow.getEndX());
			arrowLeftPart.setStartY(arrow.getEndY());
			arrowLeftPart.setEndX(arrowLeftPart.getStartX() - 5);
			arrowLeftPart.setEndY(arrowLeftPart.getStartY() + 5);
			arrowComponents.add(arrowLeftPart);

			Line arrowRightPart = new Line();
			arrowRightPart.setStartX(arrowLeftPart.getStartX());
			arrowRightPart.setStartY(arrowLeftPart.getStartY());
			arrowRightPart.setEndX(arrowRightPart.getStartX() + 5);
			arrowRightPart.setEndY(arrowRightPart.getStartY() + 5);
			arrowComponents.add(arrowRightPart);

		} else {
			Line arrowLeftPart = new Line();
			arrowLeftPart.setStartX(arrow.getEndX());
			arrowLeftPart.setStartY(arrow.getEndY());
			arrowLeftPart.setEndX(arrowLeftPart.getStartX() - 5);
			arrowLeftPart.setEndY(arrowLeftPart.getStartY() + 5);
			arrowComponents.add(arrowLeftPart);

			Line arrowRightPart = new Line();
			arrowRightPart.setStartX(arrowLeftPart.getStartX());
			arrowRightPart.setStartY(arrowLeftPart.getStartY());
			arrowRightPart.setEndX(arrowRightPart.getStartX() - 5);
			arrowRightPart.setEndY(arrowLeftPart.getEndY() - 10);
			arrowComponents.add(arrowRightPart);
		}

		pane.getChildren().addAll(arrowComponents);
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}