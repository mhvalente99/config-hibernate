package br.mhvalente.config_hibernate;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.mhvalente.dao.PessoaDAO;
import br.mhvalente.domain.Pessoa;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Pessoa pes = new Pessoa();
		pes.setPrimeiroNome("Michel");
		pes.setUltimoNome("Temer");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.98);
		
		PessoaDAO dao = new PessoaDAO();
		
		try {
			//pes = dao.salvar(pes);
			//JOptionPane.showMessageDialog(null, "Cadastrado com sucesso " + pes.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			//dao.excluir(pes);	
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		List<Pessoa> pessoas = dao.buscarTodos();
		
		System.out.println("CONSULTANDO PESSOAS");
		System.out.println("===================");
		
		for (Pessoa p : pessoas) {
			System.out.println(" Código: " + p.getCodigo() +
							  " Nome: " + p.getPrimeiroNome());
			System.out.println("-------------------------");
		}
		
		pes = dao.buscarPessoa(1L);
		
		System.out.println("CONSULTANDO PESSOA POR CODIGO");
		System.out.println("=============================");
		System.out.println(" Código: " + pes.getCodigo() +
				  " Nome: " + pes.getPrimeiroNome());
		System.out.println("-------------------------");
		
		pessoas = dao.buscarPessoa("Jair");
		
		System.out.println("CONSULTANDO PESSOA POR NOME");
		System.out.println("===================");
		
		for (Pessoa p : pessoas) {
			System.out.println(" Código: " + p.getCodigo() +
							  " Nome: " + p.getPrimeiroNome());
			System.out.println("-------------------------");
		}
		
		
	}

}
