package utilities;

import java.util.Comparator;

import products.Product;

public class SelectionSort {
	
	
	
	public static void selectionSort(Product[] inputArray, Comparator<Product> comparator) {
		int arrLength = inputArray.length; 
		for (int i=0; i < arrLength - 1; i++  ) {
			
			int maxIndex = i;
			
			for (int j = i + 1; j < arrLength; j++) {
				if (comparator.compare(inputArray[maxIndex], inputArray[j]) < 0) {
					maxIndex = j;
				}

			}
			
		//Swap
		Product temp = inputArray[i];
		inputArray[i] = inputArray[maxIndex];
		inputArray[maxIndex] = temp;
			
	
		}
			

			
	

	}
		
}


