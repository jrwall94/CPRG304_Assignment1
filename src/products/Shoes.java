package products;

/**
 * Shoes use an adjustment of 0.4.
 * The real difference is 0.4 times the absolute difference of the two prices.
 */
public class Shoes extends Product
{

	/**
	 * Creates a pair of shoes with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Shoes( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.4 times the absolute price difference.
	 *
	 * @return the adjusted price difference for shoes
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.4 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
