/******************************************************************************
16. Uma loja de decoração precisa aumentar o seu faturamento para o próximo mês em
20%. Esta loja deseja atingir este objetivo aumentando a venda de três produtos. O
produto 1 custa R$ 150 o produto 2 R$ 220,00 e o produto 3 R$ 97.00. Faça um algoritmo
que receba o valor de faturamento do último mês e apresente:
a) O faturamento do próximo mês para bater a meta de 20%.
b) A quantidade de peças apenas do produto 1 necessárias para obter a meta desejada.
c) A quantidade de peças apenas do produto 2 necessárias para obter a meta desejada.
d) A quantidade de peças apenas do produto 3 necessárias para obter a meta desejada.
*******************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    float faturamentoPassado, faturamentoAumento, faturamentoMeta;
	    
	    System.out.print("Digite o valor do faturamento anterior: ");
	    faturamentoPassado = input.nextFloat();
	    
	    faturamentoAumento = 0.2f * faturamentoPassado;
	    faturamentoMeta = faturamentoAumento + faturamentoPassado;
	    
	    System.out.printf("A meta do proximo mes e: R$ %.2f\n", faturamentoMeta);
	    System.out.printf("Um aumento de: R$ %.2f\n", faturamentoAumento);
	    System.out.println("Quantidade de pecas a serem vendidas para atingir a meta:");
	    System.out.printf("Produto 1: %.2f pecas\n", Math.ceil(faturamentoAumento / 150.0));
	    System.out.printf("Produto 2: %.2f pecas\n", Math.ceil(faturamentoAumento / 220.0));
	    System.out.printf("Produto 3: %.2f pecas\n", Math.ceil(faturamentoAumento / 97.0));
	}
}