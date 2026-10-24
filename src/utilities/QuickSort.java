package utilities;

import java.util.Comparator;

import products.Product;

public class QuickSort {

	
	
	public static void quickSort(Product[] arr, Comparator<Product> comparator) {
		quickSort(arr, 0, arr.length - 1, comparator);
	}
	
	private static void quickSort(Product[] arr, int low, int high, Comparator<Product> comparator) {
	    if (low >= high) return;
	    int mIndex = medianOf3(arr, low, high, comparator);
	    int left = low, right = high;
	    Product pivot = arr[mIndex];

	    while (left <= right) {

			for (; left <= high; left++ ) {
				if (comparator.compare(pivot, arr[left]) >= 0) {
					break;
				}
			}

			for (; right >= low; right-- ) {
				if (comparator.compare(pivot, arr[right]) <= 0) {
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

	    quickSort(arr, low, right, comparator);
	    quickSort(arr, left, high, comparator);
	}

	private static int medianOf3(Product[] arr, int low, int high, Comparator<Product> comparator) {
		
		int mIndex = low + ((high - low) / 2);
		
	    if (comparator.compare(arr[low], arr[mIndex]) < 0) {
	        Product temp = arr[low];
	        arr[low] = arr[mIndex];
	        arr[mIndex] = temp;
	    }
	    if (comparator.compare(arr[low], arr[high]) < 0) {
	        Product temp = arr[low];
	        arr[low] = arr[high];
	        arr[high] = temp;
	    }
	    if (comparator.compare(arr[mIndex], arr[high]) < 0) {
	        Product temp = arr[mIndex];
	        arr[mIndex] = arr[high];
	        arr[high] = temp;
	    }

	    return mIndex;
	}
}