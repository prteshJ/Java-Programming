package liangChapter24_Examples;

public class TestMyLinkedList {
	/** Main method */
	public static void main(String[] args) {
		// Create a list for strings
		MyLinkedList<String> list = new MyLinkedList<String>();

		// Add elements to the list
		list.add("America"); // Add it to the list
		System.out.println("(1) " + list);

		list.add(0, "Canada"); // Add it to the beginning of the list
		System.out.println("(2) " + list);

		list.add("Russia"); // Add it to the end of the list
		System.out.println("(3) " + list);

		list.addLast("France"); // Add it to the end of the list
		System.out.println("(4) " + list);

		list.add(2, "Germany"); // Add it to the list at index 2
		System.out.println("(5) " + list);

		list.add(5, "Norway"); // Add it to the list at index 5
		System.out.println("(6) " + list);

		list.add(0, "Poland"); // Same as list.addFirst("Poland")
		System.out.println("(7) " + list);

		// Remove elements from the list
		list.remove(0); // Same as list.remove("Australia") in this case
		System.out.println("(8) " + list);

		list.remove(2); // Remove the element at index 2
		System.out.println("(9) " + list);

		list.remove(list.size() - 1); // Remove the last element
		System.out.print("(10) " + list + "\n(11) ");

		// custom operations to check self implemented operations

		list.add("America");

		for (String s: list)
			System.out.print(s.toUpperCase() + " ");

		list.contains("Russia"); 

		System.out.println("Found " + list.get(0) + " at index " + list.indexOf(list.get(0)));

		System.out.println("Last index of " + list.get(list.size() - 1) + " is " + list.lastIndexOf(list.get(list.size() -1)));

		System.out.println(list.set(4, "London") + " was replaced by " + list.get(4));

		System.out.println("Latest content of list: ");

		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).toUpperCase() + " ");
		}

		list.clear();
		System.out.println("\nAfter clearing the list, the list size is " 
				+ list.size());
	}
}
