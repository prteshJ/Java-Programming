package liangChapter23_examples;

public class InsertionSort {
	/** The method for sorting the numbers */
	
	public static void insertionSort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			 /** Insert list[i] into a sorted sublist list[0..i-1] so that
	         list[0..i] is sorted. */
			int currElement = list[i];
			int k;
			for(k = i - 1; k >= 0 && list[k] > currElement; k--) {
				list[k + 1] = list[k];
			}
			
			// Insert the current element into list[k + 1]
			list[k + 1] = currElement;
		}
	}
	
	public static void main(String[] args) {
		int[] list = {1, 9, 4, 6, 5, -4};
		InsertionSort.insertionSort(list);
		
		System.out.println("SORTED LIST: ");
		for(Integer element: list) {
			System.out.print(element + " ");
		}
	}
}
