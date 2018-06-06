package br.mhvalente.config_hibernate;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.mhvalente.dao.CidadeDAO;
import br.mhvalente.dao.GrupoDAO;
import br.mhvalente.dao.PessoaDAO;
import br.mhvalente.dao.VeiculoDAO;
import br.mhvalente.domain.Cidade;
import br.mhvalente.domain.Grupo;
import br.mhvalente.domain.Pessoa;
import br.mhvalente.domain.Veiculo;

public class Principal {

	public static void main(String[] args) throws Exception {
				
		Cidade tb = new Cidade();
		tb.setNomeCidade("Maringa");
		tb.setUfCidade("PR");
		
		PessoaDAO dao = new PessoaDAO();
		CidadeDAO daoCidade = new CidadeDAO();
		
		//Cadastrar Cidade
		try {
			tb = daoCidade.salvar(tb);
			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso ! " + tb.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		Pessoa pes = new Pessoa();
		pes.setPrimeiroNome("Matheus");
		pes.setUltimoNome("Henrique");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.98);
		pes.setCidade(tb);
		
		Grupo grupo = new Grupo();
		grupo.setDsGrupo("BEBIDAS");
		
		//GrupoDAO daoGrupo = new GrupoDAO();
		
		//Cadastrar Grupo
		try {
			//grupo = daoGrupo.salvar(grupo);
			//JOptionPane.showMessageDialog(null, "Grupo cadastrado com sucesso " + grupo.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Cadastrar pessoa
		try {
			pes = dao.salvar(pes);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso " + pes.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		//Excluir pessoa
		try {
			//dao.excluir(pes);	
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		//Cadastrar Veiculo
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("AXT-7393");
		veiculo.setRenavam("0000123456322");
		veiculo.setPessoa(pes);
		
		VeiculoDAO daoVeiculo = new VeiculoDAO();
		
		try {
			veiculo = daoVeiculo.salvar(veiculo);
			JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso " + veiculo.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		//Consultar pessoa
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
