package utilities;

import java.util.Comparator;

import products.Product;


/**
 * Selection sort that arranges products in descending order. 
 * Every pass finds the largest remaining product in the unsorted section 
 * and swaps it into the next position in the sorted section.
 */
public class SelectionSort {
	
	
	/**
	 * Sorts by the given comparator, largest to smallest.
	 * 
	 * @param inputArray the products to sort
	 * @param comparator the ordering to apply
	 */
	public static void selectionSort(Product[] inputArray, Comparator<Product> comparator) {
		
		int arrLength = inputArray.length; 
		
		for (int i=0; i < arrLength - 1; i++  ) {
			
			int maxIndex = i;
			
			for (int j = i + 1; j < arrLength; j++) {
				
				if (comparator.compare(inputArray[maxIndex], inputArray[j]) < 0) {
					maxIndex = j;
				}
				

			}
			
		// Swap
		Product temp = inputArray[i];
		inputArray[i] = inputArray[maxIndex];
		inputArray[maxIndex] = temp;
			
	
		}
			

			
	

	}
		
}


