import java.util.Scanner;

public class TestDoWhile {
	public static void main (String[] args) {
		int data;
		int sum = 0;

		Scanner input = new Scanner(System.in);

		do
		{
			System.out.print("Enter an integer (input ends if 0 is entered)");
			data = input.nextInt();
			
			sum += data;
		}while(data != 0);

		System.out.println("The sum is " + sum);
	}
}