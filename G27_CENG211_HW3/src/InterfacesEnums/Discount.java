package InterfacesEnums;

public enum Discount {
	GENERAL(0),
	STUDENTWITHSCHOLAR(0.3),
	STUDENTWITHOUTSCHOLAR(0.2);
	
	private final double discount;

	Discount(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}
	
}
