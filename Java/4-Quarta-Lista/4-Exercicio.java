/******************************************************************************
Desenvolva um algoritmo que leia 5 compras de clientes. Para cada compra de
cliente deve ser informado o valor da compra e o código da forma de pagamento.
Com base neste código, o algoritmo deverá calcular e imprimir o valor a pagar
final, a forma de pagamento e o valor de cada parcela, se for o caso.
ista de códigos e suas respectivas classificações:
Código Classificação
1 À vista, com 8% de desconto
2 À vista no cartão, 4% de desconto
3 Em 2x, preço normal sem juros
4 Em 4x, preço acrescido de 8%
*******************************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
    
    public static void clearScreen() {
        try {
            final String sistemaOperacional = System.getProperty("os.name");
            
            if (sistemaOperacional.contains("Windows")) Runtime.getRuntime().exec("cls");
            else Runtime.getRuntime().exec("clear");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void menuPayment() {
        System.out.println("Código de Pagamento:");
        System.out.println("1 À vista, com 8% de desconto");
        System.out.println("2 À vista no cartão, 4% de desconto");
        System.out.println("3 Em 2x, preço normal sem juros");
        System.out.println("4 Em 4x, preço acrescido de 8%");
    }
    
    public static float[] switchPayment(float valorCompra, int codigoPagamento) {
        float[] infoConta = new float[2];
        float totalConta = valorCompra, desconto = 0.0f, juros = 0.0f, parcelas = 0.0f;

        switch (codigoPagamento) {
            case 1:
                desconto = valorCompra * 0.08f;
                totalConta -= desconto;
                System.out.println("Desconto de 8%");
                System.out.println(String.format("Valor final: R$ %.2f", totalConta));
                infoConta[0] = totalConta;
                infoConta[1] = desconto;
                break;
            case 2:
                desconto = valorCompra * 0.04f;
                totalConta -= desconto;
                System.out.println("Desconto de 4%");
                System.out.println(String.format("Valor final: R$ %.2f", totalConta));
                infoConta[0] = totalConta;
                infoConta[1] = desconto;
                break;
            case 3:
                parcelas = valorCompra / 2.0f;
                System.out.println(String.format("Em 2x de R$ %.2f", parcelas));
                System.out.println(String.format("Valor final: R$ %.2f", totalConta));
                infoConta[0] = totalConta;
                infoConta[1] = juros;
                break;
            case 4:
                juros = valorCompra * 0.08f;
                totalConta += juros;
                parcelas = totalConta / 4.0f ;
                System.out.println(String.format("Em 2x de R$ %.2f", parcelas));
                System.out.println(String.format("Valor final: R$ %.2f", totalConta));
                infoConta[0] = totalConta;
                infoConta[1] = juros;
                break;
        }
        
        return infoConta;
    }
    
    public static void finishOrder() throws InputMismatchException {
        Scanner input = new Scanner(System.in);
		
		float valorCompra = 0.0f, totalAVista = 0.0f, totalDesconto = 0.0f, 
		totalParceladas = 0.0f, totalJuros = 0.0f;
		float[] obterConta = new float[2];
		int codigoPagamento = 0;
		
        for (int i = 1; i <= 5; i++) {
		    System.out.println(String.format("Compra 0%d", i));
		    System.out.print("Digite o valor total: ");
		    valorCompra = input.nextFloat();
		    menuPayment();
		    
		    System.out.print("Digite a forma de pagamento: ");
		    codigoPagamento = input.nextInt();
		    
		    if (codigoPagamento < 1 || codigoPagamento > 4) {
		        System.out.println("Opção inválida, a compra não será processada");
		        clearScreen();
		        continue;
		    }
		    
		    clearScreen();
		    obterConta = switchPayment(valorCompra, codigoPagamento);
		    
		    if (codigoPagamento <= 2) {
		        totalAVista += obterConta[0];
		        totalDesconto += obterConta[1];
		    } else {
		        totalParceladas += obterConta[0];
		        totalJuros += obterConta[1];
		    }
		   
		}
		
		System.out.println(String.format("Total de compras \"À vista\": R$ %.2f", totalAVista));
		System.out.println(String.format("Total de compras \"parceladas\": R$ %.2f", totalParceladas));
		
		System.out.println(String.format("Total de descontos: R$ %.2f", totalDesconto));
		System.out.println(String.format("Total de Juros: R$ %.2f", totalJuros));
    }

    
	public static void main(String[] args) {
		
		try {
		
    		finishOrder();
    		
		} catch (InputMismatchException ex) {
		    System.out.println("O valor informado nao e um numero valido.");
		}
		
	}
}