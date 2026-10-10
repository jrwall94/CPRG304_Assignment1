package products;

public abstract class Product {
	
	private double originalPrice;
	private double updatedPrice;
	
	public Product(double originalPrice, double updatedPrice) {
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
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
