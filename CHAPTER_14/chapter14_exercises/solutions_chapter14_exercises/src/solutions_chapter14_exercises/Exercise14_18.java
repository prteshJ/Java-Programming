package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_18 extends Application {

	private static double PANE_WIDTH = 320;
	private static double PANE_HEIGHT = 320;
	private static double OFFSET = 10;

	@Override
	public void start(Stage primaryStage) {
		Pane sineCurveGraph = new Pane();

		ArrayList<Shape> sineCurveComponents = new ArrayList<>();

		Polyline curvePoints = new Polyline();
		curvePoints.setFill(Color.TRANSPARENT);
		curvePoints.setStroke(Color.BLACK);
		ObservableList<Double> pointsList = curvePoints.getPoints();
		double scaleFactor = 0.0125;
		for (int point = -100; point <= 100; point++) {
			pointsList.add(point + PANE_WIDTH / 2);
			pointsList.add(scaleFactor * point * point + PANE_HEIGHT / 2);
		}
		curvePoints.setRotate(-180);
		sineCurveComponents.add(curvePoints);

		// Get center of curve
		int mid = pointsList.size() / 2;
		double centerX = pointsList.get(mid).doubleValue();
		double centerY = pointsList.get(mid + 1).doubleValue();

		Text axisX = new Text("X");
		axisX.setX(PANE_WIDTH - OFFSET * 1.75);
		axisX.setY(centerY + 124 - OFFSET * 2);
		sineCurveComponents.add(axisX);

		Line horizontalLine = new Line();
		horizontalLine.setStartX(OFFSET);
		horizontalLine.setStartY(centerY + 124);
		horizontalLine.setEndX(PANE_WIDTH - OFFSET);
		horizontalLine.setEndY(horizontalLine.getStartY());
		sineCurveComponents.add(horizontalLine);

		Line horizontalArrowLeftPart = new Line();
		horizontalArrowLeftPart.setStartX(horizontalLine.getEndX());
		horizontalArrowLeftPart.setStartY(horizontalLine.getEndY());
		horizontalArrowLeftPart.setEndX(horizontalArrowLeftPart.getStartX() - OFFSET);
		horizontalArrowLeftPart.setEndY(horizontalLine.getEndY() - OFFSET);
		sineCurveComponents.add(horizontalArrowLeftPart);

		Line horizontalArrowRightPart = new Line();
		horizontalArrowRightPart.setStartX(horizontalLine.getEndX());
		horizontalArrowRightPart.setStartY(horizontalLine.getEndY());
		horizontalArrowRightPart.setEndX(horizontalArrowLeftPart.getStartX() - OFFSET);
		horizontalArrowRightPart.setEndY(horizontalLine.getEndY() + OFFSET);
		sineCurveComponents.add(horizontalArrowRightPart);

		Text axisY = new Text("Y");
		axisY.setX(centerX + OFFSET * 1.75);
		axisY.setY(OFFSET * 1.85 * 5.85);
		sineCurveComponents.add(axisY);

		Line verticalLine = new Line();
		verticalLine.setStartX(centerX);
		verticalLine.setStartY(OFFSET * 10);
		verticalLine.setEndX(centerX);
		verticalLine.setEndY(PANE_HEIGHT);
		sineCurveComponents.add(verticalLine);

		Line verticalArrowLeftPart = new Line();
		verticalArrowLeftPart.setStartX(verticalLine.getStartX());
		verticalArrowLeftPart.setStartY(verticalLine.getStartY());
		verticalArrowLeftPart.setEndX(verticalArrowLeftPart.getStartX() - OFFSET);
		verticalArrowLeftPart.setEndY(verticalArrowLeftPart.getStartY() + OFFSET);
		sineCurveComponents.add(verticalArrowLeftPart);

		Line verticalArrowRightPart = new Line();
		verticalArrowRightPart.setStartX(verticalLine.getStartX());
		verticalArrowRightPart.setStartY(verticalLine.getStartY());
		verticalArrowRightPart.setEndX(verticalArrowRightPart.getStartX() + OFFSET);
		verticalArrowRightPart.setEndY(verticalArrowRightPart.getStartY() + OFFSET);
		sineCurveComponents.add(verticalArrowRightPart);

		sineCurveGraph.getChildren().addAll(sineCurveComponents);

		Scene sineCurve = new Scene(sineCurveGraph, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_18");
		primaryStage.setScene(sineCurve);
		primaryStage.show();

	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}