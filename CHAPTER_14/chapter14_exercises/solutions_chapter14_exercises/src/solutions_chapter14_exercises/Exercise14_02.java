package solutions_chapter14_exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_02 extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(0, 40, 0, 30));
		pane.setHgap(10);
		pane.setVgap(5);

		Image cross = new Image("/image/x.gif");
		Image nought = new Image("/image/o.gif");

		ArrayList<ImageView> decidor = new ArrayList<>();
		int[] emptyDetector = new int[9]; // fill up nothing if not 'X' or 'O'

		int decision = -1; // if this is 2 , fill up nothing
		int counter = 0; // Since it is a 3X3 GRID

		int emptyCntr = 0; // Stores information when decision became 2

		while (counter < 9) { // Populate ArrayList randomly
			decision = (int) (Math.random() * (2 - 0));
			if (decision == 0) {
				decidor.add(new ImageView(nought));
			} else if (decision == 1) {
				decidor.add(new ImageView(cross));
			} else {
				decidor.add(new ImageView(nought));
				emptyDetector[emptyCntr++] = decidor.size();
			}
			counter += 1;
			decision = -1;
		}

		int emptyTrack = emptyDetector.length; // Get number of times decision
												// was 2

		for (counter = 0; counter < 9; counter++) { // Main logic for Grid Pane
			switch (counter) {
			case 0:
				if (counter <= emptyTrack) {
					if (emptyDetector[counter] == counter) {

					} else {
						pane.add(decidor.get(0), 1, 1);
						pane.setAlignment(Pos.CENTER);
					}
				}
				break;

			case 1:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(1), 1, 2);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 2:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(2), 1, 3);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 3:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(3), 2, 1);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 4:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(4), 2, 2);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 5:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(5), 2, 3);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 6:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(6), 3, 1);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 7:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(7), 3, 2);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			case 8:
				if ((counter <= emptyTrack) && (emptyDetector[counter] == counter)) {

				} else {
					pane.add(decidor.get(8), 3, 3);
					pane.setAlignment(Pos.CENTER);
				}
				break;

			default:
				System.out.println("Error occured !!!");
				break;
			}
		}

		// Fit pane in Scene
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_02");
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
