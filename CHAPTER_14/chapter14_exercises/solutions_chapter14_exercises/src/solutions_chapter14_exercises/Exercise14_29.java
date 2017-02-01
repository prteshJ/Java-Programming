package solutions_chapter14_exercises;

import MyToolKit.BeanMachinePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 29:
 *
 *      (Game: bean machine)
 *      Write a program that displays a bean machine introduced
 *      in Programming Exercise 7.21, as shown in Figure 14.52c.
 *
 * Credited to Luiz Arantes Sa.
 */
public class Exercise14_29 extends Application {

    @Override
    public void start(Stage primaryStage) {

        BeanMachinePane pane = new BeanMachinePane();

        Scene scene = new Scene(pane, pane.getW(), pane.getH());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_29");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}