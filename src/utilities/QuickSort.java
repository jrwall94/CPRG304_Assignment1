package utilities;

import java.util.Comparator;

import products.Product;

/**
 * Quick sort that arranges products in descending order. The pivot is found
 * using medianOf3. The range is partitioned around the pivot such that any
 * items larger than the pivot on the right are moved to the left, and any items
 * smaller than the pivot on the left are moved right.
 * 
 * <p>
 * Then Quick sort is applied recursively onto the two partitioned sub arrays.
 * The recursion is stopped once there are only one or zero elements left in the
 * sub array.
 */
public class QuickSort {

	/**
	 * Sorts by the supplied comparator, largest to smallest.
	 * 
	 * @param arr        the products to sort
	 * @param comparator the ordering to apply
	 */
	public static void quickSort(Product[] arr, Comparator<Product> comparator) {
		quickSort(arr, 0, arr.length - 1, comparator);
	}

	/**
	 * Partitions the range from low to high around the pivot and then recursively
	 * sorts both sides.
	 * 
	 * @param arr        the array of products
	 * @param low        the first index of the range
	 * @param high       the last index of the range
	 * @param comparator the ordering to apply
	 */
	private static void quickSort(Product[] arr, int low, int high, Comparator<Product> comparator) {
		if (low >= high)
			return;
		int mIndex = medianOf3(arr, low, high, comparator);
		int left = low, right = high;
		Product pivot = arr[mIndex];

		while (left <= right) {

			for (; left <= high; left++) {
				if (comparator.compare(pivot, arr[left]) >= 0) {
					break;
				}
			}

			for (; right >= low; right--) {
				if (comparator.compare(pivot, arr[right]) <= 0) {
					break;
				}
			}

			// Swap
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

	/**
	 * Orders the first, center, and last products of a range such that the largest
	 * is at low, the median is at the center, and the smallest is at high.
	 * 
	 * 
	 * @param arr        the array of products
	 * @param low        the first index of the range
	 * @param high       the last index of the range
	 * @param comparator the ordering to apply
	 * @return the index of the median product, to be used as the pivot
	 */
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