package external;

import java.util.Comparator;

import products.Product;

/**
 * Comparator method to compare items by original price
 */
public class UpdatedCompare implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getUpdatedPrice(), o2.getUpdatedPrice());

	}

}
