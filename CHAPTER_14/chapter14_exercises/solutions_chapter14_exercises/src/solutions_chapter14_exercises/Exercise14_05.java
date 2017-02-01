package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_05 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		pane.setPadding(new Insets(5, 5, 0, 5));

		String[] displayText = "Welcome to Java".toUpperCase().split("");
		Text[] printCanvas = new Text[displayText.length];

		final double centerX = 120;
		final double centerY = 120;
		final double radius = 90;
		double offset_angle = 0;
		double rotate_by_angle = 90;
		int counter = 0;

		// http://en.wikipedia.org/wiki/Circle#Equations
		// The equation can be written in parametric form using the
		// trigonometric functions sine and cosine as
		// x = a+r * cos t
		// y = b+r * sin t
		// where t is a parametric variable in the range 0 to 2π

		while (counter < displayText.length) {
			double x = centerX + radius * Math.cos(Math.toRadians(offset_angle));
			double y = centerY + radius * Math.sin(Math.toRadians(offset_angle));

			printCanvas[counter] = new Text(x, y, displayText[counter]);
			printCanvas[counter].setRotate(rotate_by_angle);
			printCanvas[counter].setFont(Font.font("TimesNewRoman", FontWeight.EXTRA_BOLD, 30));
			printCanvas[counter].setStroke(Color.color(Math.random(), Math.random(), Math.random()));

			pane.getChildren().add(printCanvas[counter]);

			counter++;
			rotate_by_angle += 22;
			offset_angle += 22;
		}

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_05");
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
