package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import br.mhvalente.domain.Grupo;

public class GrupoDAO {
	private EntityManager em;
	private Session session;
	
	public GrupoDAO() {
		em = Conexao.getConexao();
		session = em.unwrap(Session.class);
	}
	
	public Grupo salvar(Grupo grupo) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		
		try {
			grupo = em.merge(grupo);
			transacao.commit();
			
			return grupo;
		} catch (Exception e) {
			transacao.rollback();
			throw e;
		}
	}

}
