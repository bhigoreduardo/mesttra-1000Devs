/******************************************************************************
Questão 07: Faça um algoritmo que receba o peso de uma pessoa, calcule e mostre:
a) o novo peso se a pessoa engordar 15% sobre o peso digitado;
b) o novo peso se a pessoa emagrecer 20% sobre o peso digitado.
c) Uma mensagem “Você deve procurar uma nutricionista” se a diferença de acréscimo de peso
(15%) entre o acréscimo de peso (20%) for maior ou igual a 4,5 kgs.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o peso em KG: ");
		float peso = input.nextFloat();
		
		float aumento15 = (peso*1.15f);
		float aumento20 = (peso*1.2f);
		
		System.out.println(String.format("Caso a pessoa engorde 15%% ficara com:"
		+" %.2f KG", aumento15));
		System.out.println(String.format("Caso a pessoa engorde 20%% ficara com:"
		+" %.2f KG", aumento20));
		if ((aumento20-aumento15) >= 4.5f) System.out.println("Voce deve procurar"
		+" uma nutricionista");
	}
}