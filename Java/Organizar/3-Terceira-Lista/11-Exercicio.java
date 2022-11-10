/******************************************************************************
Questão 11: A empresa Hipotheticus paga R$10,00 por hora normal trabalhada, R$15,00 por
hora extra e R$ 90 reais por cada dependente menor que 6 anos. Faça um algoritmo que solicite a
quantidade de horas normais e extras trabalhadas no mês além da quantidade de dependentes
menores que 6 anos. Considere que o salário líquido é igual ao salário de horas normais
descontando-se 11% de impostos. O salário final é o salário liquido mais o valor recebido por cada
dependente mais as horas extras. A empresa paga o adicional para no máximo 3 filhos menores
que 6 anos. Caso o usuário digite uma quantidade de filhos superior a 3 deverá ser apresentado
uma mensagem informando. “Salário calculado para apenas 3 dependentes, os demais X
dependentes não receberão o auxilio.” X é a quantidade de dependentes acima da quantidade
permitida.
*******************************************************************************/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int horaTrabalhada, horaExtra, quantidadeMenor;
		float salarioNormal, salarioLiquido, salarioExtra, salarioMenor, salarioFinal;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Digite a quantidade total de horas normais: ");
			horaTrabalhada = input.nextInt();
			System.out.print("Digite a quantidade total de horas extras: ");
			horaExtra = input.nextInt();
			System.out.print("Digite a quantidade total de dependentes: ");
			quantidadeMenor = input.nextInt();

			salarioNormal = 10f * horaTrabalhada;
			salarioLiquido = salarioNormal * 0.89f;
			salarioExtra = 15f * horaExtra;
			if (quantidadeMenor <= 3) salarioMenor = 90f * quantidadeMenor;
			else salarioMenor = 90f * 3;
			salarioFinal = salarioLiquido + salarioExtra + salarioMenor;

			System.out.printf("Horas normais: R$%.2f\n", salarioNormal);
			System.out.printf("Adicional de hora extra: R$%.2f\n", salarioExtra);
			System.out.printf("Adicional de dependentes: R$%.2f\n", salarioMenor);
			System.out.printf("Salario liquido (Hrs normais - Desconto): R$%.2f\n", salarioLiquido);
			System.out.printf("Salario final: R$%.2f\n", salarioFinal);

			if (quantidadeMenor > 3) System.out.printf("Salario calculado para apenas 3 dependentes."
					+" Os demais %d dependentes nao receberao o auxilio.", (quantidadeMenor - 3));
		}
	}
}