package escola.domain.dao;

import java.util.List;

import escola.domain.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProfessorDAO {

	private EntityManager entityManager;

	public ProfessorDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}

	public Boolean criarProfessor(Professor Professor) {
		entityManager.getTransaction().begin();;
		entityManager.persist(Professor);
		entityManager.getTransaction().commit();

		return true;
	}

	public Professor consularProfessor(int matricula) {
		return entityManager.find(Professor.class, matricula);
	}

	public List<Professor> listarProfessores() {
		Query query = entityManager.createQuery("SELECT p FROM Professor p");
		return query.getResultList();
	}

	public Boolean deletarProfessor(int matricula) {
		Professor professor = entityManager.find(Professor.class, matricula);

		if (professor == null) {
			return false;
		}

		entityManager.getTransaction().begin();;
		entityManager.remove(professor);
		entityManager.getTransaction().commit();

		return true;
	}

}
