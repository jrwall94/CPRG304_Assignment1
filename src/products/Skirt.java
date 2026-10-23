package products;

/**
 * Skirts use an adjustment of 0.1.
 * The data-file token is Skirts. This class name is Skirt.
 */
public class Skirt extends Product
{

	/**
	 * Creates a skirt with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public Skirt( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.1 times the absolute price difference.
	 *
	 * @return the adjusted price difference for a skirt
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.1 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
