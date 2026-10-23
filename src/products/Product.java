package products;

/**
 * Abstract product with an original price and an updated price.
 * Each subclass calculates its own adjusted price difference.
 * Natural ordering uses that difference and follows the Comparable contract:
 * a smaller difference is negative, a larger difference is positive.
 * Sorting algorithms use that result to arrange products from largest to smallest.
 */
public abstract class Product implements Comparable<Product>
{

	/** The price before the update. */
	private double originalPrice;

	/** The price after the update. */
	private double updatedPrice;

	/**
	 * Creates a product with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Product( double originalPrice, double updatedPrice )
	{
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}

	/**
	 * Calculates adjustment times the absolute difference of the two prices.
	 * Each product type supplies its own adjustment factor.
	 *
	 * @return the adjusted price difference
	 */
	public abstract double calcRealDiff();

	/**
	 * Compares two products by {@link #calcRealDiff()}.
	 * The sign is not reversed: this product is smaller when its difference is smaller.
	 *
	 * @param that the product to compare against
	 * @return a negative integer, zero, or a positive integer as this difference
	 *         is less than, equal to, or greater than the other difference
	 */
	@Override
	public int compareTo( Product that )
	{
		return Double.compare( this.calcRealDiff(), that.calcRealDiff() );
	}

	/**
	 * Returns the original price.
	 *
	 * @return the original price
	 */
	public double getOriginalPrice()
	{
		return this.originalPrice;
	}

	/**
	 * Changes the original price.
	 *
	 * @param originalPrice the new original price
	 */
	public void setOriginalPrice( double originalPrice )
	{
		this.originalPrice = originalPrice;
	}

	/**
	 * Returns the updated price.
	 *
	 * @return the updated price
	 */
	public double getUpdatedPrice()
	{
		return this.updatedPrice;
	}

	/**
	 * Changes the updated price.
	 *
	 * @param updatedPrice the new updated price
	 */
	public void setUpdatedPrice( double updatedPrice )
	{
		this.updatedPrice = updatedPrice;
	}

	/**
	 * Returns the product type, both prices, and the adjusted difference.
	 *
	 * @return a single-line description of this product
	 */
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + " " + this.originalPrice + " "
			+ this.updatedPrice + " " + this.calcRealDiff();
	}

}
