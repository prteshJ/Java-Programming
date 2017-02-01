public class TraceLinearSearch {
	public static void main(String[] args) {
		int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
		int i = LinearSearch.linearSearch(list, 4);
		System.out.println("Searching 4 found at position " + i + ".");
		int j = LinearSearch.linearSearch(list, -4);
		System.out.println("Searching -4 found at position " + j + ".");
		int k = LinearSearch.linearSearch(list, -3);
		System.out.println("Searching -3 found at position " + k + ".");
	}
}
