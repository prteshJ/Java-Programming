package solutions_chapter14_exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise14_06 extends Application {

	// My Brute Force solution
	//********************************************************************************************/
//	@Override
/*	public void start(Stage primaryStage) {
		GridPane outputPane = new GridPane();
		Rectangle[][] ref = new Rectangle[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				ref[row][col] = new Rectangle(row, col, 25, 25);
				if (((row + col) % 2) == 0)
					ref[row][col].setFill(Color.WHITE);
				else
					ref[row][col].setFill(Color.BLACK);
			}
		}

		outputPane.addRow(0, ref[0][0], ref[0][1], ref[0][2], ref[0][3], ref[0][4], ref[0][5], ref[0][6], ref[0][7]);
		outputPane.addRow(1, ref[1][0], ref[1][1], ref[1][2], ref[1][3], ref[1][4], ref[1][5], ref[1][6], ref[1][7]);
		outputPane.addRow(2, ref[2][0], ref[2][1], ref[2][2], ref[2][3], ref[2][4], ref[2][5], ref[2][6], ref[2][7]);
		outputPane.addRow(3, ref[3][0], ref[3][1], ref[3][2], ref[3][3], ref[3][4], ref[3][5], ref[3][6], ref[3][7]);
		outputPane.addRow(4, ref[4][0], ref[4][1], ref[4][2], ref[4][3], ref[4][4], ref[4][5], ref[4][6], ref[4][7]);
		outputPane.addRow(5, ref[5][0], ref[5][1], ref[5][2], ref[5][3], ref[5][4], ref[5][5], ref[5][6], ref[5][7]);
		outputPane.addRow(6, ref[6][0], ref[6][1], ref[6][2], ref[6][3], ref[6][4], ref[6][5], ref[6][6], ref[6][7]);
		outputPane.addRow(7, ref[7][0], ref[7][1], ref[7][2], ref[7][3], ref[7][4], ref[7][5], ref[7][6], ref[7][7]);

		Scene scene = new Scene(outputPane);
		primaryStage.setTitle("Exercise_14_06");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
/*	public static void main(String[] args) {
		Application.launch(args);
	}
}*/
	
//*************************** A SMART SOLUTION ******************************************************************/
//*************************** CREDIT TO GITHUB *****************************************************************/	
	public void start(Stage primaryStage) {

		GridPane pane = new GridPane();
		boolean isItBlack = false;
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				Rectangle rectangleRef = new Rectangle(25, 25, (isItBlack) ? Color.BLACK : Color.WHITE);
				pane.add(rectangleRef, column, row);
				isItBlack = !isItBlack;
			}
			isItBlack = !isItBlack;
		}

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_06");
		primaryStage.show();
	}

	/**
	 * Main method Only required if IDE has little JavaFX support
	 */
	public static void main(String[] args) {

		Application.launch(args);
	}
}
