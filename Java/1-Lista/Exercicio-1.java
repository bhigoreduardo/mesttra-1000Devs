/******************************************************************************
1. Faça um algoritmo para determinar a distância percorrida por um automóvel para
cada 5h, 8h e 12h de viagem e bem como a quantidade de lts de combustível durante
o percurso. As informações de entrada informadas pelo usuário serão a velocidade
e o consumo médio do veículo (km/l).
*******************************************************************************/

import java.util.Scanner;

public class Main
{
    public static void calcularViagem(int velocidade, float consumo, int tempo) {
        int distancia;
        float ltsGasto;
        
        distancia = tempo * velocidade;
		ltsGasto = distancia / consumo;
		System.out.printf("Em %d horas o veículo percorrera : %d km\n", tempo, distancia);
		System.out.printf("Em %d horas o veículo consumira : %.2f lts\n", tempo, ltsGasto);
    }
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int velocidade;
		float consumo;
		
		System.out.print("Informe a velocidade do veiculo: ");
		velocidade = input.nextInt();
		System.out.print("Informe o consumo [km/lts] do veiculo: ");
		consumo = input.nextFloat();
		
		calcularViagem(velocidade, consumo, 5);
		calcularViagem(velocidade, consumo, 8);
		calcularViagem(velocidade, consumo, 12);
	}
}