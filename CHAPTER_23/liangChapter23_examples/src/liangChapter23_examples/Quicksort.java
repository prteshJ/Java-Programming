package liangChapter23_examples;

public class Quicksort {

	public static void quicksort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if(last > first) {
		int pivot = partition(list, first, last);
		quickSort(list, first, pivot - 1);
		quickSort(list, pivot + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		
		while (high > low) {
			// Search forward from left
			if(low <= high && list[low] <= pivot) 
				low++;
			
			// Search backward from right
			if(low <= high && list[high] > pivot)
				high--;
			
			// Swap two elements in the list
			if(high > low) {
				int temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		
		while(high > first && list[high] >= pivot) {
			high--;
		}
		
		// Swap pivot with list[high]
		if(pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	
	/** A test method */
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		quicksort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}

}
