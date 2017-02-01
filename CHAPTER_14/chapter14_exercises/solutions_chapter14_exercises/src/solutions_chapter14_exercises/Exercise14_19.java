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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_19 extends Application {

	private static final double PANE_WIDTH = 400;
	private static final double PANE_HEIGHT = 200;
	private static final double OFFSET = 25;

	@Override
	public void start(Stage primaryStage) {
		Pane sinCosCurves = new Pane();

		ArrayList<Shape> sinCosContainer = new ArrayList<>();

		/************************
		 * VERTICAL LINE
		 ***************************************************************/

		Line verticalLine = new Line();
		verticalLine.setStartX(PANE_WIDTH / 2 + OFFSET / 6 - 5);
		verticalLine.setStartY(OFFSET / 2);
		verticalLine.setEndX(PANE_WIDTH / 2 + OFFSET / 6 - 5);
		verticalLine.setEndY(PANE_HEIGHT);
		sinCosContainer.add(verticalLine);

		Line verticalArrowLeftPart = new Line();
		verticalArrowLeftPart.setStartX(verticalLine.getStartX());
		verticalArrowLeftPart.setStartY(verticalLine.getStartY());
		verticalArrowLeftPart.setEndX(verticalArrowLeftPart.getStartX() - OFFSET / 2);
		verticalArrowLeftPart.setEndY(verticalArrowLeftPart.getStartY() + OFFSET / 2);
		sinCosContainer.add(verticalArrowLeftPart);

		Line verticalArrowRightPart = new Line();
		verticalArrowRightPart.setStartX(verticalLine.getStartX());
		verticalArrowRightPart.setStartY(verticalLine.getStartY());
		verticalArrowRightPart.setEndX(verticalArrowRightPart.getStartX() + OFFSET / 2);
		verticalArrowRightPart.setEndY(verticalArrowRightPart.getStartY() + OFFSET / 2);
		sinCosContainer.add(verticalArrowRightPart);

		Text axisY = new Text("Y");
		double axisY_xLoc = verticalArrowRightPart.getStartX() + OFFSET * 0.65;
		double axisY_yLoc = verticalArrowRightPart.getStartY() + OFFSET / 3;
		axisY.setX(axisY_xLoc);
		axisY.setY(axisY_yLoc);
		sinCosContainer.add(axisY);

		/************************
		 * HORIZONTAL LINE
		 ***************************************************************/

		Line horizontalLine = new Line();
		horizontalLine.setStartX(OFFSET / 2);
		horizontalLine.setStartY(PANE_HEIGHT / 2);
		horizontalLine.setEndX(PANE_WIDTH - OFFSET / 2);
		horizontalLine.setEndY(PANE_HEIGHT / 2);
		sinCosContainer.add(horizontalLine);

		Line horizontalArrowLeftPart = new Line();
		horizontalArrowLeftPart.setStartX(horizontalLine.getEndX());
		horizontalArrowLeftPart.setStartY(horizontalLine.getEndY());
		horizontalArrowLeftPart.setEndX(horizontalArrowLeftPart.getStartX() - OFFSET / 2);
		horizontalArrowLeftPart.setEndY(horizontalArrowLeftPart.getStartY() - OFFSET / 2);
		sinCosContainer.add(horizontalArrowLeftPart);

		Line horizontalArrowRightPart = new Line();
		horizontalArrowRightPart.setStartX(horizontalLine.getEndX());
		horizontalArrowRightPart.setStartY(horizontalLine.getEndY());
		horizontalArrowRightPart.setEndX(horizontalArrowLeftPart.getStartX() - OFFSET / 2);
		horizontalArrowRightPart.setEndY(horizontalArrowLeftPart.getStartY() + OFFSET / 2);
		sinCosContainer.add(horizontalArrowRightPart);

		Text axisX = new Text("X");
		double axisX_xLoc = horizontalArrowLeftPart.getStartX() - OFFSET * 0.35;
		double axisX_yLoc = horizontalArrowLeftPart.getStartY() - OFFSET * 0.85;
		axisX.setX(axisX_xLoc);
		axisX.setY(axisX_yLoc);
		sinCosContainer.add(axisX);

		/************************
		 * SINE WAVE
		 ***************************************************************/
		Polyline sinPlotter = new Polyline();
		sinPlotter.setStroke(Color.RED);
		ObservableList<Double> sinCurvePoints = sinPlotter.getPoints();
		double scaleFactor = 50;
		for (int x = -170; x <= 170; x++) {
			sinCurvePoints.add(x + 200.0);
			sinCurvePoints.add(100 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
		}

		sinCosContainer.add(sinPlotter);

		/************************
		 * COSINE WAVE
		 ***************************************************************/

		Polyline cosPlotter = new Polyline();
		cosPlotter.setStroke(Color.BLUE);
		ObservableList<Double> cosCurvePoints = cosPlotter.getPoints();
		double scaleCosFactor = 50;
		for (int x = -170; x <= 170; x++) {
			cosCurvePoints.add(x + 200.0);
			cosCurvePoints.add(100 - scaleCosFactor * Math.cos((x / 100.0) * 2 * Math.PI));
		}

		sinCosContainer.add(cosPlotter);

		/************************
		 * PI PLOTTER
		 ***************************************************************/

		Text minus_2_PI = new Text("-2\u03c0");
		minus_2_PI.setFont(Font.font("Courier", 15));
		minus_2_PI.setStroke(Color.BLACK);
		minus_2_PI.setX(86); // 25+25+25+25-15+1
		minus_2_PI.setY(112);
		sinCosContainer.add(minus_2_PI);

		Text minus_PI = new Text("-\u03c0");
		minus_PI.setFont(Font.font("Courier", 15));
		minus_PI.setStroke(Color.BLACK);
		minus_PI.setX(135.25); // 25+25+25+25+25+25-15+5/2-5/4-1
		minus_PI.setY(112);
		sinCosContainer.add(minus_PI);

		Text zero = new Text("0");
		zero.setFont(Font.font("Courier", 15));
		zero.setStroke(Color.BLACK);
		zero.setX(202.5); // 25+25+25+25+25+25-15+25+25+15+5/2
		zero.setY(112);
		sinCosContainer.add(zero);

		Text positive_PI = new Text("\u03c0");
		positive_PI.setFont(Font.font("Courier", 15));
		positive_PI.setStroke(Color.BLACK);
		positive_PI.setX(247.5); // 25+25+25+25+25+25-15+25+25+25+25+10+5/2
		positive_PI.setY(112);
		sinCosContainer.add(positive_PI);

		Text positive_two_PI = new Text("2\u03c0");
		positive_two_PI.setFont(Font.font("Courier", 15));
		positive_two_PI.setStroke(Color.BLACK);
		positive_two_PI.setX(347.5); // 25+25+25+25+25+25+25+25+25+25-15+25+25+25+25+10+5/2
		positive_two_PI.setY(112);
		sinCosContainer.add(positive_two_PI);

		/***************************************************************************************/
		sinCosCurves.getChildren().addAll(sinCosContainer);
		/***************************************************************************************/

		Scene sinCosCurvesScene = new Scene(sinCosCurves, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_19");
		primaryStage.setScene(sinCosCurvesScene);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
