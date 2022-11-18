package topic.jdbc.cidade;

import topic.jdbc.cidade.dao.CidadeDAO;
import topic.jdbc.cidade.pojo.Cidade;

public class Main {

	public static void main(String[] args) {

		// Criando os objetos
		Cidade saoPaulo = new Cidade(11, "São Paulo", 123456, 12645.00, "São Paulo", "Bolsonaro");
		saoPaulo.setCapital(true);
		
		Cidade vitoria = new Cidade(22, "Vitória", 14654, 468798.00, "Espírito Santo", "Lula");
		vitoria.setCapital(true);
		
		Cidade cariacica = new Cidade(27, "Cariacica", 68795, 21654.66, "Espiríto Santo", "Marina");
		Cidade pindamaoigaba = new Cidade(12, "Pindamoigaba", 87956, 5468.66, "São Paulo", "José Sarney");
				
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// Inserindo no Banco
		cidadeDAO.insertInto(saoPaulo);
		cidadeDAO.insertInto(vitoria);
		cidadeDAO.insertInto(cariacica);
		cidadeDAO.insertInto(pindamaoigaba);
		
		// Recuperando Todos objetos
		System.out.println("Todas as cidades:");
		cidadeDAO.selectAll().forEach(cidade -> {
			System.out.println(cidade.toString());
		});
		
		// Recuperando Único Objeto
		System.out.println("Cidade DDD 22:");
		System.out.println(
				cidadeDAO.selectByDdd(22).toString()
				);

		// Alterando Objeto
		pindamaoigaba.setPrefeito("Jão Frango");
		cidadeDAO.update(pindamaoigaba);
		
		// Excluindo Objeto
		cidadeDAO.delete(27);
		
	}

}
