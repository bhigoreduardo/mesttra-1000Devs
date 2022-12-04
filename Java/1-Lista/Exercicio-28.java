/******************************************************************************
Questão 01: Uma imobiliária vende apenas terrenos retangulares. Faça um algoritmo
para imprimir a área do terreno e o valor de venda do mesmo. Para isto será
necessário o usuário informar as dimensões em metros (frente e lateral) do terreno
além do valor cobrado pelo metro quadrado. Caso a diferença de metragem entre a
frente e a lateral seja menor que 10% da metragem da frente, o cliente terá um
acréscimo de 22% no valor final do terreno. Caso a metragem da frente for menor
que 40% da lateral, o cliente terá um desconto de 12% no valor final do terreno.
Caso a metragem da frente for maior que 70% da lateral, o cliente terá um
desconto de 15%. Caso as medidas não encaixem em nenhuma das regras o valor final
do terreno não sofrerá alterações.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Quantos metros o terreno possui de frente: ");
		float dimensaoFrontal = input.nextFloat();
		System.out.print("Quantos metros o terreno possui de lateral: ");
		float dimensaoLateral = input.nextFloat();
		System.out.print("Informe o valor do metro quadrado: ");
		float valorMetroQuadrado = input.nextFloat();
		float corretagem = 1.0f;
		
		float area = dimensaoFrontal * dimensaoLateral;
		
		float diferenca = Math.abs(dimensaoFrontal - dimensaoLateral);
		
		if (diferenca < (0.1f*dimensaoFrontal)) {
		    corretagem = 1.22f;
		} else if (dimensaoFrontal < (0.4f*dimensaoLateral)) {
		    corretagem = 0.88f;
		} else if (dimensaoFrontal > (0.7f*dimensaoLateral)) {
		    corretagem = 0.85f;
		}
		
		float valorVenda = corretagem * valorMetroQuadrado * area;
		
		System.out.println(String.format("Area total do terreno de %.2f mts de"
		+" frente com %.2f mts de lateral e: %.2f mts2", dimensaoFrontal,
		dimensaoLateral, area));
		
		if (corretagem < 1) {
		    System.out.println(String.format("O terreno recebeu um decrescimo de"
		    +" %.0f%% e custara: R$ %.2f", ((1-corretagem)*100), valorVenda));
		} else if (corretagem > 1) {
		    System.out.println(String.format("O terreno recebeu um acrescimo de"
		    +" %.0f%% e custara: R$ %.2f", ((corretagem-1)*100), valorVenda));
		} else {
		    System.out.println(String.format("O terreno não recebeu nenhuma alteracao"
		    +" e custara: R$ %.2f", valorVenda));
		}
	}
}