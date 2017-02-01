/*******************************************************************
	Programmers often forget to close the file.
	JDK 7 provides the followings new try-with- resources syntax
	that automatically closes the files.
	try (
			declare and create resources
		) {
			Use the resource to process the file;
	}
*******************************************************************/

public class WriteDataWithAutoClose {
	public static void main(String[] args) throws Exception {
		java.io.File file = new java.io.File("scores_revised.txt");

		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}

		try (
			// Create a file
			java.io.PrintWriter output = new java.io.PrintWriter(file);
		) {
			 // Write formatted output to the file
				output.print("John T Smith ");
				output.println(90);
				output.print("Eric K Jones ");
				output.println(85);
		}

	}
}
