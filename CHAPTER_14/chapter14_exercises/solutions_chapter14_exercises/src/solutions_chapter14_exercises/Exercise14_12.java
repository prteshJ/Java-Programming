package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise14_12 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane barChart = new Pane();
		barChart.setPadding(new Insets(5));
		final int WIDTH = 440;
		final int HEIGHT = 200;

		/**
		 *  Using arrays for convenience
		 */
		int[] percents = { 20, 10, 30, 40 };
		String[] exams = { "Project -- ", "Quiz -- ", "Midterm -- ", "Final -- " };
		Color[] examColors = { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE };

		int counter = 0;
		int x = 10, y = HEIGHT - 10;

		/**
		 *  Creating bar chart
		 */
		while (counter < percents.length) {
			String exam = exams[counter] + Integer.toString(percents[counter]);
			Label examInfo = new Label(exam);

			int accumulator = 0;
			while (accumulator < (percents[counter] / 5 + 1)) {
				Rectangle bar = new Rectangle(x, y, (WIDTH / 10 + 6) * 2, HEIGHT / 10);
				bar.setFill(examColors[counter]);
				bar.setStroke(examColors[counter]);
				barChart.getChildren().add(bar);

				y -= (HEIGHT / 10);
				accumulator++;
			}
			examInfo.relocate(x, y);

			barChart.getChildren().add(examInfo);

			x += (WIDTH / 10 + 6) + 55;
			y = HEIGHT - 10;
			counter++;
		}

		/**
		 * Displaying bar chart
		 */
		Scene scene = new Scene(barChart);
		primaryStage.setTitle("Exercise14_12");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
