package liangChapter32_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Author has made an error 
// I fixed it!
public class FinalGrade extends Application{
	// Statement for executing queries
	private Statement stmt;
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

			// Create a statement
			stmt = connection.createStatement();
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

		String queryString = "select firstName, mi, " +
				"lastName, title, grade from Student, Enrollment, Course " +				  
				"where Student.ssn = '" + ssn + "' and Enrollment.courseId "
				+ "= '" + courseId +
				"' and Enrollment.courseId = Course.courseId " +
				" and Enrollment.ssn = Student.ssn";

		try {
			ResultSet rset = stmt.executeQuery(queryString);
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
