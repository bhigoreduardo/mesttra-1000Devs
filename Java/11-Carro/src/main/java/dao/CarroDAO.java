package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Carro;

public class CarroDAO {

	private EntityManager manager;

	public CarroDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		this.manager = factory.createEntityManager();
	}

	public boolean save(Carro carro) {
		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();

		return true;
	}

	public List<Carro> selectAll() {
		Query query = this.manager.createQuery("select c from Carro as c");
		return query.getResultList();
	}

	public Carro selectByPlaca(String placa) {
		return this.manager.find(Carro.class, placa);
	}

	public boolean deleteByPlaca(String placa) {
		Carro carro = this.manager.find(Carro.class, placa);

		if (carro != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(carro);
			this.manager.getTransaction().commit();

			return true;
		}

		return false;
	}

	/*
	 * public boolean update(Carro carro) { status = false; query =
	 * "UPDATE carro SET cor=?, marca=?, modelo=? WHERE placa=?";
	 * 
	 * try { connection = ConnectionFactory.getConnection(); statement =
	 * connection.prepareStatement(query);
	 * 
	 * setParameter(statement, carro); statement.execute();
	 * 
	 * status = true; } catch (Exception ex) { throw new
	 * RuntimeException("Falha ao atualizar o carro." + ex.getMessage()); } finally
	 * { ConnectionFactory.closeConnection(connection, statement); }
	 * 
	 * ConnectionFactory.closeConnection(connection, statement); return status; }
	 */

}
