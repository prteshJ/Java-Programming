package liangChapter31_Examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromClient;

	public StudentServer() {
		try {
			// Create a server socket
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server started ");

			// Create an object output stream
			outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));

			while(true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();

				// Create an input stream from the socket
				ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());

				// Read from input
				Object object = inputFromClient.readObject();

				// Write to the file
				outputToFile.writeObject(object);
				System.out.println("A new student object is stored");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputFromClient.close();
				outputToFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new StudentServer();
	}
}
