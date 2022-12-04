/******************************************************************************
7. Faça um algoritmo que receba o peso de uma pessoa, calcule e mostre:
a) o novo peso se a pessoa engordar 15% sobre o peso digitado;
b) o novo peso se a pessoa emagrecer 20% sobre o peso digitado.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe o peso em KG: ");
		double peso = input.nextDouble();
		
		System.out.println("Caso a pessoa engorde 15% ficara com:" +
		String.format(" %.2f KG", (peso * 1.15)));
		System.out.println("Caso a pessoa emagreca 20% ficara com:" +
		String.format(" %.2f KG", (peso * 0.80)));
	}
}