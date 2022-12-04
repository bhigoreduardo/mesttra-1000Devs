package main;

import java.time.LocalDate;

import dao.ProfessorDAO;
import dao.TurmaDAO;
import entity.Aluno;
import entity.Professor;
import entity.Sala;
import entity.Turma;

public class Main {

	public static void main(String[] args) {

		TurmaDAO turmaDAO = new TurmaDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();

		// save Turma/Sala
		Sala sala = new Sala();
		sala.setAltura(3.1);
		sala.setComprimento(4.5);
		sala.setLargura(4.5);

		turmaDAO.save(sala);

		// save Professor
		Professor professor = new Professor();
		professor.setNome("Saitama");
		professor.setTelefone("19301231");
		professor.setSalario(12339.90);
		professor.setDisciplina("Heroismo");

		professorDAO.save(professor);

		// find Professor
		System.out.println(professorDAO.findByCodigo(1));

		// findAll Professor
		for (Professor p : professorDAO.findAll()) {
			System.out.println(p.toString());
		}

		// add Professor
		turmaDAO.addProfessor(professor, 1);

		// add Aluno
		Aluno aluno = new Aluno();
		aluno.setNome("Genos");
		aluno.setSerie("S");
		aluno.setDataNascimento(LocalDate.now());

		turmaDAO.addAluno(aluno, 1);

		// findAll Aluno
		turmaDAO.findAlunosByCodigo(1);

		// findAll Turma
		for (Turma t : turmaDAO.findAll()) {
			System.out.println(t.toString());
		}

	}

}
