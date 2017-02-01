package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise14_17 extends Application {

	private static final double PANE_WIDTH = 400;
	private static final double PANE_HEIGHT = 400;
	private static final double OFFSET = 10;

	@Override
	public void start(Stage primaryStage) {
		Pane hangmanContainer = new Pane();
		hangmanContainer.setPadding(new Insets(10));

		ArrayList<Shape> hangmanArtifacts = new ArrayList<>();

		Arc hangmanStand = new Arc(OFFSET * 10, PANE_HEIGHT - PANE_HEIGHT / 4 - 9, PANE_WIDTH / 6, PANE_HEIGHT / 12, 0,
				180);
		hangmanStand.setFill(Color.WHITE);
		hangmanStand.setStroke(Color.BLACK);
		hangmanArtifacts.add(hangmanStand);

		Line standingLongRod = new Line(PANE_WIDTH / 4, PANE_HEIGHT - OFFSET - PANE_HEIGHT / 3, PANE_WIDTH / 4,
				OFFSET * 2);
		standingLongRod.setFill(Color.TRANSPARENT);
		standingLongRod.setStroke(Color.BLACK);
		hangmanArtifacts.add(standingLongRod);

		Line shortHorizontalRod = new Line(PANE_WIDTH / 4, OFFSET * 2, PANE_WIDTH / 2, OFFSET * 2);
		shortHorizontalRod.setFill(Color.TRANSPARENT);
		shortHorizontalRod.setStroke(Color.BLACK);
		hangmanArtifacts.add(shortHorizontalRod);

		Line shortHangingSupportRod = new Line(PANE_WIDTH / 2, OFFSET * 2, PANE_WIDTH / 2, OFFSET * 4);
		shortHangingSupportRod.setFill(Color.TRANSPARENT);
		shortHangingSupportRod.setStroke(Color.BLACK);
		hangmanArtifacts.add(shortHangingSupportRod);

		Circle hangmanFace = new Circle(PANE_WIDTH / 2, OFFSET * 4 + OFFSET * 2, OFFSET * 2);
		hangmanFace.setFill(Color.TRANSPARENT);
		hangmanFace.setStroke(Color.BLACK);
		hangmanArtifacts.add(hangmanFace);

		Line hangmanBody = new Line(hangmanFace.getCenterX(), hangmanFace.getCenterY() + OFFSET * 2,
				hangmanFace.getCenterX(), hangmanFace.getCenterY() + OFFSET * 10);
		hangmanBody.setFill(Color.TRANSPARENT);
		hangmanBody.setStroke(Color.BLACK);
		hangmanArtifacts.add(hangmanBody);

		Line hangmanLeftLeg = new Line(hangmanBody.getEndX(), hangmanBody.getEndY(),
				hangmanBody.getEndX() - OFFSET * 4.5, hangmanBody.getEndY() + OFFSET * 3.5);
		hangmanLeftLeg.setFill(Color.TRANSPARENT);
		hangmanLeftLeg.setStroke(Color.BLACK);
		hangmanArtifacts.add(hangmanLeftLeg);

		Line hangmanRightLeg = new Line(hangmanBody.getEndX(), hangmanBody.getEndY(),
				hangmanBody.getEndX() + OFFSET * 4.5, hangmanBody.getEndY() + OFFSET * 3.5);
		hangmanRightLeg.setFill(Color.TRANSPARENT);
		hangmanRightLeg.setStroke(Color.BLACK);
		hangmanArtifacts.add(hangmanRightLeg);

		Line hangmanLeftHand = new Line();
		hangmanLeftHand.setFill(Color.TRANSPARENT);
		hangmanLeftHand.setStroke(Color.BLACK);
		hangmanLeftHand.setStartX(hangmanFace.getCenterX() - hangmanFace.getRadius() / 2 - 9);
		hangmanLeftHand.setStartY(hangmanFace.getCenterY() + hangmanFace.getRadius() - OFFSET / 5.5);
		hangmanLeftHand.setEndX(hangmanLeftHand.getStartX() - OFFSET * 4.75);
		hangmanLeftHand.setEndY(hangmanLeftHand.getStartY() + OFFSET * 3.5);
		hangmanLeftHand.setScaleX(1.15);
		hangmanLeftHand.setScaleY(1.25);
		hangmanArtifacts.add(hangmanLeftHand);

		Line hangmanRightHand = new Line();
		hangmanRightHand.setFill(Color.TRANSPARENT);
		hangmanRightHand.setStroke(Color.BLACK);
		hangmanRightHand.setStartX(hangmanLeftHand.getStartX() + hangmanFace.getRadius() * 2 - 1.5);
		hangmanRightHand.setStartY(hangmanLeftHand.getStartY());
		hangmanRightHand.setEndX(hangmanRightHand.getStartX() + OFFSET * 4.5);
		hangmanRightHand.setEndY(hangmanRightHand.getStartY() + OFFSET * 3.5);
		hangmanRightHand.setScaleX(1.15);
		hangmanRightHand.setScaleY(1.25);
		hangmanArtifacts.add(hangmanRightHand);

		hangmanContainer.getChildren().addAll(hangmanArtifacts);

		Scene hangman = new Scene(hangmanContainer);
		primaryStage.setTitle("Exercise14_17");
		primaryStage.setScene(hangman);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
