/******************************************************************************
Questão 03: Faça um algoritmo para ler três notas de um aluno em uma disciplina
e imprimir a sua média ponderada (as notas tem pesos respectivos de 1, 2 e 3).
Calcule o valor das notas com base em seus pesos e além de apresentar a média,
exiba a maior nota entre as 3 notas, ou a mensagem “As 3 notas são iguais”, ou
“As notas 1 e 2 são as maiores”, “As notas 1 e 3 são as maiores”, “As notas 2 e
3 são as maiores” caso exista duas notas iguais e elas sejam as maiores.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
    public static float lerNota(String msg) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.printf("Digite a %s nota: ", msg);
        return input.nextFloat();
    }
    
    public static float calcularMedia(float[][] dadosNotas) {
        float numerador = 0.0f, denominador = 0.0f;
        
        for (int j = 0; j < dadosNotas.length; j++) {
            denominador += dadosNotas[1][j];
            numerador += dadosNotas[2][j];
        }
        
        return numerador / denominador;
    }
    
    public static boolean notaMaior(float notaPeso1, float notaPeso2, float notaPeso3) {
        if ((notaPeso1 > notaPeso2) && (notaPeso1 > notaPeso3)) return true;
        return false;
    }
    
    public static boolean notasIguais(float notaPeso1, float notaPeso2) {
        if (notaPeso1 == notaPeso2) return true;
        return false;
    }
    
    public static void analisarNotas(float[][] dadosNotas) {
        if (notaMaior(dadosNotas[2][0], dadosNotas[2][1], dadosNotas[2][2])) {
    		    // nota1 Maior
    		    System.out.printf("A nota1 (%.2f) e a maior nota apos o calculo "
    		    +"do peso %.0f (%.2f)", dadosNotas[0][0], dadosNotas[1][0],
    		    dadosNotas[2][0]);
    		} else if (notaMaior(dadosNotas[2][1], dadosNotas[2][0], dadosNotas[2][2])) {
    		    // nota2 Maior
    		    System.out.printf("A nota2 (%.2f) e a maior nota apos o calculo "
    		    +"do peso %.0f (%.2f)", dadosNotas[0][1], dadosNotas[1][1],
    		    dadosNotas[2][1]);
    		} else if (notaMaior(dadosNotas[2][2], dadosNotas[2][0], dadosNotas[2][1])) {
    		    //nota3 Maior
    		    System.out.printf("A nota3 (%.2f) e a maior nota apos o calculo "
    		    +"do peso %.0f (%.2f)", dadosNotas[0][2], dadosNotas[1][2],
    		    dadosNotas[2][2]);
    		} else {
    		    if (notasIguais(dadosNotas[2][0], dadosNotas[2][1]) &&
    		    notaMaior(dadosNotas[2][0], dadosNotas[2][2], 0.0f)){
    		        // nota1 == nota2 > nota3
    		        System.out.printf("As nota1 (%.2f) e nota2 (%.2f) foram as "
    		        +"maiores notas apos o calculo dos pesos %.0f (%.2f) e %.0f "
    		        +"(%.2f)", dadosNotas[0][0], dadosNotas[0][1], dadosNotas[1][0],
    		        dadosNotas[2][0], dadosNotas[1][1], dadosNotas[2][1]);
    		    } else if (notasIguais(dadosNotas[2][0], dadosNotas[2][2]) &&
    		    notaMaior(dadosNotas[2][0], dadosNotas[2][1], 0.0f)) {
    		        // nota1 == nota3 > nota2
    		        System.out.printf("As nota1 (%.2f) e nota3 (%.2f) foram as "
    		        +"maiores notas apos o calculo dos pesos %.0f (%.2f) e %.0f "
    		        +"(%.2f)", dadosNotas[0][0], dadosNotas[0][2], dadosNotas[1][0],
    		        dadosNotas[2][0], dadosNotas[1][2], dadosNotas[2][2]);
    		    } else if ((notasIguais(dadosNotas[2][1], dadosNotas[2][2]) &&
    		    notaMaior(dadosNotas[2][1], dadosNotas[2][0], 0.0f))) {
    		        // nota2 == nota3 > nota1
    		        System.out.printf("As nota2 (%.2f) e nota3 (%.2f) foram as "
    		        +"maiores notas apos o calculo dos pesos %.0f (%.2f) e %.0f "
    		        +"(%.2f)", dadosNotas[0][1], dadosNotas[0][2], dadosNotas[1][1],
    		        dadosNotas[2][1], dadosNotas[1][2], dadosNotas[2][2]);
    		        } else {
    		            System.out.println("As três notas foram iguais");
    		        }
    		}
    }
    
	public static void main(String[] args) {
		float[][] dadosNotas = new float[3][3];
		String[] posicaoNotas = {"primira", "segunda", "terceira"};
		
		try {
    		// Leitura notas
    		for (int i = 0; i < 1; i++) {
    		    for (int j = 0; j < 3; j++) {
    	            dadosNotas[i][j] = lerNota(posicaoNotas[j]);
    		    }
    		}
    		
    		// Pesos notas
    		dadosNotas[1][0] = 1.0f;
    		dadosNotas[1][1] = 2.0f;
    		dadosNotas[1][2] = 3.0f;
    		
    		// Notas com peso
    		dadosNotas[2][0] = dadosNotas[0][0] * dadosNotas[1][0];
            dadosNotas[2][1] = dadosNotas[0][1] * dadosNotas[1][1];
            dadosNotas[2][2] = dadosNotas[0][2] * dadosNotas[1][2];
            
            // Média ponderada
            System.out.printf("A media ponderada das notas %.2f, %.2f e %.2f e: "
            +" %.2f\n", dadosNotas[0][0], dadosNotas[0][1], dadosNotas[0][2],
            calcularMedia(dadosNotas));
            
            // Análise das notas
            analisarNotas(dadosNotas);
		} catch (Exception ex) {
		    System.out.println(ex.getMessage());
		}
		
	}
}