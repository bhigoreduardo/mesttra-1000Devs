/******************************************************************************
03) Foi feita uma pesquisa entre os habitantes de uma região e coletados os
dados de altura e sexo (m, f) das pessoas. Faça um programa que leia estes dados
e que continue a leitura caso o usuário responda (s) e pare a execução ele
digitar (n). Ao final exiba os seguintes dados:
a) Média das altura das mulheres
b) Maior altura
c) Percentual de homens que participaram
*******************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main
{
    public static char newInput(String message, int inputType) {
        Scanner input = new Scanner(System.in);
        char opcao = '0', condition = 'N';
        while(condition != 'S') {
	        System.out.print(message);
	        opcao = input.next().toUpperCase().charAt(0);
	        switch (inputType) {
	            case 1:
	                if (opcao == 'M' || opcao == 'F') {
	                    condition = 'S';
	                    break;
	                }
	                System.out.println("Informe uma opcao valida."); break;
	            case 2:
	                if (opcao == 'S' || opcao == 'N') {
	                    condition = 'S';
	                    break;
	                }
	                System.out.println("Informe uma opcao valida."); break;
	        }
	   }
	   return opcao;
    }
    public static float newHeight(String message) throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        float altura;
        System.out.print(message);
        altura = input.nextFloat();
        return altura;
    }
	public static void main(String[] args) {
	    char opcao, sexo;
	    float alturaMulheres = 0.0f, altura, maiorAltura = 0.0f;
	    int quantidadeMulheres = 0, totalParticipantes = 0, quantidadeHomens = 0;
	    
	    try {
    		while(true) {
    		    sexo = newInput("Informe o sexo [M/F]: ", 1);
    		    altura = newHeight("Informe a altura: ");
    		    
    		    if (sexo == 'F') {
    		        alturaMulheres += altura;
    		        quantidadeMulheres++;
    		    } else {
    		        quantidadeHomens++;
    		    }
    		    
    		    if(totalParticipantes == 0 || altura > maiorAltura) {
    		        maiorAltura = altura;
    		    }
    		    
    		    totalParticipantes++;
    		    
    		    opcao = newInput("Deseja realizar nova leitura [S/N]: ", 2);
    		    if (opcao == 'N') break;
    		}
		
    		float mediaMulheres = quantidadeMulheres != 0 ? (alturaMulheres/(float)quantidadeMulheres) : 0.0f;
    		
    		System.out.printf("Media de alturas mulheres: %.2f\n", mediaMulheres);
    		System.out.printf("Maior altura: %.2f\n", maiorAltura);
    		System.out.printf("Percentual de homens: %.2f%%",
    		((float)quantidadeHomens/(float)totalParticipantes)*100);
	    } catch (InputMismatchException ex) {
	        System.out.println("Valor informado nao e numerico.");
	    }
	}
}