package utilities;

import java.util.Comparator;

import products.Product;

/**
 * Bubble sort that arranges products from largest to smallest.
 * A negative comparison means the left product is smaller, so those two
 * products are swapped. The array is never sorted ascending and then reversed.
 * The one-argument sort uses {@link Product#compareTo(Product)} for option -td.
 * The two-argument sort uses a Comparator: OriginalCompare for -to,
 * UpdatedCompare for -tu.
 */
public class BubbleSort
{

	/**
	 * Prevents instantiation of this utility class.
	 */
	private BubbleSort()
	{
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

		int size = products.length;
		for( int pass = 0; pass < size - 1; pass++ )
		{
			boolean swapped = false;
			for( int index = 0; index < size - 1 - pass; index++ )
			{
				if( comparator.compare( products[index], products[index + 1] ) < 0 )
				{
					swap( products, index, index + 1 );
					swapped = true;
				}
			}
			if( !swapped )
			{
				break;
			}
		}
	}

	/**
	 * Exchanges the products at two indexes.
	 *
	 * @param products the array containing the products
	 * @param first the first index
	 * @param second the second index
	 */
	private static void swap( Product[] products, int first, int second )
	{
		Product temporary = products[first];
		products[first] = products[second];
		products[second] = temporary;
	}

}
