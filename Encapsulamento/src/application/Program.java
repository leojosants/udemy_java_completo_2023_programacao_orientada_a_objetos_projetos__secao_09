package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		Product product;
		String name = "";
		double price = 0.0;

		System.out.println("\nEntre com os dados do produto");

		name = requestName(scanner);
		price = requestPrice(scanner);

		product = new Product(name, price);
		
		product.setName("Computador");

		System.out.printf("\nAtualizado nome do produto: %s%n", product.getName());

		product.setPrice(1200.00);

		System.out.printf("\nAtualizado pre�o do produto: %s%n", product.getPrice());

		displayData(product);

		requestQuantityOfProductToAddInStock(scanner, product);

		displayData(product);

		requestQuantityOfProductToRemoveFromStock(scanner, product);

		displayData(product);

		scanner.close();

		System.out.println("-> fim do programa");

	}

	/*
	 * functions
	 */
	private static String requestName(Scanner scanner) {
		String name = "";
		System.out.print("Nome do produto: ");
		name = scanner.nextLine().toUpperCase().trim();
		return name;
	}

	private static double requestPrice(Scanner scanner) {
		double price = 0.0;
		System.out.print("Pre�o do produto: ");
		price = scanner.nextDouble();
		return price;
	}

	private static void displayData(Product product) {
		System.out.println("\nExibindo dados do Produto");
		System.out.println(product.toString());
	}

	private static void requestQuantityOfProductToAddInStock(Scanner scanner, Product product) {
		System.out.print("Entre com a quantidade de produtos a ser adicionado no estoque: ");
		int quantityToBeAdded = scanner.nextInt();
		product.addProducts(quantityToBeAdded);
	}

	private static void requestQuantityOfProductToRemoveFromStock(Scanner scanner, Product product) {
		System.out.print("Entre com a quantidade de produtos a ser removido no estoque: ");
		int quantityToBeRemoved = scanner.nextInt();
		product.removeProducts(quantityToBeRemoved);
	}
}
