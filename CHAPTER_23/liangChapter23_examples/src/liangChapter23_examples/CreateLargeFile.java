package liangChapter23_examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *  Liang's example has 800004 which is incorrect to 
 *  write 2 million integers and instead should be
 *  8000004
 * @author PriteshJ
 *
 */
public class CreateLargeFile {
	public static void main(String[] args) throws Exception {
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largedata.dat")));
		
		/*******************************************************
		 * Here, writeInt method writes 4 bytes at a time
		 * with high order byte first. 
		 * It increments counter by 4 each time.
		 * So effectively it writes 8000004/4 i.e. approximately
		 * 2 million (2000000) integer values to the file 
		********************************************************/
		for(int i = 0; i < 8000004; i++)
			output.writeInt((int) (Math.random() * 1000000));
		
		output.close();
		
		// Display first 100 numbers
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("largedata.dat")));
		for(int i = 0; i < 100; i++) 
			System.out.print(input.readInt() + " ");
		
		input.close();
	}
}
