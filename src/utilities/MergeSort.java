package utilities;

import java.util.Comparator;

import products.*;

/**
 * Implementation of a merge algorithm to perform a descending sort
 */
public class MergeSort {

	/**
	 * Merge sorting algorithm. Recursively calls itself to sort an array in descending order
	 * @param inputArray The array to be sorted
	 */
	public static void mergeSort(Product[] inputArray, Comparator<Product> comparator) {
		
		//Divide the array into two
		int arrayLength = inputArray.length;
		if (arrayLength <= 1) {
			return;
		}
		
		int mid = arrayLength / 2;
		Product[] leftHalf = new Product[mid];
		Product[] rightHalf = new Product[arrayLength - mid];
		
		for (int i = 0; i < mid; i++) {
			leftHalf[i] = inputArray[i];
		}
		
		for (int i = mid; i < arrayLength; i++) {
			rightHalf[i - mid] = inputArray[i];
		}
		
		//Conquer
		mergeSort(leftHalf, comparator);
		mergeSort(rightHalf, comparator);
		
		//Combine
		//Add highest remaining element to the leftmost spot in the array
		int l = 0, r = 0, m = 0;

		while (l < leftHalf.length && r < rightHalf.length) {
			
			if (comparator.compare(leftHalf[l], rightHalf[r]) > 0) {
				inputArray[m] = leftHalf[l];
				l++;
				m++;
			}
			else {
				inputArray[m] = rightHalf[r];
				r++;
				m++;
			}
		}
		
		//Deal with any remaining elements after one array is empty
		while (l < leftHalf.length) {
			inputArray[m] = leftHalf[l];
			l++;
			m++;
		}
		while (r < rightHalf.length) {
			inputArray[m] = rightHalf[r];
			r++;
			m++;
		}
		
		
	}

}