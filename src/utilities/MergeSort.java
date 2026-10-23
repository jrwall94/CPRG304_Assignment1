package utilities;

import java.util.Arrays;
import java.util.Comparator;

import products.Product;

/**
 * Merge sort that arranges products from largest to smallest.
 * Each sort call handles one index range: split it, finish the left half,
 * finish the right half, then merge those two halves.
 * merge always takes the larger current product. Equal products keep
 * their earlier (left) order. The array is never sorted ascending and reversed.
 * The one-argument sort uses {@link Product#compareTo(Product)} for option -td.
 * The two-argument sort uses a Comparator: OriginalCompare for -to,
 * UpdatedCompare for -tu.
 */
public class MergeSort
{

	/**
	 * Prevents instantiation of this utility class.
	 */
	private MergeSort()
	{
	}

	/**
	 * Sorts by the adjusted price difference, largest first.
	 *
	 * @param products the products to sort
	 * @throws NullPointerException when the array is missing
	 */
	public static void sort( Product[] products )
	{
		if( products == null )
		{
			throw new NullPointerException( "The product array is required." );
		}
		if( products.length < 2 )
		{
			return;
		}

		Product[] copyProducts = Arrays.copyOf( products, products.length );
		sort( products, copyProducts, 0, products.length - 1 );
	}

	/**
	 * Handles one inclusive range from left to right using compareTo.
	 * left and right are indexes of this range, not moving merge pointers.
	 *
	 * @param products the array being sorted
	 * @param copyProducts a work array of the same length
	 * @param left the first index of this range
	 * @param right the last index of this range
	 */
	private static void sort( Product[] products, Product[] copyProducts, int left, int right )
	{
		// One product: this piece is already done.
		if( left == right )
		{
			return;
		}

		int mid = left + ( right - left ) / 2;
		sort( products, copyProducts, left, mid );
		sort( products, copyProducts, mid + 1, right );
		merge( products, copyProducts, left, mid, right );
	}

	/**
	 * Merges products[left..mid] and products[mid+1..right] into one
	 * descending range. leftPos and rightPos move as values are taken.
	 *
	 * @param products the array being sorted
	 * @param copyProducts a work array holding the current range
	 * @param left   the first index of the left half
	 * @param mid    the last index of the left half
	 * @param right  the last index of the right half
	 */
	private static void merge( Product[] products, Product[] copyProducts, int left, int mid, int right )
	{
		for( int index = left; index <= right; index++ )
		{
			copyProducts[index] = products[index];
		}

		int leftPos = left;
		int rightPos = mid + 1;

		for( int putAt = left; putAt <= right; putAt++ )
		{
			if( leftPos > mid )
			{
				// Left half is empty, so take the next right product.
				products[putAt] = copyProducts[rightPos];
				rightPos++;
			}
			else if( rightPos > right )
			{
				// Right half is empty, so take the next left product.
				products[putAt] = copyProducts[leftPos];
				leftPos++;
			}
			else if( copyProducts[leftPos].compareTo( copyProducts[rightPos] ) >= 0 )
			{
				// Left current is larger or equal, so take left.
				products[putAt] = copyProducts[leftPos];
				leftPos++;
			}
			else
			{
				// Right current is larger, so take right.
				products[putAt] = copyProducts[rightPos];
				rightPos++;
			}
		}
	}

	/**
	 * Sorts by the given comparator, largest first.
	 *
	 * @param products the products to sort
	 * @param comparator the ordering to apply
	 * @throws NullPointerException when the array or comparator is missing
	 */
	public static void sort( Product[] products, Comparator<Product> comparator )
	{
		if( products == null || comparator == null )
		{
			throw new NullPointerException( "The product array and comparator are required." );
		}
		if( products.length < 2 )
		{
			return;
		}

		Product[] copyProducts = Arrays.copyOf( products, products.length );
		sort( products, copyProducts, 0, products.length - 1, comparator );
	}

	/**
	 * Handles one inclusive range from left to right using a comparator.
	 *
	 * @param products the array being sorted
	 * @param copyProducts a work array of the same length
	 * @param left    the first index of this range
	 * @param right   the last index of this range
	 * @param comparator   the ordering to apply
	 */
	private static void sort( Product[] products, Product[] copyProducts, int left, int right, Comparator<Product> comparator )
	{
		if( left == right )
		{
			return;
		}

		int mid = left + ( right - left ) / 2;
		sort( products, copyProducts, left, mid, comparator );
		sort( products, copyProducts, mid + 1, right, comparator );
		merge( products, copyProducts, left, mid, right, comparator );
	}

	/**
	 * Merges two descending halves using the given comparator.
	 *
	 * @param products the array being sorted
	 * @param copyProducts a work array holding the current range
	 * @param left the first index of the left half
	 * @param mid the last index of the left half
	 * @param right the last index of the right half
	 * @param comparator the ordering to apply
	 */
	private static void merge( Product[] products, Product[] copyProducts, int left, int mid, int right, Comparator<Product> comparator )
	{
		for( int index = left; index <= right; index++ )
		{
			copyProducts[index] = products[index];
		}

		int leftPos = left;
		int rightPos = mid + 1;

		for( int putAt = left; putAt <= right; putAt++ )
		{  // Left half is empty, so take the next right product.
			if( leftPos > mid )
			{
				products[putAt] = copyProducts[rightPos];
				rightPos++;
			}
			// right half is empty, so take the next left product.
			else if( rightPos > right )
			{
				products[putAt] = copyProducts[leftPos];
				leftPos++;
			}
			// Left current is larger or equal, so take left.
			else if( comparator.compare( copyProducts[leftPos], copyProducts[rightPos] ) >= 0 )
			{
				products[putAt] = copyProducts[leftPos];
				leftPos++;
			}
			else
			{ // Right current is larger, so take right.
				products[putAt] = copyProducts[rightPos];
				rightPos++;
			}
		}
	}

}
