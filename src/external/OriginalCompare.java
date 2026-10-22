package external;

import java.util.Comparator;

import products.Product;

/**
 * Comparator method to compare items by original price
 */
public class OriginalCompare implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getOriginalPrice(), o2.getOriginalPrice());
	}

}
