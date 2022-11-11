/******************************************************************************
11. Um tonel de refresco é feito com 8 partes de água mineral e 2 partes de suco de
maracujá. Faça um algoritmo para calcular quantos litros de água e de suco são
necessários para se fazer uma certa quantidade de litros de refresco informados pelo
usuário.
*******************************************************************************/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int ltsSuco;
	    float ltsAgua, ltsMaracuja;

		System.out.print("Digite a QTDE de lts de suco de maracuja QUEM NÃO TOMOU" +
		" AGORA VAI TOMAR :D -> ");
		ltsSuco = input.nextInt();

        ltsAgua = ltsSuco * 8.0f / 10;
        ltsMaracuja = ltsSuco * 2.0f / 10;
        
        System.out.printf("Sera necessario para fazer %d lts de suco de maracuja:\n",
        ltsSuco);
        System.out.printf("%.2f lts de agua\n", ltsAgua);
        System.out.printf("%.2f lts de suco concentrado de maracuja\n", ltsMaracuja);
	}
}