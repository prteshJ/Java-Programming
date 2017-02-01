/********************************************************************************************
				PG 748
The program has a compile error because intStack is not an instance of GenericStack<Number>.
Thus,you cannot invoke max(intStack).
The fact is that Integer is a subtype of Number, but GenericStack<Integer> is not a subtype
of GenericStack<Number>. To circumvent this problem, use wildcard generic types.
A wildcard generic type has three forms:? and ? extends T,as well as ? super T, where
T is a generic type.
The first form,?, called an unbounded wildcard, is the same as ? extends Object.
The second form, ? extends T, called a bounded wildcard, represents T or a subtype of T.
The third form, ? super T, called a lower-bound wildcard, denotes T or a supertype of T.
You can fix the error by replacing erroneous line as follows:
public static double max(GenericStack<? extends Number> stack) {
<? extends Number> is a wildcard type that represents Number or a subtype of Number, so it
is legal to invoke max(new GenericStack<Integer>()) or max(new GenericStack<Double>()).
********************************************************************************************/

public class WildCardDemo1 {
  public static void main(String[] args ) {
     GenericStack<Integer> intStack = new GenericStack<Integer>();
     intStack.push(1); // 1 is autoboxed into new Integer(1)
     intStack.push(2);
     intStack.push(-2);

// Error:   on below line
	System.out.print("The max number is " + max(intStack));
  }

  /** Find the maximum in a stack of numbers */
  public static double max(GenericStack<Number> stack) {  // Replace Number by ? extends Number to remove error
     double max = stack.pop().doubleValue(); // initialize max

     while (!stack.isEmpty()) {
       double value = stack.pop().doubleValue();
       if (value > max)
         max = value;
     }

     return max;
  }
}
