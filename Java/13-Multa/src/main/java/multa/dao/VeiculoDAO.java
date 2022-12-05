package multa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import multa.entity.Condutor;
import multa.entity.Multa;
import multa.entity.Veiculo;

public class VeiculoDAO {
	
	private EntityManager entityManager;
	
	public VeiculoDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multa").createEntityManager();
	}
	
	public Boolean save(Veiculo veiculo, String nroCnh) {
		Condutor condutor = entityManager.find(Condutor.class, nroCnh);
		
		if (condutor == null) {
			return false;
		}
		
		veiculo.setCondutor(condutor);
		condutor.setVeiculo(veiculo);
		
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();
		
		return true;
	}
	
	public Veiculo findByPlaca(String placa) {
		return entityManager.find(Veiculo.class, placa);
	}
	
	public List<Veiculo> findAll() {
		return entityManager.createQuery("SELECT v FROM Veiculo v")
				.getResultList();
	}
	
	public Boolean removeByPlaca(String placa) {
		Veiculo veiculo = entityManager.find(Veiculo.class, placa);
		
		if (veiculo == null) {
			return false;
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(veiculo);
		entityManager.getTransaction().commit();
		
		return true;
	}
	
	public Boolean addVendaVeiculo(String placa, String cnhComprador) {
		Veiculo veiculo = findByPlaca(placa);
		
		if (veiculo == null) {
			return false;
		}
		
		Condutor condutorOrigem = entityManager.find(Condutor.class, veiculo.getCondutor().getNroCnh());
		Condutor condutorDestino = entityManager.find(Condutor.class, cnhComprador);
		
		if (condutorOrigem == null || condutorDestino == null) {
			return false;
		}
		
		veiculo.setCondutor(condutorDestino);
		condutorOrigem.setVeiculo(null);
		condutorDestino.setVeiculo(veiculo);
		
		entityManager.getTransaction().begin();
		entityManager.merge(veiculo);
		entityManager.getTransaction().commit();
		
		return true;
	}
	
	public void findMultasByPlaca(String placa) {
		Veiculo veiculo = entityManager.find(Veiculo.class, placa);
		
		if (veiculo == null) {
			return;
		}
		
		List<Multa> multas = veiculo.getMultas();
		
		for (Multa multa : multas) {
			multa.toString();
		}
	}
}
