/******************************************************************************
8. Faça um algoritmo para ler o salário de um funcionário e aumentá-Io em 15%. Após o
aumento, desconte 11% de INSS e 8% de FGTS. Imprima o salário inicial, o salário com o
aumento, o salário final, o desconto do INSS, o desconto do FGTS e o Total de Descontos
(INSS+FGTS).
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    float salario, salarioAumento, descontoINSS, descontoFGTS, descontoTotal,
	    salarioFinal;
	    char percent = '%';
	    
		System.out.print("Informe o salario: ");
		salario = input.nextFloat();
		
		salarioAumento = 1.15f * salario;
		descontoINSS = salarioAumento * 0.11f;
		descontoFGTS = salarioAumento * 0.08f;
		descontoTotal = descontoINSS + descontoFGTS;
		salarioFinal = salarioAumento - descontoTotal;
		
		System.out.printf("Salario Inicial: %.2f \n", salario);
		System.out.printf("Salario Reajustado: %.2f \n", salarioAumento);
		System.out.printf("Desconto 11%c INSS: %.2f \n", percent, descontoINSS);
		System.out.printf("Desconto 8%c FGTS: %.2f \n", percent, descontoFGTS);
		System.out.printf("Total de desconto INSS+FGTS: %.2f", descontoTotal);
		System.out.printf("Salario Final: %.2f", salarioFinal);
		
	}
}