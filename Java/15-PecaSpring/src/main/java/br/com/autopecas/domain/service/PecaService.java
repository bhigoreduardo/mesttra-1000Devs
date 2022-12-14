package br.com.autopecas.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.autopecas.api.model.PecaDTO;
import br.com.autopecas.api.model.PecaDTOInput;
import br.com.autopecas.domain.exception.NegocioException;
import br.com.autopecas.domain.model.Peca;
import br.com.autopecas.domain.repository.PecaRepository;
import jakarta.transaction.Transactional;

@Service
public class PecaService {

	@Autowired
	private PecaRepository pecaRepository;

	public PecaDTO save(PecaDTOInput pecaDTOInput) {
		Peca peca = pecaRepository.save(pecaDTOInput.toEntity());
		PecaDTO pecaDTO = new PecaDTO();
		BeanUtils.copyProperties(peca, pecaDTO);

		return pecaDTO;
	}

	public PecaDTO update(Long codBarras, PecaDTOInput pecaDTOInput) {
		Peca peca = pecaRepository.findById(codBarras)
				.orElseThrow(() -> new NegocioException(String.format("Peça cód. %d não foi encontrada.", codBarras)));
		BeanUtils.copyProperties(pecaDTOInput, peca, "codBarras");
		peca = pecaRepository.save(peca);
		
		PecaDTO pecaDTO = new PecaDTO();
		BeanUtils.copyProperties(peca, pecaDTO);

		return pecaDTO;
	}

	@Transactional
	public void updateCategoria(Long codBarras, String categoria) {
		Peca peca = pecaRepository.findById(codBarras)
				.orElseThrow(() -> new NegocioException(String.format("Peça cód. %d não foi encontrada.", codBarras)));
		
		peca.setCategoria(categoria);
	}

	public List<PecaDTO> findAll() {
		return pecaRepository.findAll().stream()
				.map(peca -> findById(peca.getCodBarras()))
				.collect(Collectors.toList());
	}

	public PecaDTO findById(Long codBarras) {
		Peca peca = pecaRepository.findById(codBarras)
				.orElseThrow(() -> new NegocioException(String.format("Peça cód. %d não foi encontrada.", codBarras)));
		PecaDTO pecaDTO = new PecaDTO();
		BeanUtils.copyProperties(peca, pecaDTO);

		return pecaDTO;
	}

	public void deleteById(Long codBarras) {
		try {
			pecaRepository.deleteById(codBarras);
		} catch (DataIntegrityViolationException ex) {
			throw new NegocioException(String.format("Peça cód. %d está em uso.", codBarras));
		} catch (EmptyResultDataAccessException ex) {
			throw new NegocioException(String.format("Peça cód. %d não foi encontrada.", codBarras));
		}
	}

}
