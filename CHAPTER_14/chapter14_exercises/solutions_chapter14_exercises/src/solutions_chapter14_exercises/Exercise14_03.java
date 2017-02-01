package solutions_chapter14_exercises;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise14_03 extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox deckOfCards = new HBox();
		deckOfCards.setPadding(new Insets(5, 5, 5, 5)); // Spacing between Pane
														// & Scene

		ArrayList<ImageView> cardCollection = new ArrayList<>();

		for (int cardNum = 1; cardNum < 55; cardNum++) {
			String cardPath = "/image/card/" + cardNum + ".png";
			cardCollection.add(new ImageView(new Image(cardPath)));
		} // Store images of unique 52 cards inside unique ImageView per index
			// in ArrayList

		Collections.shuffle(cardCollection); // Randomize cards sequence

		for (int numCards = 1; numCards < 4; numCards++) {
			deckOfCards.getChildren().add(cardCollection.get(numCards - 1));
		} // Display first 3 cards

		// Insert Pane onto Scene
		Scene scene = new Scene(deckOfCards);
		primaryStage.setTitle("Exercise14_03");
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
