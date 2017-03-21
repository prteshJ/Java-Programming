package liangChapter32_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultSetMetaData {
	public static void main(String[] args) {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

			// Connect to a database
			Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");

			// Create a statement
			Statement statement = connection.createStatement();

			// Execute a statement
			ResultSet resultSet = statement.executeQuery("select * from Enrollment");

			ResultSetMetaData rsMetaData = resultSet.getMetaData();
			for(int i=1; i<= rsMetaData.getColumnCount(); i++) {
				System.out.printf("%-12s\t", rsMetaData.getColumnName(i)); // Use getColumnName from ResultSetMetaData
			}
			System.out.println();

			// Iterate through the result and print the students' names
			while (resultSet.next()) {
				for(int i=1; i<= rsMetaData.getColumnCount(); i++) {
					System.out.printf("%-12s\t", resultSet.getObject(i)); // Use getObject from ResultSet
				}
				System.out.println();
			}

			// Close the connection
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}
}
