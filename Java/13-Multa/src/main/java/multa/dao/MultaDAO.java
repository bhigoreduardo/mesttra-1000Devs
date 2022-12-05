package multa.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import multa.entity.Condutor;
import multa.entity.Multa;
import multa.entity.Veiculo;

public class MultaDAO {

	private EntityManager entityManager;

	public MultaDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multa").createEntityManager();
	}

	public Boolean save(Multa multa, String placa) {
		Veiculo veiculo = entityManager.find(Veiculo.class, placa);

		if (veiculo == null) {
			return false;
		}
		
		Condutor condutor = entityManager.find(Condutor.class, veiculo.getCondutor().getNroCnh());
		
		// Reduntante
		if (condutor == null) {
			return false;
		}

		multa.setVeiculo(veiculo);

		List<Multa> multas = veiculo.getMultas();

		if (multas == null) {
			multas = new ArrayList<Multa>();
		}		

		multas.add(multa);
		veiculo.setMultas(multas);
		
		condutor.setPontuacao(condutor.getPontuacao() + multa.getPontuacao());

		entityManager.getTransaction().begin();
		entityManager.persist(multa);
		entityManager.getTransaction().commit();

		return true;
	}

	public Multa findByCodigo(String codigoMulta) {
		return entityManager.find(Multa.class, codigoMulta);
	}

	public List<Multa> findAll() {
		return entityManager.createQuery("SELECT m FROM Multa m")
				.getResultList();
	}

	public Boolean deleteByCodigo(String codigoMulta) {
		Multa multa = entityManager.find(Multa.class, codigoMulta);

		if (multa == null) {
			return false;
		}

		entityManager.getTransaction().begin();
		entityManager.remove(multa);
		entityManager.getTransaction().commit();

		return true;
	}

}
