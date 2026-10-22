package products;

public abstract class Product implements Comparable<Product> {
	
	private double originalPrice;
	private double updatedPrice;
	
	public Product(double originalPrice, double updatedPrice) {
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}
	
	public abstract double calcRealDiff();
	
	//Add Comparable implementation with calcRealDiff()
	//**The current implementation compares the wrong values just for testing purposes**
	public int compareTo( Product that )
	{
		return Double.compare(this.getOriginalPrice(), that.getOriginalPrice());
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getUpdatedPrice() {
		return updatedPrice;
	}

	public void setUpdatedPrice(double updatedPrice) {
		this.updatedPrice = updatedPrice;
	}
	

}
