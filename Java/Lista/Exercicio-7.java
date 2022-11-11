/******************************************************************************
4. Faça um algoritmo que calcule e mostre a tabuada de (+, -, * e /) de um número
digitado pelo usuário.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o numero para o calculo da tabuada: ");
		int numero = input.nextInt();
		
		System.out.println("Tabuada do + e - para o numero " + numero + ":");
		for (int i = 0; i < 10; i++) {
		    System.out.println(numero + " + " + i + " = " + (numero+i) + "     " +
		    numero + " - " + i + " = " + Math.abs(numero-i));
		}
		
		System.out.println("Tabuada do * e / para o numero " + numero + ":");
		for (int i = 0; i < 10; i++) {
		    if (i == 0) {
		        System.out.println(numero + " * " + i + " = " + (numero*i) + "     " +
		    numero + " / " + i + " = nao existe divisao por zero");
		        continue;
		    }
		    System.out.println(numero + " * " + i + " = " + (numero*i) + "     " +
		    numero + " / " + i + " = " + String.format("%.2f", ((double) numero/i)));
		}
	}
}