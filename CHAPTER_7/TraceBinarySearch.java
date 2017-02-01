public class TraceBinarySearch {
	public static void main(String[] args) {
		int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

		int i = BinarySearch.binarySearch(list, 2); // Returns 0
		System.out.println("Found 2 at position " + i + " in list array.");

		int j = BinarySearch.binarySearch(list, 11); // Returns 4
		System.out.println("Found 11 at position " + j + " in list array.");

		int k = BinarySearch.binarySearch(list, 12); // Returns –6
		System.out.println("Found 12 at position " + k + " in list array.");

		int l = BinarySearch.binarySearch(list, 1); // Returns –1
		System.out.println("Found 1 at position " + l + " in list array.");

		int m = BinarySearch.binarySearch(list, 3); // Returns –2
		System.out.println("Found 3 at position " + m + " in list array.");
	}
}
