/******************************************************************************
09. Faça um algoritmo que leia os dados necessários para calcular e exibir a área:
Pesquisa na Internet como calculcar a área de cada objeto abaixo:
a) de um trapézio.
b) de um quadrado.
c) de um retangulo.
d) de um círculo.
e) de um triangulo.
*******************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int baseMaior, baseMenor, altura, ladoQuadrado, largura, raio, base;
	    float area;
	    
	    System.out.println("Area do trapezio:");
		System.out.print("Informe o valor da base maior: ");
		baseMaior = input.nextInt();
		System.out.print("Informe o valor da base menor: ");
		baseMenor = input.nextInt();
		System.out.print("Informe o valor da altura: ");
		altura = input.nextInt();
		
		area = (baseMaior + baseMenor) * altura / 2.0f;
		System.out.printf("A area do trapezio e: %.2f \n", area);
		
		System.out.println("Area do quadrado:");
		System.out.print("Informe o valor de um dos lados: ");
		ladoQuadrado = input.nextInt();
		
		area = (float) Math.pow(ladoQuadrado, 2);
		System.out.printf("A area do quadrado e: %.2f \n", area);
		
		System.out.println("Area do retangulo:");
		System.out.print("Informe o valor da largura: ");
		largura = input.nextInt();
		System.out.print("Informe o valor da altura: ");
		altura = input.nextInt();
		
		area = largura * altura;
		System.out.printf("A area do retangulo e: %.2f \n", area);
		
		System.out.println("Area do circulo:");
		System.out.print("Informe o valor do raio: ");
		raio = input.nextInt();
		
		area = (float) (Math.PI * Math.pow(raio, 2));
		System.out.printf("A area do circulo e: %.2f \n", area);
		
		System.out.println("Area do triangulo:");
		System.out.print("Informe o valor da base: ");
		base = input.nextInt();
		System.out.print("Informe o valor da altura: ");
		altura = input.nextInt();
		
		area = base * altura / 2.0f;
		System.out.printf("A area do circulo e: %.2f", area);
	}
}