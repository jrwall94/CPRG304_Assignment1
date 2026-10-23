package utilities;

import products.Product;

public class QuickSort {

	public static void quickSort(Product[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(Product[] arr, int low, int high) {
	    if (low >= high) return;
	    int mIndex = medianOf3(arr, low, high);
	    int left = low, right = high;
	    Product pivot = arr[mIndex];

	    while (left <= right) {

			for (; left <= high; left++ ) {
				if (pivot.compareTo(arr[left]) >= 0) {
					break;
				}
			}

			for (; right >= low; right-- ) {
				if (pivot.compareTo(arr[right]) <= 0) {
					break;
				}
			}

			//Swap
		    if (left <= right) {
		        Product temp = arr[right];
		        arr[right] = arr[left];
		        arr[left] = temp;
		        left++;
		        right--;
		    }
	    }

	    quickSort(arr, low, right);
	    quickSort(arr, left, high);
	}

	private static int medianOf3(Product[] arr, int low, int high) {

		int mIndex = low + ((high - low) / 2);

	    if (arr[low].compareTo(arr[mIndex]) < 0) {
	        Product temp = arr[low];
	        arr[low] = arr[mIndex];
	        arr[mIndex] = temp;
	    }
	    if (arr[low].compareTo(arr[high]) < 0) {
	        Product temp = arr[low];
	        arr[low] = arr[high];
	        arr[high] = temp;
	    }
	    if (arr[mIndex].compareTo(arr[high]) < 0) {
	        Product temp = arr[mIndex];
	        arr[mIndex] = arr[high];
	        arr[high] = temp;
	    }

	    return mIndex;
	}
}