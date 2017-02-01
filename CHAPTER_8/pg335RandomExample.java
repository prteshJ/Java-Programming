import java.util.*;

public class pg335RandomExample {
	public static void main(String[] args) {
		Random random1 = new Random(3);
		System.out.print("From random1: ");
		for(int i = 0; i < 10; i++)
		System.out.print(random1.nextInt(1000) + " ");

		Random random2 = new Random(3);
		System.out.print("\nFrom random2: ");
		for (int i = 0; i < 10; i++)
		System.out.print(random2.nextInt(1000) + " ");
	}
}
