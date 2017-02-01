package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_15 extends Application {

	private static final double PANE_WIDTH = 200;
	private static final double PANE_HEIGHT = 200;

	@Override
	public void start(Stage primaryStage) {
		Pane stopSignContainer = new StackPane();

		double CENTERX = PANE_WIDTH / 2;
		double CENTERY = PANE_HEIGHT / 2;
		double RADIUS = Math.min(PANE_WIDTH, PANE_HEIGHT) * 0.4;

		Polygon octagon = new Polygon();
		stopSignContainer.getChildren().add(octagon);
		octagon.setFill(Color.RED);
		octagon.setStroke(Color.BLACK);
		ObservableList<Double> octagonPoints = octagon.getPoints();

		for (int point = 0; point < 8; point++) {
			octagonPoints.add(CENTERX + RADIUS * Math.cos((2 * point * Math.PI) / 8));
			octagonPoints.add(CENTERY + RADIUS * Math.sin((2 * point * Math.PI) / 8));
		}

		octagon.setRotate(67.5); // Rotate polygon to make side horizontal

		Text stopSign = new Text("STOP");
		stopSign.setFill(Color.WHITE);
		stopSign.setStroke(Color.WHITE);
		stopSign.setFont(Font.font("TimesNewRoman", FontWeight.NORMAL, FontPosture.REGULAR, RADIUS / 2));

		stopSignContainer.getChildren().add(stopSign); // Add text onto polygon

		Scene stopSignScene = new Scene(stopSignContainer, PANE_WIDTH, PANE_HEIGHT);
		primaryStage.setTitle("Exercise14_15");
		primaryStage.setScene(stopSignScene);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
