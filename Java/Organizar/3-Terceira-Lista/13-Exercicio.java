/******************************************************************************
Questão 13: Uma padaria vende uma certa quantidade de pães franceses e uma
quantidade de broas a cada dia. Cada pãozinho custa R$ 0,12 e a broa custa
R$ 1,50. Ao final do dia, o dono quer saber quanto arrecadou com a venda dos
pães e broas (juntos), e quanto deve guardar numa conta de poupança
(10% do total arrecadado) para realizar uma reforma. Você foi contratado para
fazer os cálculos para o dono. Com base nestes fatos, faça um algoritmo para ler
as quantidades de pães e de broas, o valor da reforma e depois calcule o valor
arrecado, o valor a ser depositado na poupança e quantos dias serão necessários,
caso mantenha o mesmo faturamento, para custear a reforma.
Requisito adicional: A quantidade de dias deve ser retornado como um valor
inteiro. Exemplo: 3.78 dias deverá retornar 4 dias 9.2 dias deverá retornar 10 dias
10.89 dias deverá retornar 11 dias.
Caso o valor de dias necessários para pagar a reforma for superior a 120 dias,
o algoritmo deverá apresentar qual deveria ser o valor depositado na poupança
diariamente para obter o valor da reforma dentro de 120 dias.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int qtdPaes, qtdBroas, qtdDias;
		float valorReforma, valorPaes, valorBroas, valorArrecadado, valorDepositar;
		
		System.out.print("Digite a quantidade de paes vendidos: ");
		qtdPaes = input.nextInt();
		System.out.print("Digite a quantidade de broas vendidas: ");
		qtdBroas = input.nextInt();
		System.out.print("Digite o valor da reforma: ");
		valorReforma = input.nextFloat();
		
		valorPaes = 0.12f * qtdPaes;
		valorBroas = 1.5f * qtdBroas;
		valorArrecadado = valorPaes + valorBroas;
		valorDepositar = 0.1f * valorArrecadado;
		qtdDias = (int) Math.ceil(valorReforma / valorDepositar);
		
		System.out.printf("Faturamento com a venda de paes: R$ %.2f\n", valorPaes);
		System.out.printf("Faturamento com a venda de broas: R$ %.2f\n", valorBroas);
		System.out.printf("Faturamento diario (paes + broas): R$ %.2f\n", valorArrecadado);
		System.out.printf("Valor do deposito na poupanca: R$ %.2f\n", valorDepositar);
	    System.out.printf("Para pagar a reforma serao necessarios: %d dias\n", qtdDias);
		
		if (qtdDias > 120) {
		    qtdDias = 120;
		    valorDepositar = valorReforma / (float)qtdDias;
		
    	    System.out.printf("Para realizar a reforma em %d dias sera necessario"
            +" depositar diariamente R$: %.2f\n",qtdDias, valorDepositar);
		}
	
	}
}