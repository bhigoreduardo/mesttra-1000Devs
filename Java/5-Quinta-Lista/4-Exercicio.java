/******************************************************************************
04) Construa uma função que receba um número inteiro e verifique se o mesmo é
primo e retorne o resultado true para um número primo e false para um número que
não seja primo.
*******************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main
{
    public static boolean isPrimo(int numero) {
        return numero % 2 == 0;
    }
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Informe um numero: ");
	    try{
	        int numero = input.nextInt();
	        System.out.println(isPrimo(numero) == true ? "Primo" : "Nao primo");
	    } catch (InputMismatchException ex) {
	        System.out.println("Nao foi digitado um inteiro valido.");
	    }
	}
}