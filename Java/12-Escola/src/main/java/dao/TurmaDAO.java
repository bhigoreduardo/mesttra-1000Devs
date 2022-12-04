package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;
import entity.Professor;
import entity.Sala;
import entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TurmaDAO {

	private EntityManager entityManager;

	public TurmaDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}

	public Boolean save(Sala sala) {
		Turma turma = new Turma();
		turma.setSala(sala);
		sala.setTurma(turma);

		entityManager.getTransaction().begin();
		entityManager.persist(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public Boolean addProfessor(Professor professor, int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return false;
		}

		if (turma.getProfessor() != null) {
			return false;
		}

		turma.setProfessor(professor);

		entityManager.getTransaction().begin();
		entityManager.merge(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public Boolean addAluno(Aluno aluno, int codTurma) {
		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return false;
		}

		if (turma.getProfessor() == null) {
			return false;
		}

		List<Aluno> alunos = turma.getAlunos();

		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}

		alunos.add(aluno);
		turma.setAlunos(alunos);

		List<Turma> turmas = aluno.getTurmas();

		if (turmas == null) {
			turmas = new ArrayList<Turma>();
		}

		turmas.add(turma);
		aluno.setTurmas(turmas);

		entityManager.getTransaction().begin();
		entityManager.merge(turma);
		entityManager.getTransaction().commit();

		return true;
	}

	public void findAlunosByCodigo(int codTurma) {

		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null) {
			return;
		}

		for (Aluno aluno : turma.getAlunos()) {
			System.out.println(aluno);
		}
	}

	public List<Turma> findAll() {
		Query query = entityManager.createQuery("select t from Turma as t");

		return query.getResultList();
	}

	public boolean removeByCodigo(int codTurma) {

		Turma turma = entityManager.find(Turma.class, codTurma);

		if (turma == null)
			return false;

		entityManager.getTransaction().begin();
		entityManager.remove(turma);
		entityManager.getTransaction().commit();

		return true;
	}

}
