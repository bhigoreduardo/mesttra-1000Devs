/******************************************************************************
20. Ler um número inteiro com até quatro dígitos e imprimir a saída da seguinte forma:
MILHARES = x
CENTENA = x
DEZENA = x
UNIDADE = x
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    
	    int numero, milhar, centena, dezena, unidade;
	    
	    System.out.print("Digite um numero de 4 digitos: ");
	    numero = input.nextInt();
	    
	    milhar = numero / 1000;
	    centena = (numero % 1000) / 100;
	    dezena = ((numero % 1000) % 100) / 10;
	    unidade = ((numero % 1000) % 100) % 10;
	    
	    System.out.printf("Milhares: %d\n", milhar);
	    System.out.printf("Centenas: %d\n", centena);
	    System.out.printf("Dezenas: %d\n", dezena);
	    System.out.printf("Unidades: %d\n", unidade);
	}
}