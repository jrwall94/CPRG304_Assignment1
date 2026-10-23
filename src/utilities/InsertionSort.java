package utilities;

import products.Product;
/**
 * Insertion sort arranges Product objects in descending order
 */
public class InsertionSort {
	//sort the array using compareTo
	public static void insertionSort (Product[] arr ) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			Product element = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1].compareTo(element) < 0) {
				arr[j] = arr[j - 1];
				j = j - 1;
			}
			
			arr[j] = element;
		}
	}
	
}