package solutions_chapter14_exercises;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_08 extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane deckOfCards = new GridPane();

		ArrayList<ImageView> cardCollection = new ArrayList<>();

		for (int cardNum = 1; cardNum < 55; cardNum++) {
			String cardPath = "/image/card/" + cardNum + ".png";
			cardCollection.add(new ImageView(new Image(cardPath)));
		} // Store images of unique 52 cards inside unique ImageView per index
			// in ArrayList

		Collections.shuffle(cardCollection); // Randomize cards sequence

		int cardCount = 0;
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 9; column++) {
				deckOfCards.add(cardCollection.get(cardCount), column, row);
				cardCount += 1;
			}
		}

		// Insert Pane onto Scene
		Scene scene = new Scene(deckOfCards);
		primaryStage.setTitle("Exercise14_08");
		primaryStage.setScene(scene); // Insert Scene onto Stage
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
