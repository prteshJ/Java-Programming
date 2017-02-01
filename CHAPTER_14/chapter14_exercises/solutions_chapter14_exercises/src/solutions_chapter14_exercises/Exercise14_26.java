package solutions_chapter14_exercises;

import MyToolKit.ClockPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 26:
 *
 *      (Use the ClockPane class)
 *      Write a program that displays two clocks. The hour, minute, and second
 *      values are 4, 20, 45 for the first clock and 22, 46, 15 for the second
 *      clock, as shown in Figure 14.51c.
 *
 * Credited to Luiz Arantes Sa.
 */
public class Exercise14_26 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        ClockPane clock1 = new ClockPane(4, 20, 45, width / 2, height);
        ClockPane clock2 = new ClockPane(22, 46, 15, width / 2, height);
        HBox hBox = new HBox(clock1, clock2);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_26");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
