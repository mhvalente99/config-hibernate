package br.mhvalente.config_hibernate;

import java.util.Date;

import javax.swing.JOptionPane;

import br.mhvalente.dao.PessoaDAO;
import br.mhvalente.domain.Pessoa;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Pessoa pes = new Pessoa();
		pes.setCodigo(1L);
		pes.setPrimeiroNome("Jair");
		pes.setUltimoNome("Bolsonaro");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.98);
		
		PessoaDAO dao = new PessoaDAO();
		
		try {
			pes = dao.salvar(pes);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso " + pes.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			dao.excluir(pes);	
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
