package liangChapter32_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Using Prepared Statement here we prevent SQL Injection
// 1' or true or '1 in SSN field in GUI doesn't
// retrieve first record now

public class FinalGradeUsingPreparedStatement extends Application{
	// Statement for executing queries
	private PreparedStatement preparedStatement;
	private TextField tfSSN = new TextField();
	private TextField tfCourseId = new TextField();
	private Label lblStatus = new Label();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Initialize database connection and create a Statement object
		initializeDB();

		Button btShowGrade = new Button("Show Grade"); 
		HBox hBox = new HBox(5); 
		hBox.getChildren().addAll(new Label("SSN"), tfSSN, new Label("Course ID"), tfCourseId, (btShowGrade));

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, lblStatus);

		tfSSN.setPrefColumnCount(6);
		tfCourseId.setPrefColumnCount(6);
		btShowGrade.setOnAction(e -> showGrade());

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 420, 80);
		primaryStage.setTitle("FindGrade"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	private void initializeDB() {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
			System.out.println("Driver loaded");

			// Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");

			String queryString = "select firstName, mi, " +
					"lastName, title, grade from Student, Enrollment, Course " + "where Student.ssn = ? and Enrollment.courseId = ? " +
					"and Enrollment.courseId = Course.courseId";

			// Create a statement
			preparedStatement = connection.prepareStatement(queryString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showGrade() {
		String ssn = tfSSN.getText();
		String courseId = tfCourseId.getText();				

		try {
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseId);
			ResultSet rset = preparedStatement.executeQuery();
			if(rset.next()) {
				String firstName = rset.getString(1); // I fix error here!
				String mi = rset.getString(2);
				String lastName = rset.getString(3);
				String title = rset.getString(4);
				String grade = rset.getString(5);

				// Display result in a label
				lblStatus.setText(firstName + " " + mi + 
						" " + lastName + "'s grade on course " + title + " is " + 
						grade);
			} else {
				lblStatus.setText("Not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
