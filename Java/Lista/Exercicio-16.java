/******************************************************************************
13. A fábrica de refrigerantes Meia-Cola vende seu produto em três formatos: lata de 350
ml, garrafa de 600 ml e garrafa de 2 litros. Se um comerciante compra uma determinada
quantidade de cada formato, faça um algoritmo para calcular quantos litros de refrigerante
ele comprou.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int qtdLatas, qtdGarrafas, qtdPet;
	    float qtdLitros;
	    
	    System.out.print("Digite a quantidade de latas de 350ml: ");
	    qtdLatas = input.nextInt();
	    System.out.print("Digite a quantidade de garrafas de 600ml: ");
	    qtdGarrafas = input.nextInt();
	    System.out.print("Digite a quantidade de garrafas de 2lts: ");
	    qtdPet = input.nextInt();
	    
	    qtdLitros = (0.35f * qtdLatas) + (0.6f *qtdGarrafas)  + (2.0f * qtdPet);

        System.out.printf("A quantidade total de litros e: %.2f", qtdLitros);
	}
}