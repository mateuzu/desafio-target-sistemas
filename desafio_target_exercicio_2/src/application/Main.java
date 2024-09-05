package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		int input = 0;

		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Erro: Digite números inteiros!");
			scanner.close();
			return;
		}

		int atual = 0; //Valor atual
		int proximo = 1; //Próximo valor
		int soma = 0; //Soma
		boolean pertence = false;

		while(atual <= input) {
			if (atual == input) {
				pertence = true;
				break;
			}
			soma = atual + proximo;
			atual = proximo;
			proximo = soma;
		}

		if (pertence) {
			System.out.println("O número " + input + " pertence a sequência de Fibonacci!");
		} else {
			System.out.println("O número " + input + " não pertence a sequência de Fibonacci!");
		}

		scanner.close();
	}

}
