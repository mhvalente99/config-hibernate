package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import br.mhvalente.domain.Veiculo;

public class VeiculoDAO {
	private EntityManager em;
	private Session session;
	
	public VeiculoDAO() {
		em = Conexao.getConexao();
		session = em.unwrap(Session.class); 
	}
	
	public Veiculo salvar(Veiculo veiculo) throws Exception {
		EntityTransaction trasaction = em.getTransaction();
		trasaction.begin();
		
		try {
			veiculo = em.merge(veiculo);
		
			trasaction.commit();
			return veiculo;
		} catch (Exception e) {
			trasaction.rollback();
			
			throw e;
		}
	}
}
