package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import br.mhvalente.domain.Cidade;

public class CidadeDAO {
	private EntityManager em;
	private Session session;
	
	public CidadeDAO() {
		em = Conexao.getConexao();
		session = em.unwrap(Session.class);
	}
	
	public Cidade salvar(Cidade cidade) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		
		try {
			cidade = em.merge(cidade);
			transacao.commit();
			
			return cidade;
		} catch (Exception e) {
			transacao.rollback();
			throw e;
		}
	}
	
}
