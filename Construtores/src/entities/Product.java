package entities;

public class Product {
	/*
	 * attribute
	 */
	public String name;
	public double price;
	public int quantity;

	/*
	 * constructor
	 */
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	/*
	 * methods
	 */
	public double totalValueInStock() {
		return price * quantity;
	}

	public void addProducts(int quantity) {
		this.quantity += quantity;
	}

	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}

	public String toString() {
		return String.format("%s, ", this.name) 
				+ String.format("$ %.2f, ", this.price)
				+ String.format("%d unidades, ", this.quantity) 
				+ String.format("$ %.2f%n", this.totalValueInStock());
	}
}
