package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.mhvalente.domain.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAO() {
		//Abrir conexao com o banco
		em = Conexao.getConexao();
	}
	
	public Pessoa salvar(Pessoa pessoa) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		
		try {
			pessoa = em.merge(pessoa);
			transacao.commit();
			
			return pessoa;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
	
	public void excluir(Pessoa pessoa) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		
		try {
			em.remove(pessoa);
			transacao.commit();
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
	
}
