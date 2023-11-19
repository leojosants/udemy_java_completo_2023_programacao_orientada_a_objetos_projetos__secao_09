package entities;

import java.util.Date;

public class Order {
	/*
	 * attributes
	 */
	private Date date;
	private Product product;

	/*
	 * constructor
	 */
	public Order(Date date, Product product) {
		this.date = date;
		this.product = product;
		this.product.name = "TV";
	}

	/*
	 * getters and setters
	 */
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
