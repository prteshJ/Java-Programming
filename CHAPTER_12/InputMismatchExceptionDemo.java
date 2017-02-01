import java.util.*;

public class InputMismatchExceptionDemo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean continueInput = true;

    do {
      try {
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
  
        // Display the result
        System.out.println(
          "The number entered is " + number);
        
        continueInput = false;
      } 
      catch (InputMismatchException ex) {
        System.out.println("Try again. (" + 
          "Incorrect input: an integer is required)");
        input.nextLine(); // discard input 
	/************************************************************************/
	/*               SCANNER'S NEXT LINE METHOD                             */
	/* nextLine() stores user typed 3.5 {press Enter] so \n is discarded    */
	/* but 3.5 is stored in buffer and when you cahge above line to print   */
        /* input.nextLine() contents you see indeeed this is what had happened! */
	/************************************************************************/
      }
    } while (continueInput);
  }
}
