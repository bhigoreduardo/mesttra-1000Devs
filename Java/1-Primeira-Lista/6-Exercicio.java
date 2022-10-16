/******************************************************************************
6. Faça um algoritmo para calcular quantas ferraduras são necessárias para equipar
todos os cavalos comprados para um haras. O usuário devera informar a quantidade de
cavalos adquiridos.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe a quantidade de cavalos: ");
		int quantidadeCavalos = input.nextInt();
		System.out.print("Informe o valor de cada ferradura R$: ");
		double valorFerradura = input.nextDouble();
		
		System.out.println("A quantidade de ferraduras necessarias: " +
		(4 * quantidadeCavalos));
		System.out.println(String.format("O valor total para a compra das ferraduras R$: %.2f",
		(4 * quantidadeCavalos * valorFerradura)));
	}
}