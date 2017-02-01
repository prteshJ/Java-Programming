package liangChapter23_examples;

public class BasicBubbleSort {

	public static void bubbleSort(int[] list) {
		for(int k = 1; k < list.length; k++) {
			// Perform the kth pass
			for(int i = 0; i < list.length - k; i++) {
				if(list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		bubbleSort(list);
		
		System.out.println("BASIC BUBBLE SORT SORTED LIST: ");
		for(Integer element: list) {
			System.out.print(element + " ");
		}
	}
}
