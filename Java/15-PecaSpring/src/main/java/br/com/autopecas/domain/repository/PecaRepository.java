package br.com.autopecas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autopecas.domain.model.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    public List<Peca> findByNomeStartingWith(String texto);

    public List<Peca> findByModeloCarro(String modelo);

    public List<Peca> findByCategoria(String categoria);

}
