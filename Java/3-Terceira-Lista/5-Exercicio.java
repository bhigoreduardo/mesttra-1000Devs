/******************************************************************************
Questão 05: Faça um algoritmo que receba dois números inteiros, calcule e mostre
a divisão do do maior número pelo menor número. Sabe-se que o segundo número não
pode ser zero, desta forma se o usuário digitar 0 deverá ser exibido uma
mensagem “A operação não pode ser realizada ”
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o valor 1: ");
		int valor1 = input.nextInt();
		System.out.print("Informe o valor 2: ");
		int valor2 = input.nextInt();
		
		if (valor1 == 0 || valor2 == 0) {
		    System.out.println("A operacao nao pode ser realizada.");
		    return;
		}
		
		if (valor1 < valor2) {
		    int aux = valor1;
		    valor1 = valor2;
		    valor2 = aux;
		}
		
		System.out.println(String.format("A divisao de %d por %d e %.2f", valor1,
		valor2, (valor1/(float)valor2)));
	}
}