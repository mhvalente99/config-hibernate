package br.mhvalente.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.mhvalente.domain.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;
	private Session session;
	
	public PessoaDAO() {
		//Abrir conexao com o banco
		em = Conexao.getConexao();
		
		//Extrai a sessão do banco
		session = em.unwrap(Session.class);
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
	
	public List<Pessoa> buscarTodos(){
		return session.createCriteria(Pessoa.class).list();
	}
	
	public Pessoa buscarPessoa(Long codigo) {
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.eq("codigo", codigo));
		return (Pessoa) criteria.uniqueResult();
	}
	
	public List<Pessoa> buscarPessoa(String nome) {
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.like("primeiroNome", nome, MatchMode.ANYWHERE ));
		return criteria.list();
	}
	
}
