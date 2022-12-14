package br.com.escola.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escola.domain.model.Aluno;
import br.com.escola.domain.repository.AlunoRepository;
import br.com.escola.domain.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoService alunoService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertAluno(@RequestBody Aluno aluno) {
		try {
			aluno = alunoService.save(aluno);

			return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@PutMapping(path = "/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		try {
			Aluno alunoCurrent = alunoService.findById(matricula);

			BeanUtils.copyProperties(aluno, alunoCurrent, "matricula");

			return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(alunoCurrent));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

	@GetMapping(path = "/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable Long matricula) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(matricula));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Aluno> findAll() {
		long inicio = System.nanoTime();
		List<Aluno> alunos = alunoRepository.findAll();
		long fim = System.nanoTime();

		System.out.println("Tempo decorrido em milisegundos " + (fim - inicio));

		return alunos;
	}

	@DeleteMapping("/{matricula}")
	public ResponseEntity<?> deleteById(@PathVariable Long matricula) {
		try {
			alunoService.deleteById(matricula);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

	@GetMapping("/{cpf}/busca-cpf")
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		try {
			Aluno aluno = alunoService.findByCpf(cpf);

			return ResponseEntity.status(HttpStatus.OK).body(aluno);
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

}
