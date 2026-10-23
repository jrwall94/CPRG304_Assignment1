package utilities;

import java.util.Comparator;

import products.Product;
/**
 * Insertion sort arranges Product objects in descending order
 */
public class InsertionSort {
	
	public static void insertionSort (Product[] arr, Comparator<Product> comparator) {
		int n = arr.length;
		//start at the second element, first element in unsorted portion becomes the first element in the sorted portion
		for (int i = 1; i < n; ++i) {
			//current place in unsorted portion, element is an item that is currently being sorted
			Product element = arr[i];
			int j = i; //j is an index in unsorted portion
			//comparator decides which item is smaller
			while (j > 0 && comparator.compare(arr[j - 1], element) < 0) {
				arr[j] = arr[j - 1]; // shift each element encountered to the right to create a gap for the element currently being sorted
				j = j - 1; //move gap one spot to the left
			}
			
			arr[j] = element; //insert element to the sorted portion
		}
	}
}
