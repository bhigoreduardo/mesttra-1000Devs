/******************************************************************************
Escreva um algoritmo para criar uma votação para síndico de um prédio. Deve ser
lido 5 votos. Os candidatos são "Candidato A", "Candidato B", "Candidato C". O
algoritmo deve exibir um menu com as opções conforme abaixo: "1 - Candidato A",
"2 - Candidato B", "3 - Candidato C", "4 - Voto Nulo". O algoritmo deve apresentar
a quantidade percentual de votos válidos, o percentual de cada candidato (apenas
votos válidos, desconsiderando os votos nulos). Ao final o algoritmo deve imprimir
o candidato vencedor.
*******************************************************************************/
import java.util.Scanner;

public class Main
{
    public static void menu() {
        System.out.println("=========== Menu de Votação ===========\n");
        System.out.println("1 - Candidato A");
        System.out.println("2 - Candidato B");
        System.out.println("3 - Candidato C");
        System.out.println("4 - Voto Nulo\n");
    }
    
    public static float[] contador() throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        
        String[] votoPosicao = {"primeiro", "segundo", "terceiro", "quarto", "quinto"};
		int quantidadePrimeiro = 0;
		int quantidadeSegundo = 0;
		int quantidadeTerceiro = 0;
		
        for (int i = 0; i < 5; i++) {
		    System.out.print(String.format("Digite o código do candidato para"+
		    " o %s voto: ", votoPosicao[i]));
		    int voto = input.nextInt();
		    if(voto == 4) continue;
		    else if (voto == 1) quantidadePrimeiro++;
		    else if (voto == 2) quantidadeSegundo++;
		    else if (voto == 3) quantidadeTerceiro++; // TO DO: laço para forçar voto entre 1-4
		    else throw new IllegalArgumentException("Voto inválido");
		}
		
		int quantidadeVotosValidos = quantidadePrimeiro + quantidadeSegundo + quantidadeTerceiro;
		
		float percentualVotosValidos = (quantidadeVotosValidos)/5.0f*100;
		float percentualPrimeiro = quantidadePrimeiro/(float)quantidadeVotosValidos*100;
		float percentualSegundo = quantidadeSegundo/(float)quantidadeVotosValidos*100;
		float percentualTerceiro = quantidadeTerceiro/(float)quantidadeVotosValidos*100;
		float[] estatisticas = {percentualVotosValidos, percentualPrimeiro, percentualSegundo, percentualTerceiro};
		
		return estatisticas;
    }
	public static void main(String[] args) {
		
		float[] estatisticas;
		
		menu();
		try {
		estatisticas = contador();
		
		System.out.println(String.format("Percentual de Votos Válidos: %.2f%%", estatisticas[0]));
		System.out.println(String.format("Percentual de Votos Candidato 1: %.2f%%", estatisticas[1]));
		System.out.println(String.format("Percentual de Votos Candidato 2: %.2f%%", estatisticas[2]));
		System.out.println(String.format("Percentual de Votos Candidato 3: %.2f%%", estatisticas[3]));
		} catch (IllegalArgumentException ex) {
		    System.out.println(ex.getMessage());
		}
		
	}
}