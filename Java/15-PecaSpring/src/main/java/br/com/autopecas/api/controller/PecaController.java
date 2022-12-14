package br.com.autopecas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.autopecas.api.model.PecaDTO;
import br.com.autopecas.api.model.PecaDTOInput;
import br.com.autopecas.domain.service.PecaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/pecas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PecaController {

	@Autowired
	private PecaService pecaService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public PecaDTO insertPeca(@RequestBody @Valid PecaDTOInput pecaDTOInput) {
		return pecaService.save(pecaDTOInput);
	}

	@PutMapping("/{codBarras}")
	public PecaDTO updatePeca(@PathVariable Long codBarras, @RequestBody @Valid PecaDTOInput pecaDTOInput) {
		return pecaService.update(codBarras, pecaDTOInput);
	}

	@PutMapping("/{codBarras}/categoria/{categoria}")
	public void updatePecaCategoria(@PathVariable Long codBarras, @PathVariable String categoria) {
		pecaService.updateCategoria(codBarras, categoria);
	}

	@GetMapping
	public List<PecaDTO> findAll() {
		return pecaService.findAll();
	}

	@GetMapping("/{codBarras}")
	public PecaDTO findById(@PathVariable Long codBarras) {
		return pecaService.findById(codBarras);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{codBarras}")
	public void deleteById(@PathVariable Long codBarras) {
		pecaService.deleteById(codBarras);
	}

}
