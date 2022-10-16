/******************************************************************************
Questão 10: A lanchonete Gostosura vende apenas um tipo de sanduíche, cujo recheio inclui
duas fatias de queijo, uma fatia de presunto e uma rodela de hambúrguer. Sabendo que cada fatia
de queijo ou presunto pesa 50 gramas, e que a rodela de hambúrguer pesa 120 gramas, faça um
algoritmo em que o dono forneça a quantidade de sanduíches a fazer, e a máquina informe as
quantidades (em quilos) de queijo, presunto e carne necessários para compra.
Regra: Pode ocorrer uma situação em que não haja a quantidade total necessária de presunto.
Desta forma, após apresentar o resultado para o usuário, o algoritmo deve perguntar a quantidade
de presunto disponível. Caso a quantidade de presunto disponível seja maior ou igual a
quantidade necessária o algoritmo deve finalizar. Caso não exista a quantidade suficiente, o
algoritmo deve apresentar a quantidade inteira de sanduíches que podem ser produzidos com a
quantidade de presunto disponível e sugerir a quantidade em Kgs de mortadela que deve ser
utilizada para produzir o restante dos sanduíches. Considere que cada fatia de mortadela pesa 70
gramas. Deverá ser apresentado a quantidade de presunto que sobrará.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    int qtdSanduiches, qtdSanduichesPresunto;
        float qtdQueijo, qtdPresunto, qtdHamburguer, qtdPresuntoDisponivel,
        qtdMortadela, qtdPresuntoRestante;
	        
	    try (Scanner input = new Scanner(System.in)) {
	        System.out.print("Digite a quantidade de sanduiches: ");
	        qtdSanduiches = input.nextInt();
	    
	        qtdQueijo = 0.1f * qtdSanduiches;
	        qtdPresunto = 0.05f * qtdSanduiches;
	        qtdHamburguer = 0.12f * qtdSanduiches;

            System.out.printf("Para produzir %d sanduiches serao necessarios:\n", qtdSanduiches);
            System.out.printf("%.2f kgs de mussarela\n", qtdQueijo);
            System.out.printf("%.2f kgs de presunto\n", qtdPresunto);
            System.out.printf("%.2f kgs de hamburguer\n", qtdHamburguer);
            
            System.out.print("Digite a quantidade de presunto disponivel: ");
	        qtdPresuntoDisponivel = input.nextFloat();
	        
	        if (qtdPresuntoDisponivel < qtdPresunto) {
	            qtdSanduichesPresunto = (int) qtdPresuntoDisponivel / 0.12;
	            qtdMortadela = 0.07f * (qtdSanduiches - qtdSanduichesPresunto);
	            qtdPresuntoRestante = 
	            
	            System.out.printf("Sera possivel produzir apenas %d sanduiches"
	            +" com presunto. Sera necessario %.3f kgs de mortadela para produzir"
	            +" %d sanduiches restantes. Da quantidade de presunto disponivel"
	            +"sobrara %.3f kgs", qtdSanduichesPresunto, qtdMortadela,
	            (qtdSanduiches - qtdSanduichesPresunto), qtdPresuntoRestante);
	        }
	    }
	}
}