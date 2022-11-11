/******************************************************************************
Questão 06: Faça um algoritmo para calcular quantas ferraduras são necessárias
para equipar todos os cavalos comprados para um haras. O usuário devera informar
a quantidade de cavalos adquiridos e o valor de cada ferradura. Aplique um
desconto no valor total conforme a tabela de descontos:
- Maior 15.000 = 10%
- Maior 20.000 = 12%
- Maior 25.000 = 15%
- Maior 30.000 = 20%
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe a quantidade de cavalos: ");
		int quantidadeCavalos = input.nextInt();
		System.out.print("Informe o valor de cada ferradura: ");
		float valorFerradura = input.nextFloat();
		
		int quantidadeFerraduras = 4 * quantidadeCavalos;
		float corretagem = 1.0f;
		
		float valorVenda = quantidadeFerraduras * valorFerradura;
		
		if (valorVenda > 30000) corretagem = 0.8f;
		else if (valorVenda > 25000) corretagem = 0.85f;
		else if (valorVenda > 20000) corretagem = 0.88f;
		else if (valorVenda > 15000) corretagem = 0.9f;
		
		valorVenda *= corretagem;
		
		System.out.println(String.format("A quantidade de ferraduras necessarias:"
		+" %d", quantidadeFerraduras));
		System.out.println(String.format("Valor total para a compra das ferraduras:"
		+" R$ %.2f", valorVenda));
		
	}
}