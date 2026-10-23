package products;

/**
 * T-shirts use an adjustment of 0.2.
 * The data-file token is TShirts. This class name is TShirt.
 */
public class TShirt extends Product
{

	/**
	 * Creates a T-shirt with both prices.
	 *
	 * @param originalPrice the price before the update
	 * @param updatedPrice the price after the update
	 */
	public TShirt( double originalPrice, double updatedPrice )
	{
		super( originalPrice, updatedPrice );
	}

	/**
	 * Returns 0.2 times the absolute price difference.
	 *
	 * @return the adjusted price difference for a T-shirt
	 */
	@Override
	public double calcRealDiff()
	{
		return 0.2 * Math.abs( this.getOriginalPrice() - this.getUpdatedPrice() );
	}

}
