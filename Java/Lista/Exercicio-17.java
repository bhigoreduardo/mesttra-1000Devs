/******************************************************************************
14. A lanchonete Gostosura vende apenas um tipo de sanduíche, cujo recheio inclui duas
fatias de queijo, uma fatia de presunto e uma rodela de hambúrguer. Sabendo que cada
fatia de queijo ou presunto pesa 50 gramas, e que a rodela de hambúrguer pesa 120
gramas, faça um algoritmo em que o dono forneça a quantidade de sanduíches a fazer, e
a máquina informe as quantidades (em quilos) de queijo, presunto e carne necessários
para compra.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int qtdSanduiches;
	    float qtdQueijo, qtdPresunto, qtdHamburguer;
	    
	    System.out.print("Digite a quantidade de sanduiches: ");
	    qtdSanduiches = input.nextInt();
	    
	    qtdQueijo = 0.1f * qtdSanduiches;
	    qtdPresunto = 0.05f * qtdSanduiches;
	    qtdHamburguer = 0.12f * qtdSanduiches;

        System.out.printf("Para produzir %d sanduiches serao necessarios:\n", qtdSanduiches);
        System.out.printf("%.2f kgs de mussarela\n", qtdQueijo);
        System.out.printf("%.2f kgs de presunto\n", qtdPresunto);
        System.out.printf("%.2f kgs de hamburguer\n", qtdHamburguer);
	}
}