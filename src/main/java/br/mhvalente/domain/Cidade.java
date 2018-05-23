package br.mhvalente.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CIDADE")
public class Cidade {
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(name="nome_cidade", length=80, nullable= false)
	private String nomeCidade;
	
	@Column(name="uf_cidade", length=2, nullable= false)
	private String ufCidade;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}
}
