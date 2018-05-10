package br.mhvalente.config_hibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		//É uma interface responsavel para fazer a conexao com o banco
		EntityManager entityManager = Persistence.createEntityManagerFactory("AulaPU").createEntityManager();
		
		EntityTransaction transacao = entityManager.getTransaction();
		
		transacao.begin();
		
		Pessoa pes = new Pessoa();
		pes.setCodigo(1L);
		pes.setPrimeiroNome("Jair");
		pes.setUltimoNome("Bolsonaro");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.98);
		
		entityManager.persist(pes); // Se tiver ele da update, se nao ele insere
		
		entityManager.close();
	}

}
