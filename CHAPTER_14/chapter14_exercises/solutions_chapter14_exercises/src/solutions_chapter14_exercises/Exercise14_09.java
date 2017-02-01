package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise14_09 extends Application {

	private static final int RADIUS = 75;
	private static final int GAP = 10;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();

		int x = RADIUS + GAP;
		int y = RADIUS + GAP;

		for (int row = 0; row < 2; row++) {
			// create 2 circles in each row
			for (int col = 0; col < 2; col++) {
				Circle circle = new Circle(RADIUS);
				circle.setCenterX(x);
				circle.setCenterY(y);
				circle.setFill(Color.WHITE);
				circle.setStroke(Color.BLACK);

				pane.getChildren().add(circle);

				// create 4 fan shaped arcs in same circle
				for (int arcStartAngle = 30; arcStartAngle < 360; arcStartAngle += 90) {
					Arc arc = new Arc(x, y, RADIUS - 15, RADIUS - 15, arcStartAngle, 30);
					arc.setFill(Color.BLACK);
					arc.setType(ArcType.ROUND);
					pane.getChildren().add(arc);
				}

				// Advance x co-ordinate to next circle in same row
				x += RADIUS * 2 + GAP;
			}

			// reset x co-ordinate
			x = RADIUS + GAP;
			y += RADIUS * 2 + GAP; // set y co-ordinate below circle diameter +
									// gap
		}

		Scene scene = new Scene(pane, 325, 325);
		primaryStage.setTitle("Exercise14_09");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
