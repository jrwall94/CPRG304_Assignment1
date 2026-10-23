package products;

/**
 * Jackets use an adjustment of 0.7.
 * The data-file token is Jackets. This class name is Jacket.
 */
public class Jacket extends Product
{

	/**
	 * Creates a jacket with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Jacket( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.7 times the absolute price difference.
	 *
	 * @return the adjusted price difference for a jacket
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.7 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
