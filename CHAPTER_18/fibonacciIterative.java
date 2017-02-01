import java.util.Scanner;

public class fibonacciIterative {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();
		long result = fib(index);
		System.out.println("The Fibonacci number at index " + index + " is " + result);
	}

	public static long fib(int n) {
		int f0 = 0;
		int f1 = 1;
		int currentFib = -1;
		if(n == 0) {
			currentFib = 0;
		}
		if(n == 1) {
			currentFib = 1;
		}

		for(int i = 1; i < n; i++) {
			currentFib = f0 + f1;
			f0 = f1;
			f1 = currentFib;
		}

		return currentFib;
	}
}
