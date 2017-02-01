public class TestRecursiveBinarySearch {
	public static void main(String[] args) {
		int[] list = { -1, 0, 1, 2, 3, 6, 8, 12};
		int keyFound = RecursiveBinarySearch.recursiveBinarySearch(list, 8);
		System.out.println("Key 8 found at position " + keyFound + " in the list.");
		System.out.println("Key 0 found at position " + RecursiveBinarySearch.recursiveBinarySearch(list, 0) + " in the list.");
	}
}
