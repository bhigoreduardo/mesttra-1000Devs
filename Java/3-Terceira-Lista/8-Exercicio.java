/******************************************************************************
Questão 08: Faça um algoritmo para ler o salário de um funcionário e aumentá-Io
em 5%. Após o aumento, desconte 11% de INSS e 8% de FGTS e o % do IR conforme a
tabela abaixo. Imprima o salário inicial, o salário com o aumento, o salário
final, o desconto do INSS, o desconto do FGTS, o desconto do IR e o Total de
Descontos (INSS+FGTS+IR). O desconto do Imposto de Renda é variável. Quando o
salário do funcionário muda de uma faixa de desconto de IR para outra, ele pode
mesmo com o aumento de 5% receber menos do que quando comparado antes do aumento.
O seu algoritmo deve calcular e descobrir se o novo salário (5%) fará com que o
usuário receba um salário final menor do que antes de aplicar os 5%.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		float salarioInicial, salarioAumento, descontoINSS, descontoFGTS, descontoTotal,
	    descontoIR, salarioFinal, aliquotaIR = 0.0f;
	    
		System.out.print("Informe o salario inicial: ");
		salarioInicial = input.nextFloat();
		
		salarioAumento = 1.05f * salarioInicial;
		descontoINSS = salarioAumento * 0.11f;
		descontoFGTS = salarioAumento * 0.08f;
		
		if (salarioAumento > 4664.68) aliquotaIR = 0.275f;
		else if (salarioAumento >= 3751.06) aliquotaIR = 0.225f;
		else if (salarioAumento >= 2826.66) aliquotaIR = 0.15f;
		else if (salarioAumento >= 1903.99) aliquotaIR = 0.075f;
		
		descontoIR = salarioAumento * aliquotaIR;
		descontoTotal = descontoINSS + descontoFGTS + descontoIR;
		salarioFinal = salarioAumento - descontoTotal;
		
		System.out.printf("Salario Inicial: %.2f \n", salarioInicial);
		System.out.printf("Salario Reajustado: %.2f \n", salarioAumento);
		System.out.printf("Desconto 11%% INSS: %.2f \n", descontoINSS);
		System.out.printf("Desconto 8%% FGTS: %.2f \n", descontoFGTS);
		System.out.printf("Desconto IR: %.2f \n", descontoIR);
		System.out.printf("Total de desconto INSS+FGTS+IR: %.2f \n", descontoTotal);
		System.out.printf("Salario Final: %.2f", salarioFinal);
	}
}