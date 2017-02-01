package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise14_11 extends Application {

	private static int CIRCLE_CENTREX = 120;
	private static int CIRCLE_CENTREY = 120;
	private static int CIRCLE_RADIUS = 100;
	private static int TRIANGLE_OFFSET = 25;
	private static int ELLIPSE_CENTREX = 80;
	private static int ELLIPSE_CENTREY = 80;
	private static int ELLIPSE_OFFSET = 80;
	private static int RADIUSX = 30;
	private static int RADIUSY = 20;

	@Override
	public void start(Stage primaryStage) {
		Pane smileyFaceCreator = new Pane();
		smileyFaceCreator.setPadding(new Insets(20, 0, 0, 20));

		Circle smileyFace = new Circle(CIRCLE_RADIUS, Color.WHITE);
		smileyFace.setStroke(Color.BLACK);
		smileyFace.setCenterX(CIRCLE_CENTREX);
		smileyFace.setCenterY(CIRCLE_CENTREY);
		smileyFaceCreator.getChildren().add(smileyFace);

		int vertex1_xPoint = CIRCLE_CENTREX;
		int vertex1_yPoint = CIRCLE_CENTREY - TRIANGLE_OFFSET + 10;

		int vertex2_xPoint = CIRCLE_CENTREX - TRIANGLE_OFFSET;
		int vertex2_yPoint = CIRCLE_CENTREY + TRIANGLE_OFFSET + 10;

		int vertex3_xPoint = CIRCLE_CENTREX + TRIANGLE_OFFSET;
		int vertex3_yPoint = CIRCLE_CENTREY + TRIANGLE_OFFSET + 10;

		Polygon nose = new Polygon(vertex1_xPoint, vertex1_yPoint, vertex2_xPoint, vertex2_yPoint, vertex3_xPoint,
				vertex3_yPoint);
		nose.setFill(Color.WHITE);
		nose.setStroke(Color.BLACK);
		smileyFaceCreator.getChildren().add(nose);

		Ellipse leftEye = new Ellipse(ELLIPSE_CENTREX, ELLIPSE_CENTREY, RADIUSX, RADIUSY);
		leftEye.setFill(Color.WHITE);
		leftEye.setStroke(Color.BLACK);
		smileyFaceCreator.getChildren().add(leftEye);

		Ellipse rightEye = new Ellipse(ELLIPSE_CENTREX + ELLIPSE_OFFSET, ELLIPSE_CENTREY, RADIUSX, RADIUSY);
		rightEye.setFill(Color.WHITE);
		rightEye.setStroke(Color.BLACK);
		smileyFaceCreator.getChildren().add(rightEye);

		Circle leftInnerEye = new Circle(ELLIPSE_CENTREX, ELLIPSE_CENTREY, 13);
		smileyFaceCreator.getChildren().add(leftInnerEye);

		Circle rightInnerEye = new Circle(ELLIPSE_CENTREX + ELLIPSE_OFFSET, ELLIPSE_CENTREY, 13);
		smileyFaceCreator.getChildren().add(rightInnerEye);

		Arc smile = new Arc(CIRCLE_CENTREX, CIRCLE_CENTREY + 45, 46, 22, 0, -180);
		smile.setFill(Color.WHITE);
		smile.setType(ArcType.OPEN);
		smile.setStroke(Color.BLACK);
		smileyFaceCreator.getChildren().add(smile);

		Scene scene = new Scene(smileyFaceCreator);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_11");
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
