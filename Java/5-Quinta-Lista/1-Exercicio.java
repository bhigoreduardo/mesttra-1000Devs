/******************************************************************************
01) Construa um algoritmo que imprima a tabela de equivalência de graus
Fahrenheit para centígrados. Os limites são de 32 a 200 graus Fahrenheit com
intervalo de 1 °F.
Fórmula de Fahrenheit para Celcius é: (5 / 9 * (Fahrenheit -32))
*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    System.out.println("Fahrenheit\tCelcius");
	    for(int i = 32; i <= 200; i++) {
	        System.out.printf("%d\t\t%.2f\n", i, (5 / (float)9 * ((i)-32)));
	    }
	}
}