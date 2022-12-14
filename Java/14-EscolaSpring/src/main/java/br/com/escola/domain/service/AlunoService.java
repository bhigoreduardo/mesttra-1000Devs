package br.com.escola.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.escola.domain.model.Aluno;
import br.com.escola.domain.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno save(Aluno aluno) {
		try {
			return alunoRepository.save(aluno);
		} catch (DataIntegrityViolationException ex) {
			throw new RuntimeException(String.format("Aluno CPF %s já cadastrado.", aluno.getCpf()));
		}
	}

	public Aluno findById(Long matricula) {
		return alunoRepository.findById(matricula).orElseThrow(
				() -> new RuntimeException(String.format("Aluno matrícula %d não foi encontrado.", matricula)));
	}

	public void deleteById(Long matricula) {
		try {
			alunoRepository.deleteById(matricula);
		} catch (EmptyResultDataAccessException ex) {
			throw new RuntimeException(String.format("Aluno matrícula %d não foi encontrado.", matricula));
		} catch (DataIntegrityViolationException ex) {
			throw new RuntimeException(String.format("Aluno matrícula %d está em uso.", matricula));
		}
	}

	public Aluno findByCpf(String cpf) {
		return alunoRepository.findByCpf(cpf)
				.orElseThrow(() -> new RuntimeException(String.format("Aluno CPF %s não foi encontrado.", cpf)));
	}

}
