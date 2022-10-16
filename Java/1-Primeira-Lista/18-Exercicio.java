/******************************************************************************
18. Três amigos, Carlos, André e Felipe. decidiram rachar igualmente a conta de um bar.
Faça um algoritmo para ler o valor total da conta e imprimir quanto cada um deve pagar,
mas faça com que Carlos e André não paguem centavos. Ex: uma conta de R$101,53
resulta em R$33,00 para Carlos, R$33,00 para André e R$35,53 para Felipe.
*******************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		float valorConta, divisao, resto;
		
		System.out.print("Informe o valor da conta: ");
		valorConta = input.nextFloat();
		
		divisao = (float) Math.floor(valorConta / 3);
		resto = valorConta - ( 2 * divisao);
		
		System.out.printf("Carlos pagara: R$ %.0f\n", divisao);
		System.out.printf("Andre pagara: R$ %.0f\n", divisao);
		System.out.printf("Felipe pagara: R$ %.2f\n", resto);
	}
}