/******************************************************************************
15. A empresa Hipotheticus paga R$10,00 por hora normal trabalhada, R$15,00 por hora
extra e R$ 90 reais por cada dependente menor que 6 anos. Faça um algoritmo que
solicite a quantidade de horas normais e extras trabalhadas no mês além da quantidade
de dependentes menores que 6 anos. Considere que o salário líquido é igual ao salário de
horas normais descontando-se 11% de impostos. O salário final é o salário liquido mais o
valor recebido por cada dependente mais as horas extras.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int horasNormal, horasExtra, qtdDependente;
	    float salarioNormal, salarioExtra, salarioDependente, salarioLiquido,
	    salarioFinal;
	    
	    System.out.print("Digite a quantidade de horas normais: ");
	    horasNormal = input.nextInt();
	    System.out.print("Digite a quantidade de horas extras: ");
	    horasExtra = input.nextInt();
	    System.out.print("Digite a quantidade de dependentes menores de 6 anos: ");
	    qtdDependente = input.nextInt();
	    
	    salarioNormal = 10.0f * horasNormal;
	    salarioExtra = 15.0f * horasExtra;
	    salarioDependente = 90.0f * qtdDependente;
	    salarioLiquido = 0.89f * salarioNormal;
	    salarioFinal = salarioLiquido + salarioExtra + salarioDependente;
	    
        System.out.printf("Horas normais: R$ %.2f\n", salarioNormal);
        System.out.printf("Adicional de horas extras: R$ %.2f\n", salarioExtra);
        System.out.printf("Adicional de dependentes: R$ %.2f\n", salarioDependente);
        System.out.printf("Salario liquido (Hrs normais - Desconto): R$ %.2f\n", salarioLiquido);
        System.out.printf("Salario final: R$ %.2f\n", salarioFinal);
	}
}