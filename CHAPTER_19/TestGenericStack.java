public class TestGenericStack {
	public static void main(String[] args) {
		GenericStack<String> stack1 = new GenericStack<>();
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Berlin");
		while(!stack1.isEmpty()) {
			System.out.print(stack1.pop() + " ");
		}
		System.out.printf("%n");

		GenericStack<Integer> stack2 = new GenericStack<>();
		stack2.push(1); // autoboxing 1 to new Integer(1)
		stack2.push(2);
		stack2.push(3);
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop() + "\t");
		}
		System.out.printf("%n");
	}
}
