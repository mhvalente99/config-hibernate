package br.mhvalente.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRUPO")
public class Grupo {
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(name="DS_GRUPO")
	private String dsGrupo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDsGrupo() {
		return dsGrupo;
	}

	public void setDsGrupo(String dsGrupo) {
		this.dsGrupo = dsGrupo;
	}
}
