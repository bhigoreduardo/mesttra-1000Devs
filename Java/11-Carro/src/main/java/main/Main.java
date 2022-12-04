package main;

import dao.CarroDAO;
import model.Carro;

public class Main {

	public static void main(String[] args) {
		
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		//factory.close();
		
		CarroDAO carroDAO = new CarroDAO();
		
		Carro carro = new Carro("ABH", "PRETO", "VW", "GOL", 160.0);
		carroDAO.save(carro);

	}

}
