package dao;

import java.util.List;

import entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProfessorDAO {

	private EntityManager entityManager;

	public ProfessorDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}

	public Boolean save(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.getTransaction().commit();

		return true;
	}

	public List<Professor> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM Professor p");

		return query.getResultList();
	}

	public Professor findByCodigo(int codFuncionario) {
		return entityManager.find(Professor.class, codFuncionario);
	}

	public Boolean removeByCodigo(int codFuncionario) {
		Professor professor = entityManager.find(Professor.class, codFuncionario);

		if (professor == null) {
			return false;
		}

		entityManager.getTransaction().begin();
		entityManager.remove(professor);
		entityManager.getTransaction().commit();

		return true;
	}
}
