package liangChapter32_Examples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author PriteshJ
 * 
 * Would like to mention that when you run 'script.sql' which
 * is downloadable from author's website, it creates all necessary
 * stored procedures, functions, tables, etc. needed for Chapter 32 
 * examples.
 *
 * So from my experience, it is wiser to not try to recreate studentFound
 * function in database or try to think where to insert it in Java code.
 * 
 * Just believe it exists provided you ran " source script.sql" command
 * when you were logged in MySQL database.
 * 
 * Hope this helps readers of the book! :)
 */
public class TestCallableStatement {
	/** Creates new form TestTableEditor */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * You might get SQL Exceptions, in that case:
			 * 
			 * 1) Add ?noAccessToProcedureBodies=true" to your database connection string in Java code.			 			 			 
			 * 2) Run below command on MySQL prompt:
			 *  	GRANT SELECT ON mysql.proc TO 'scott'@'localhost'; 			 
			 * 3) Now you can remove 1) and it should still work!
			 *  
			 *  It varies based on different ecosystems, so better to do both!
			 *  In case 3) isn't true for you!
			 *  
			 *  I assume your user is 'scott' inline with author examples.
			 * 			 
			 */
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","scott", "tiger");

			// Create a callable statement
			CallableStatement callableStatement = connection.prepareCall( "{? = call studentFound(?, ?)}");

			// This already exists ! No need to recreate!

			@SuppressWarnings("resource")
			java.util.Scanner input = new java.util.Scanner(System.in);
			System.out.print("Enter student's first name: ");
			String firstName = input.nextLine();
			System.out.print("Enter student's last name: ");
			String lastName = input.nextLine();

			callableStatement.setString(2, firstName); // set IN parameter
			callableStatement.setString(3, lastName); // set IN parameter
			callableStatement.registerOutParameter(1, Types.INTEGER); // register OUT parameter
			callableStatement.execute(); // execute statement

			if(callableStatement.getInt(1) >= 1) {
				System.out.println(firstName + " " + lastName + " is in the database");			
			} else {
				System.out.println(firstName + " " + lastName + " is not in the database");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
