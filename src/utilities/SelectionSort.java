package utilities;

import products.Product;

public class SelectionSort {
	public static void selectionSort(Product[] inputArray) {
		int arrLength = inputArray.length; 
		for (int i=0; i < arrLength - 1; i++  ) {
			
			int maxIndex = i;
			
			for (int j = i + 1; j < arrLength; j++) {
				if (inputArray[maxIndex].compareTo(inputArray[j]) < 0 ) {
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


