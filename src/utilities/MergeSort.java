package utilities;

/**
 * Implementation of a merge algorithm to perform a descending sort
 */
public class MergeSort {

	/**
	 * Merge sorting algorithm. Recursively calls itself to sort an array in descending order
	 * @param inputArray The array to be sorted
	 */
	public static void mergeSort(Integer[] inputArray) {
		
		//Divide the array into two
		int arrayLength = inputArray.length;
		if (arrayLength <= 1) {
			return;
		}
		
		int mid = arrayLength / 2;
		Integer[] leftHalf = new Integer[mid];
		Integer[] rightHalf = new Integer[arrayLength - mid];
		
		for (int i = 0; i < mid; i++) {
			leftHalf[i] = inputArray[i];
		}
		
		for (int i = mid; i < arrayLength; i++) {
			rightHalf[i - mid] = inputArray[i];
		}
		
		//Conquer
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		//Combine
		//Add highest remaining element to the leftmost spot in the array
		int l = 0, r = 0, m = 0;

		while (l < leftHalf.length && r < rightHalf.length) {
			if (leftHalf[l] > rightHalf[r]) {
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