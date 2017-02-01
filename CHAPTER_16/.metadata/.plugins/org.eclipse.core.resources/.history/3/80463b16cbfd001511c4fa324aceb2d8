package chapter16eclipseliang;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckBoxDemo_Version1 extends  Application{
	
	protected Text text = new Text(50, 50, "JavaFX Programming");

	protected BorderPane getPane() {
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("Left", new ImageView("image/left.gif"));
		Button btRight = new Button("Right", new ImageView("image/right.gif"));
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: green");

		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);

		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);

		btLeft.setOnAction(e -> text.setX(text.getX() - 10));
		btRight.setOnAction(e -> text.setX(text.getX() + 10));
		
		/*************** CheckBox logic *********************/
		
		Font fontBoldItalic = Font.font("TimesNewRoman", FontWeight.BOLD, FontPosture.ITALIC, 20);
		Font fontBold       = Font.font("TimesNewRoman", FontWeight.BOLD, FontPosture.REGULAR, 20);
		Font fontItalic     = Font.font("TimesNewRoman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
		Font fontNormal     = Font.font("TimesNewRoman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
		
		text.setFont(fontNormal);
		
		VBox paneForCheckBoxes = new VBox(20);
		paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
		paneForCheckBoxes.setStyle("-fx-border-color: green");
		CheckBox chkBold   = new CheckBox("Bold");
		CheckBox chkItalic = new CheckBox("Italic");
		paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
		pane.setRight(paneForCheckBoxes);
		
		EventHandler<ActionEvent> handler = e -> {
			if(chkBold.isSelected() && chkItalic.isSelected()) {
				text.setFont(fontBoldItalic);
			}
			else if(chkBold.isSelected()) {
				text.setFont(fontBold); // The Bold check box checked
			}
			else if(chkItalic.isSelected()) {
				text.setFont(fontItalic); // The Italic check box checked
			}
			else {
				text.setFont(fontNormal); // Both check boxes unchecked
			}
		};
		
		chkBold.setOnAction(handler);
		chkItalic.setOnAction(handler);
		
		/***************************************************/

		return pane; // Return a new pane
	}
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setTitle("CheckBox Demo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * Main method
	 * Only needed if IDE has poor JavaFX support
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
