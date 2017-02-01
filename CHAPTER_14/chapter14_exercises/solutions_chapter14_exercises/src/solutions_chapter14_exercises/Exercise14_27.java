package solutions_chapter14_exercises;

import MyToolKit.ClockPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 27:
 *
 *      (Draw a detailed clock)
 *      Modify the ClockPane class in Section 14.12 to draw the
 *      clock with more details on the hours and minutes,
 *      as shown in Figure 14.52a.
 *
 * Credited by Luiz Arantes Sa.
 */
public class Exercise14_27 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        ClockPane clock1 = new ClockPane(4, 20, 45, width, height);
        HBox hBox = new HBox(clock1);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_27");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
