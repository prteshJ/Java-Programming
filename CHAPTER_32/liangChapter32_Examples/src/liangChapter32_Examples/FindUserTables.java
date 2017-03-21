package liangChapter32_Examples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserTables {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

			// Connect to a database
			Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");

			DatabaseMetaData dbMetaData = connection.getMetaData();

			ResultSet rsTables = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
			System.out.print("User tables: ");
			while (rsTables.next()) {
				System.out.print(rsTables.getString("TABLE_NAME") + " ");
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
