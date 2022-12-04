/******************************************************************************
02) Crie um algoritmo que o usuário entre com vários números inteiros e positivos
e imprima o multiplicação dos números ímpares e a soma dos números pares. O
algoritmo finaliza quando o usuario digita o número 0.
*******************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int numero, pares = 0, impares = 1;
	    try {
    	    while(true) {
    	        System.out.printf("Informe um numero [Sair - 0]: ");
    	        numero = input.nextInt();
    	        if (numero == 0) break;
    	        
    	        if (numero % 2 == 0) {
    	            pares+=numero;
    	            System.out.println(pares);
    	        } else {
    	            impares*=numero;
    	            System.out.println(impares);
    	        }
    	    }
	    } catch (InputMismatchException ex) {
	        System.out.println("Nao foi digitado um numero.");
	    }
	}
}