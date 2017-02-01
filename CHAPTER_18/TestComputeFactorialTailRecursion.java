import java.util.Scanner;

public class TestComputeFactorialTailRecursion {
	public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter a nonegative number: ");
        	int number  = input.nextInt();
		long factorial = ComputeFactorialTailRecursion.factorial(number);
		System.out.println("The factorial of number is " + factorial);
	}
}
