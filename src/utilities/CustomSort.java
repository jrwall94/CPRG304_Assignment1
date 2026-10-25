package utilities;

import java.util.Comparator;

import products.Product;

/**
 * Holds a custom sorting algorithm to sort in descending order.
 * The chosen algorithm was a heap sort.
 */
public class CustomSort {
	
	/**
	 * Performs a heap sort. Creates a min heap in order to perform a descending sort
	 * <p>Pseudocode:</p>
	 * <ol>
	 * <li>Create a min heap from the array to be sorted</li>
	 * <li>Swap the first item with the last in the heap. This last item is now sorted and can be ignored</li>
	 * <li>Restore the min heap</li>
	 * <li>Continue steps 2 and 3 until every item has been sorted</li>
	 * </ol>
	 * <h2>Time Complexity: </h2>O(nlogn)
	 * <h2>Space Complexity: </h2>O(1) - Only needs one single temp variable for swapping
	 * 
	 * @param arr The Product array to be sorted
	 * @param comparator The comparator to use to compare items in the array
	 */
	public static void heapSort(Product[] arr, Comparator<Product> comparator) {
		int arrSize = arr.length;
		
		//Build the min heap by rearranging the original array
		for (int i = (arrSize / 2) - 1; i >= 0; i--) {
			heapify(arr, comparator, arrSize, i);
		}
		
		//Iterate through the heap, ignoring the new last element each time as it becomes sorted
		for (int i = arrSize - 1; i > 0; i--) {
			
			//Swap the first and last elements to sort the last
			Product temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//Restore the min heap structure
			heapify(arr, comparator, i, 0);
		}
		
	}
		
	private static void heapify(Product[] arr, Comparator<Product> comparator, int arrSize, int root) {
		//Smallest starts as the root
		int smallest = root;
		//Find the left and right children with normal heap formula
		int left = (2 * root) + 1;
		int right = (2 * root) + 2;
		
		// If left child is smaller, set as smallest
		if ((left < arrSize) && (comparator.compare(arr[left], arr[smallest]) < 0)) {
			smallest = left;
		}
		
		// If right child is smaller, set as smallest
		if ((right < arrSize) && (comparator.compare(arr[right], arr[smallest]) < 0)) {
			smallest = right;
		}
		
		// If smallest is not the root, swap root with smallest
		if (smallest != root) {
			Product temp = arr[root];
			arr[root] = arr[smallest];
			arr[smallest] = temp;
			
			// Heapify the affected sub-tree
			heapify(arr, comparator, arrSize, smallest);
		}
	}
	
}
