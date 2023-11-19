package entities;

public class Product {
	/*
	 * attribute
	 */
	private String name;
	private double price;
	private int quantity;

	/*
	 * constructor
	 */
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	/*
	 * constructor - overload
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	/*
	 * getters and setters
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getQuantity() {
		return this.quantity;
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
		return String.format("%s, ", this.name) + String.format("$ %.2f, ", this.price)
				+ String.format("%d unidades, ", this.quantity) + String.format("$ %.2f%n", this.totalValueInStock());
	}
}
