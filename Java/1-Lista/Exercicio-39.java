/******************************************************************************
Questão 12: Uma loja de decoração precisa aumentar o seu faturamento para o
próximo mês em 20%. Esta loja deseja atingir este objetivo aumentando a venda de
três produtos. O produto 1 custa R$ 150 o produto 2 R$ 220,00 e o produto 3
R$ 97.00. Faça um algoritmo que receba o valor de faturamento do último mês, o
codigo do produto para análise e apresente:
a) O faturamento do próximo mês para bater a meta de 20%.
b) A quantidade de peças apenas do produto escolhido necessárias para obter a
meta desejada.
Regra: Caso o usuario digite um código de produto incorreto, apresente uma mensagem
“Codigo de produto nao encontrado!” e finalize o algoritmo sem realizar nenhum calculo.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
    public static void menu() {
        System.out.println("=== Codigo dos Produtos ===");
        System.out.println("Produto 1: 101");
        System.out.println("Produto 2: 122");
        System.out.println("Produto 3: 163");
    }
    
    public static void informacaoesFaturamento(float faturamentoMeta,
            float faturamentoAumento) {
        System.out.printf("A meta do proximo mes e: R$ %.2f\n", faturamentoMeta);
	    System.out.printf("Um aumento de: R$ %.2f\n", faturamentoAumento);
	    System.out.println("Quantidade de pecas a serem vendidas para atingir a meta:");
    }
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    
	    float faturamentoPassado, faturamentoAumento, faturamentoMeta;
	    int codigoProduto;
	    
	    System.out.print("Digite o valor do faturamento anterior: ");
	    faturamentoPassado = input.nextFloat();
	    
	    menu();
	    System.out.print("Digite o codigo do produto que se deseja bater a meta: ");
	    codigoProduto = input.nextInt();
	    
	    faturamentoAumento = 0.2f * faturamentoPassado;
	    faturamentoMeta = faturamentoAumento + faturamentoPassado;
	    
	    switch(codigoProduto) {
	        case 101:
	            informacaoesFaturamento(faturamentoMeta, faturamentoAumento);
	            System.out.printf("Produto 1: %.2f pecas\n", Math.ceil(faturamentoAumento / 150.0));
	            break;
            case 122:
                informacaoesFaturamento(faturamentoMeta, faturamentoAumento);
                System.out.printf("Produto 2: %.2f pecas\n", Math.ceil(faturamentoAumento / 220.0));
                break;
            case 163:
                informacaoesFaturamento(faturamentoMeta, faturamentoAumento);
                System.out.printf("Produto 3: %.2f pecas\n", Math.ceil(faturamentoAumento / 97.0));
                break;
            default:
                System.out.println("Codigo de produto nao encontrado!");
                break;
	    }
	}
}