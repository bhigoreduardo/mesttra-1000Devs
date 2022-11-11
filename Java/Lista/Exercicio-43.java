/******************************************************************************
Desenvolva um algoritmo para ler o nome, a idade, o sexo de 03 (três) indivíduos 
e imprimir “XXXX é criança”, se a idade for menor ou igual a 13 anos, “XXXX é 
adolescente”, no caso de idade estar entre 13 e 20 anos, e “XXX é adulto”, se for
até a idade 50 anos e "XXX é da melhor idade" acima de 50 anos. XXX deve ser 
substituído pelo nome do indivíduo. No caso do sexo, o individuo pode digitar: 
F, f, m ou M. O algoritmo também deve imprimir ao final a quantidade de indivíduos
que são crianças, adolescentes, adultos e melhor idade. Deve ser informado também 
o nome do indivíduo mais Velho. Qualquer exceção no código deve ser tratada com 
um try catch.
*******************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    int totalCriancas = 0, totalAdolescentes = 0, totalAdultos = 0,
	    totalMelhorIdade = 0, idadeMaisVelho = 0;
	    String nomeMaisVelho = "";
		
		try {
    		for (int i = 1; i <= 3; i++) {
    		    System.out.print(String.format("Digite o nome do indivíduo 0%d: ", i));
    		    String nome = input.nextLine();
    		    
    		    for (int j = 0; j < nome.length(); j++) {
    		        if (Character.isDigit(nome.charAt(j))) {
    		            throw new IllegalAccessException("Nome nao e valido");
    		        }
    		    }
    		    
    		    System.out.print(String.format("Digite a idade do(a) %s: ", nome));
    		    int idade = input.nextInt();
    		    System.out.print(String.format("Digite o sexo do(a) %s: ", nome));
    		    char sexo = input.next().toUpperCase().charAt(0);
    		    
    		    if (Character.isDigit(sexo)) {
    		        throw new IllegalAccessException("Sexo nao e valido");
    		    }
    		    input.nextLine();
    		    
    		    if (idade <= 13) {
    		        totalCriancas++;
    		        System.out.println(String.format("%s e crianca", nome));
    		    }
    		    else if (idade <= 20) {
    		        totalAdolescentes++;
    		        System.out.println(String.format("%s e adolescente", nome));
    		    }
    		    else if (idade <= 50) {
    		        totalAdultos++;
    		        System.out.println(String.format("%s e adulto", nome));
    		    }
    		    else {
    		        totalMelhorIdade++;
    		        System.out.println(String.format("%s e da melhor idade", nome));
    		    };
    		    
    		    if (i == 1 || idadeMaisVelho < idade) {
    		        idadeMaisVelho = idade;
    		        nomeMaisVelho = nome;
    		    }
    		}
		
    		System.out.println(String.format("Total de criancas: %d", totalCriancas));
    		System.out.println(String.format("Total de adolescentes: %d", totalAdolescentes));
    		System.out.println(String.format("Total de adultos: %d", totalAdultos));
    		System.out.println(String.format("Total de melhor idade: %d", totalMelhorIdade));
    		System.out.println(String.format("O nome do indivíduo mais velho e: %s", nomeMaisVelho));
		} catch (InputMismatchException ex) {
		    System.out.println("Idade nao e valida.");
		} catch (IllegalAccessException ex) {
		    System.out.println(ex.getMessage());
		}
		
	}
}