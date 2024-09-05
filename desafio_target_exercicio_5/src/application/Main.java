package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe uma palavra: ");
		String input = scanner.nextLine();
		
		String invertida = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			invertida += input.charAt(i);
		}
		
		System.out.println("Palavra invertida: " + invertida);
		scanner.close();
	}

}
