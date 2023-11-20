package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);
		Account account;
		
		int number = 0;
		String holder = "";
		boolean initialDeposit = false;
		double initialDepositAmount = 0.0;
		double depositAmount = 0.0;
		double withdrawAmount = 0.0;

		number = requestNumber(scanner);

		holder = requestHolder(scanner);

		initialDeposit = checkInitialDeposit(scanner);

		if (initialDeposit) {
			initialDepositAmount = requestInitialDepositAmount(scanner);
			account = new Account(number, holder, initialDepositAmount);

		} else {
			account = new Account(number, holder);
		}

		System.out.println("\nDados da conta");
		displayData(account);

		depositAmount = requestDepositAmount(scanner);
		account.deposit(depositAmount);

		System.out.println("\nAtualização dos dados da conta");
		displayData(account);

		withdrawAmount = requestWithdrawAmount(scanner);
		account.withdraw(withdrawAmount);
		
		System.out.println("\nAtualização dos dados da conta");
		displayData(account);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestNumber(Scanner scanner) {
		int number = 0;

		do {
			System.out.print("\nEntre com o número da conta: ");
			number = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (number <= 0) {
				System.out.print("-> campo 'Entre com o número da conta' não pode ser menor ou igual a 0: ");
				number = scanner.nextInt();
				scanner.nextLine(); // buffer
			}
		} while (number <= 0);

		return number;
	}

	private static String requestHolder(Scanner scanner) {
		String holder = "";

		do {
			System.out.print("\nEntre com o titular da conta: ");
			holder = scanner.nextLine().trim();

			while (holder.equals("")) {
				System.out.print("-> campo 'Entre com o titular da conta' não pode ser vazio: ");
				holder = scanner.nextLine().trim();
			}
		} while (holder.equals(""));

		return holder;
	}

	private static boolean checkInitialDeposit(Scanner scanner) {
		boolean initialDeposit = false;
		String responseString;
		char responseChar;

		do {
			System.out.print("\nExiste depósito inicial [S / N]? ");
			responseString = scanner.nextLine().toUpperCase().trim();

			while (responseString.equals("")) {
				System.out.print("-> campo 'Existe depósito inicial [S / N]?' não pode ser vazio: ");
				responseString = scanner.nextLine().toUpperCase().trim();
			}

			responseChar = responseString.charAt(0);

			while ((responseChar != 'S') && (responseChar != 'N')) {
				System.out.print("-> campo 'Existe depósito inicial [S / N]?' somente pode receber [S / N]: ");
				responseChar = scanner.nextLine().toUpperCase().charAt(0);
			}
		} while ((responseChar != 'S') && (responseChar != 'N'));

		if (responseChar == 'S') {
			initialDeposit = true;

		} else {
			initialDeposit = false;
		}

		return initialDeposit;
	}

	private static double requestInitialDepositAmount(Scanner scanner) {
		double initialDepositAmount = 0.0;

		do {
			System.out.print("\nEntre com o valor do depósito inicial: R$ ");
			initialDepositAmount = scanner.nextDouble();

			while (initialDepositAmount <= 0) {
				System.out.print("-> campo 'Entre com o valor do depósito inicial' não pode ser menor ou igual a 0: ");
				initialDepositAmount = scanner.nextDouble();
			}
		} while (initialDepositAmount <= 0);

		return initialDepositAmount;
	}

	private static void displayData(Account account) {
		System.out.println(account.toString());
	}

	private static double requestDepositAmount(Scanner scanner) {
		double depositAmount = 0.0;

		do {
			System.out.print("\nEntre com o valor do depósito: R$ ");
			depositAmount = scanner.nextDouble();

			while (depositAmount <= 0) {
				System.out.print("-> campo 'Entre com o valor do depósito' não pode ser menor ou igual a 0: ");
				depositAmount = scanner.nextDouble();
			}
		} while (depositAmount <= 0);

		return depositAmount;
	}

	private static double requestWithdrawAmount(Scanner scanner) {
		double withdrawAmount = 0.0;

		do {
			System.out.print("\nEntre com o valor do saque: R$ ");
			withdrawAmount = scanner.nextDouble();

			while (withdrawAmount <= 0) {
				System.out.print("-> campo 'Entre com o valor do saque' não pode ser menor ou igual a 0: ");
				withdrawAmount = scanner.nextDouble();
			}
		} while (withdrawAmount <= 0);

		return withdrawAmount;
	}
}
