package multa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import multa.entity.Condutor;

public class CondutorDAO {
	
	private EntityManager entityManager;
	
	public CondutorDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multa").createEntityManager();
	}
	
	public Boolean save (Condutor condutor) {
		entityManager.getTransaction().begin();
		entityManager.persist(condutor);
		entityManager.getTransaction().commit();
		
		return true;
	}
	
	public Condutor findByCnh(String cnh) {
		return entityManager.find(Condutor.class, cnh);
	}
	
	public List<Condutor> findAll() {
		Query query = entityManager.createQuery("SELECT c FROM Condutor c");
		
		return query.getResultList();
	}
	
	public Boolean removeByCnh(String cnh) {
		Condutor condutor = entityManager.find(Condutor.class, cnh);
		
		if (condutor == null) {
			return false;
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(condutor);
		entityManager.getTransaction().commit();
		
		return true;
	}

}
