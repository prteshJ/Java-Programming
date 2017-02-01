import java.io.*;

public class TestObjectInputStream_pg694 {
  public static void main(String[] args)
    throws ClassNotFoundException, IOException {
    // Create an input stream for file object.dat
    ObjectInputStream input =
      new ObjectInputStream(new BufferedInputStream(new FileInputStream("object_buffered.dat")));

    // Read a string, double value, and object from the file
    String name = input.readUTF();
    double score = input.readDouble();
    java.util.Date date = (java.util.Date)(input.readObject());
    System.out.println(name + " " + score + " " + date);

    // Close input stream
    input.close();
  }
}
