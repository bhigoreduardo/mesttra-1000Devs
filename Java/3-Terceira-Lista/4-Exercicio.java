/******************************************************************************
Questão 04: Faça um algoritmo que calcule e mostre a tabuada de uma operação
matemática que deverá ser informada pelo usuário (+, -, * e /) além do número
digitado pelo usuário para o calculo da operação.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe a operacao desejada [+,-,*,/]: ");
		String operacao = input.nextLine();
		System.out.print("Informe o numero para o calculo da tabuada: ");
		int numero = input.nextInt();
		
		if (operacao.equals("+") || operacao.equals("-") || operacao.equals("*")
		|| operacao.equals("/")) System.out.println(String.format("Tabuada do %s"
		+" para o numero %d", operacao, numero));
		
		switch (operacao) {
		    case "+":
		        for (int i = 0; i < 10; i++) {
		            System.out.println(String.format("%d + %d = %d", numero, i,
		            (numero+i)));
		        }
		        break;
	        case "-":
	            for (int i = 0; i < 10; i++) {
		            System.out.println(String.format("%d - %d = %d", numero, i,
		            (Math.abs(numero-i))));
		        }
		        break;
            case "*":
                for (int i = 0; i < 10; i++) {
		            System.out.println(String.format("%d * %d = %d", numero, i,
		            (numero*i)));
		        }
		        break;
            case "/":
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        System.out.println(String.format("%d / %d = Nao divide"+
                        " por 0", numero, i));
                        continue;
                    }
		            System.out.println(String.format("%d / %d = %.2f", numero, i,
		            (numero/(double)i)));
		        }
		        break;
            default: System.out.println(String.format("Operacao digitada (%s)"+
            " incorreta!", operacao)); break;
		}
	}
}