package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un n�mero para ver si es divisible por 2");
		int leido=entrada.nextInt();
		if (leido%2==0) {
			System.out.println("El n�mero le�do "+leido+" es divisible por 2");
		}
		else {
			System.out.println("El n�mero le�do "+leido+" no es divisible por 2");
		}
	}

}
