package net.lecnam.battlefield.menneboo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInt {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static int readInt(int n) {
		int input = -1;
		while (input < 0 || input >= n) {
			System.out.print("Faites un choix (0-" + (n - 1) + ") ? ");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		} 
		return input;
	}
}
