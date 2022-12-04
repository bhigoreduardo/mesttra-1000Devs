package escola.domain.dao;

import java.util.List;

import escola.domain.entity.Aluno;
import escola.domain.entity.Professor;
import escola.domain.entity.Sala;
import escola.domain.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TurmaDAO {

	private EntityManager entityManager;

	public TurmaDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}

	public Boolean criarTurma(Sala sala) {
		Turma turma = new Turma();
		turma.setSala(sala);
		sala.setTurma(turma);

		entityManager.getTransaction().begin();
		;
		entityManager.persist(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public Boolean adicionarProfessor(Professor professor, int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return false;
		}

		if (turma.getProfessor() != null) {
			return false;
		}

		turma.setProfessor(professor);

		entityManager.getTransaction().begin();
		;
		entityManager.merge(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public Boolean adicionarAluno(Aluno aluno, int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return false;
		}

		if (turma.getProfessor() == null) {
			return false;
		}

		List<Aluno> alunos = turma.getAlunos();
		alunos.add(aluno);
		turma.setAlunos(alunos);

		entityManager.getTransaction().begin();
		entityManager.merge(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public void listarAlunos(int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return;
		}
		
		for (Aluno aluno : turma.getAlunos()) {
			System.out.println(aluno.toString());
		}
	}
	
	public List<Turma> listarTurmas() {
		Query query = entityManager.createQuery("SELECT t FROM Turma t");
		return query.getResultList();
	}
	
	public Boolean deleterTurma(int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);
		
		if (turma == null) {
			return false;
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(turma);
		entityManager.getTransaction().commit();
		
		return true;
	}

}
