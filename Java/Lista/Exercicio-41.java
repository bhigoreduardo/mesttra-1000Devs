/******************************************************************************
Escreva um algoritmo para funcionar em um caixa eletrônico. O usuário digita o
valor em dinheiro a ser sacado e o algoritmo deve exibir a quantidade de notas
de 100 reais, 50 reais, 20 reais, 10 reais, 5 reais. O algoritmo deve dar
preferencia para calcular a quantidade sempre com as notas maiores possíveis.
Possíveis Excecções: Valores nulos e negativos
*******************************************************************************/
import java.util.Scanner;

public class Main
{
    public static void withdrawMoney(int valor) throws IllegalArgumentException {
        if (valor <= 0) {
	        throw new IllegalArgumentException("Valor deve ser maior que zero");
	    }
	    
	    int notas100 = valor / 100;
        int notas50 = (valor % 100) / 50;
        int notas20 = ((valor % 100) % 50) / 20;
        int notas10 = (((valor % 100) % 50) % 20) / 10;
        int notas5 = ((((valor % 100) % 50) % 20) % 10) / 5;
            
        System.out.println(notas100 + " nota(s) de R$ 100,00");
        System.out.println(notas50 + " nota(s) de R$ 50,00");
        System.out.println(notas20 + " nota(s) de R$ 20,00");
        System.out.println(notas10 + " nota(s) de R$ 10,00");
        System.out.println(notas5 + " nota(s) de R$ 5,00");
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
		    System.out.print("Digite a quantidade de dinheiro a ser sacada: ");
		    int valor = input.nextInt();
		    withdrawMoney(valor);
		} catch (IllegalArgumentException ex) {
		    System.out.println(ex.getMessage());
		}
		
	}
}