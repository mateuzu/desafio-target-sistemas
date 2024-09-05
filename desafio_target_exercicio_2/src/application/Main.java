package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número: ");
		int input = 0;

		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Digite números inteiros!");
			scanner.close();
			System.exit(0);
		}
				
		List<Integer> sequencia = new ArrayList<>();
		int atual = 0; //Valor atual
		int proximo = 1; //Próximo valor
		int soma = 0; //Soma

		for (int i = 0; atual <= input; i++) {
			sequencia.add(atual);
			soma = atual + proximo;
			atual = proximo;
			proximo = soma;
		}

		if (sequencia.contains(input)) {
			System.out.println("O número " + input + " pertence a sequência de Fibonacci");
		} else {
			System.out.println("O número " + input + " não pertence a sequência de Fibonacci");
		}

		scanner.close();
	}

}
