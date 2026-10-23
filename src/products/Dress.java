package products;

/**
 * Dresses use an adjustment of 0.6.
 * The data-file token is Dresses. This class name is Dress.
 */
public class Dress extends Product
{

	/**
	 * Creates a dress with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Dress( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.6 times the absolute price difference.
	 *
	 * @return the adjusted price difference for a dress
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.6 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
