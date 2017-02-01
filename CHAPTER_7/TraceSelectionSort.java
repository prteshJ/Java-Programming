public class TraceSelectionSort {
	public static void main(String[] args) {
		double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
		SelectionSort.selectionSort(list);

		for(int k = 0; k <= list.length - 1; k++) {
			if(k < list.length -1 )
				System.out.print("" + list[k] + " ");
			else
				System.out.println(list[k]);
		}
	}
}
