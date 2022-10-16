/******************************************************************************
Questão 09: Faça um algoritmo que leia os dados necessários para calcular e exibir
a área:
a) de um trapézio. Sabe-se que: A = ((base maior + base menor) * altura)/2 ;
b) de um quadrado. Sabe-se que: A = lado * lado;
c) de um retangulo. Sabe-se que: A = largura * altura;
d) de um círculo. Sabe-se que: A = 3.14 * raio * raio;
e) de um triangulo. Sabe-se que: A = (base * altura) / 2;
O seu algoritmo deve apresentar ao final da execução qual foi o nome do Objeto
com a maior área bem como a área deste objeto.
*******************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class Main
{
    public static float calcularTrapezio() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Area do trapezio");
        System.out.print("Informe o valor da base maior: ");
        float baseMaior = input.nextFloat();
        System.out.print("Informe o valor da base menor: ");
        float baseMenor = input.nextFloat();
        System.out.print("Informe a altura: ");
        float altura = input.nextFloat();
        
        return (baseMaior+baseMenor)*altura/2.0f;
    }
    
    public static float calcularQuadrado() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Area do quadrado");
        System.out.print("Informe o valor de um dos lados: ");
        float lado = input.nextFloat();
        
        return lado * lado;
    }
    
    public static float calcularRetangulo() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Area do retangulo");
        System.out.print("Informe o valor da largura: ");
        float lagura = input.nextFloat();
        System.out.print("Informe a altura: ");
        float altura = input.nextFloat();
        
        return lagura*altura;
    }
    
    public static float calcularCirculo() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Area do circulo");
        System.out.print("Informe o valor do raio: ");
        float raio = input.nextFloat();
        
        return ((float)Math.PI)*raio*raio;
    }
    
    public static float calcularTriangulo() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Area do triangulo");
        System.out.print("Informe o valor da base: ");
        float base = input.nextFloat();
        System.out.print("Informe o valor da altura: ");
        float altura = input.nextFloat();
        
        return base*altura/2.0f;
    }
    
	public static void main(String[] args) {
	    String areaMaior = "";
	    int index = 0;
	    float maior = 0.0f;
		float[] areas = new float[5];
		
		try {
		    areas[0] = calcularTrapezio();
    		areas[1] = calcularQuadrado();
    		areas[2] = calcularRetangulo();
    		areas[3] = calcularCirculo();
    		areas[4] = calcularTriangulo();
    		
    		for(int i = 0; i < areas.length; i++) {
    		    if (i == 0 || areas[i] > maior) {
    		        index = i;
    		        maior = areas[i];
    		    }
    		}
    		
    		switch (index) {
    		    case 0: areaMaior = "Trapezio"; break;
		        case 1: areaMaior = "Quadrado"; break;
	            case 2: areaMaior = "Retangulo"; break;
                case 3: areaMaior = "Circulo"; break;
                case 4: areaMaior = "Triangulo"; break;
    		}
    		
    		System.out.printf("O objeto com a maior area e o %s com %.2f de area.",
    		areaMaior, maior);
    		
		} catch (Exception ex) {
		    System.out.println(ex.getMessage());
		}
		
	}
}