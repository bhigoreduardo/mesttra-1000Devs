package escola.domain.dao;

import java.util.List;

import escola.domain.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AlunoDAO {

	private EntityManager entityManager;

	public AlunoDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}

	public Boolean criarAluno(Aluno aluno) {
		entityManager.getTransaction().begin();;
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();

		return true;
	}

	public Aluno consularAluno(int matricula) {
		return entityManager.find(Aluno.class, matricula);
	}

	public List<Aluno> listarAlunos() {
		Query query = entityManager.createQuery("SELECT a FROM Aluno a");
		return query.getResultList();
	}

	public Boolean deletarAluno(int matricula) {
		Aluno aluno = entityManager.find(Aluno.class, matricula);

		if (aluno == null) {
			return false;
		}

		entityManager.getTransaction().begin();;
		entityManager.remove(aluno);
		entityManager.getTransaction().commit();

		return true;
	}

}
