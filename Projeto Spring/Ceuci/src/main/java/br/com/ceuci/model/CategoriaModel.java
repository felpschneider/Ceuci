package br.com.ceuci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String horta;

	@NotNull
	private String mercearia;
	
	@NotNull
	private String misto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String isHorta() {
		return horta;
	}

	public void setHorta(String horta) {
		this.horta = horta;
	}

	public String isMercearia() {
		return mercearia;
	}

	public void setMercearia(String mercearia) {
		this.mercearia = mercearia;
	}

	public String isMisto() {
		return misto;
	}

	public void setMisto(String misto) {
		this.misto = misto;
	}

	
}
