import java.util.Scanner;

public class Main
{
    public static boolean verificarQuantidade(String senha, int quantidadeMin,
    String listaCaracteres) {
        int quantidade = 0;
        
        for(int i = 0; i < senha.length(); i++) {
            for(int j = 0; j < listaCaracteres.length(); j++) {
                if(senha.charAt(i) == listaCaracteres.charAt(j)) quantidade++;
            }
        }
        
        return quantidade >= quantidadeMin;
    }
    
    public static boolean validarMinusculas(String senha, int quantidadeMin) {
        return verificarQuantidade(senha, quantidadeMin, "abcdefghijklmnopqrstuvxywz");
    }
    
    public static boolean validarMaiusculas(String senha, int quantidadeMin) {
        return verificarQuantidade(senha, quantidadeMin, "ABCDEFGHIJKLMNOPQRKSTUVXYWZ");
    }
    
    public static boolean validarDigitos(String senha, int quantidadeMin) {
        return verificarQuantidade(senha, quantidadeMin, "0123456789");
    }
    
    public static boolean validarEspeciais(String senha, int quantidadeMin) {
        return verificarQuantidade(senha, quantidadeMin, " \'\"!@#$%¨&*()_-+=§|\\´`[{ª^~}]º,<.>;:/?°");
    }
    
    public static String sequenciaRepetida(char caracter, int quantidadeMin) {
        String sequencia = "";
        
        for(int i = 0; i < quantidadeMin; i++) {
            sequencia += String.valueOf(caracter);
        }
        
        return sequencia;
    }
    
    public static boolean validarSequencia(String senha, int quantidadeMin) {
        for(int i = 32; i <= 126; i++) {
            String sequencia = sequenciaRepetida((char) i, quantidadeMin);
            if(senha.contains(sequencia)) return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
	    boolean validaMinusculas, validaMaiusculas, validaDigitos, validaEspeciais,
	    validaSequencia;
	    
	    String menssagem;
	    
	    try (Scanner input = new Scanner(System.in)) {
	        System.out.print("Digite sua senha: ");
	        String senha = input.nextLine();
	        
	        validaMinusculas = validarMinusculas(senha, 3);
	        validaMaiusculas = validarMaiusculas(senha, 3);
	        validaDigitos = validarDigitos(senha, 3);
	        validaEspeciais = validarEspeciais(senha, 3);
	        validaSequencia = validarSequencia(senha, 3);
	        
	        menssagem = "Senha invalida.";
	        if(!validaMinusculas) menssagem += "\nSenha deve possuir 3 Minusculas.";
	        if(!validaMaiusculas) menssagem += "\nSenha deve possuir 3 Maiusculas.";
	        if(!validaDigitos) menssagem += "\nSenha deve possuir 3 Digitos.";
	        if(!validaEspeciais) menssagem += "\nSenha deve possuir 3 Especiais.";
	        if(!validaSequencia) menssagem += "\nSenha não deve repetir 3 caracteres.";
	        
	        if(validaMinusculas && validaMaiusculas && validaDigitos && validaEspeciais &&
	        validaSequencia) menssagem = "Senha valida";
	        
	        System.out.println(menssagem);
	    }
	}
}