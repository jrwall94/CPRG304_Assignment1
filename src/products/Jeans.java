package products;

/**
 * Jeans use an adjustment of 0.5.
 * The real difference is 0.5 times the absolute difference of the two prices.
 */
public class Jeans extends Product
{

	/**
	 * Creates a pair of jeans with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Jeans( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.5 times the absolute price difference.
	 *
	 * @return the adjusted price difference for jeans
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.5 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
