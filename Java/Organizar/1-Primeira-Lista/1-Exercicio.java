/******************************************************************************
1. Uma imobiliária vende apenas terrenos retangulares. Faça um algoritmo para imprimir a
área do terreno e o valor de venda do mesmo. Para isto será necessário o usuário
informar as dimensões em metros (frente e lateral) do terreno além do valor cobrado pelo
metro quadrado.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Quantos metros o terreno possui de frente: ");
		double dimensaoFrente = input.nextDouble();
		System.out.print("Quantos metros o terreno possui de lateral: ");
		double dimensaoLateral = input.nextDouble();
		System.out.print("Informe o valor do metro quadrado: ");
		double valorMetroQuadrado = input.nextDouble();
		
		double area = dimensaoFrente * dimensaoLateral;
		double valorVenda = area * valorMetroQuadrado;
		
		System.out.println(String.format("A area total do terreno de %.2f mts de frente" + 
		" com %.2f mts de lateral e: %.2f mts", dimensaoFrente, dimensaoLateral, area));
		System.out.println(String.format("O valor do terreno e: %.2f", valorVenda));
	}
}