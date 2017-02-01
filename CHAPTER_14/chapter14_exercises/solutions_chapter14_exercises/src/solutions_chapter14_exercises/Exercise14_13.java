package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_13 extends Application {

	private static double CENTERX = 200;
	private static double CENTERY = 200;
	private static double RADIUS = 150;

	@Override
	public void start(Stage primaryStage) {
		ArrayList<Shape> shapes = new ArrayList<>();

		Pane pieChart = new Pane();

		/**
		 * Creates a circle which is a complete pie within which various
		 * sections are created to depict a pie chart
		 */
		Circle pie = new Circle(RADIUS, Color.TRANSPARENT);
		pie.setCenterX(CENTERX);
		pie.setCenterY(CENTERY);
		pie.setStroke(Color.BLACK);
		shapes.add(pie);

		Color[] pieColors = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE };
		double[] percentsPie = new double[] { 0.20, 0.10, 0.30, 0.40 };
		String[] pieTexts = new String[] { "Project -- " + String.format("%d%s", (int) (100 * percentsPie[0]), "%"),
				"Quiz -- " + String.format("%d%s", (int) (100 * percentsPie[1]), "%"),
				"Midterm -- " + String.format("%d%s", (int) (100 * percentsPie[2]), "%"),
				"Final -- " + String.format("%d%s", (int) (100 * percentsPie[3]), "%") };

		int counter = 0;
		double startAngle = 0;

		/**
		 * Creates a pie chart based on percentage information
		 */
		while (counter < pieTexts.length) {
			double length = percentsPie[counter] * 100 * 3.6;
			Arc pieSlice = new Arc(CENTERX, CENTERY, RADIUS, RADIUS, startAngle, length);
			pieSlice.setFill(pieColors[counter]);
			pieSlice.setType(ArcType.ROUND);

			shapes.add(pieSlice);

			counter++;
			startAngle += length;
		}

		/**
		 * Creating all text objects to denote labels on various pies on pie
		 * chart
		 */
		Text textTwentyPercent = new Text(CENTERX + 20, CENTERY - 40, pieTexts[0]);
		textTwentyPercent.setFont(Font.font("Courier", FontPosture.REGULAR, 18));
		shapes.add(textTwentyPercent);
		Text textTenPercent = new Text(CENTERX - 40, CENTERY - RADIUS - 5, pieTexts[1]);
		textTenPercent.setFont(Font.font("Courier", FontPosture.REGULAR, 18));
		shapes.add(textTenPercent);
		Text textThirtyPercent = new Text(50, CENTERY, pieTexts[2]);
		textThirtyPercent.setFont(Font.font("Courier", FontPosture.REGULAR, 18));
		shapes.add(textThirtyPercent);
		Text textFortyPercent = new Text(CENTERX, CENTERY + RADIUS, pieTexts[3]);
		textFortyPercent.setFont(Font.font("Courier", FontPosture.REGULAR, 18));
		shapes.add(textFortyPercent);

		/**
		 * Add up all shapes to ArrayList
		 */
		pieChart.getChildren().addAll(shapes);

		// Enclose pie chart within pie container
		Scene pieContainer = new Scene(pieChart, 400, 400);
		primaryStage.setTitle("Exercise14_13");
		primaryStage.setScene(pieContainer); // Set pie container on Stage
		primaryStage.show(); // Show Stage
	}

	/**
	 * Main method needed only if poor IDE support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
