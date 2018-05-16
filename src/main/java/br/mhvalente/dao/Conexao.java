package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexao {
	public static EntityManager getConexao() {
		//É uma interface responsavel para fazer a conexao com o banco
		return Persistence.createEntityManagerFactory("AulaPU").createEntityManager();
	}
}
