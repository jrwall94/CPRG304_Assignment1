package products;

/**
 * Shorts use an adjustment of 0.3.
 * The real difference is 0.3 times the absolute difference of the two prices.
 */
public class Shorts extends Product
{

	/**
	 * Creates a pair of shorts with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Shorts( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.3 times the absolute price difference.
	 *
	 * @return the adjusted price difference for shorts
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.3 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
